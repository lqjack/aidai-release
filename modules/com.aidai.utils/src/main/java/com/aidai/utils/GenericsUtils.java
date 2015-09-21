package com.aidai.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenericsUtils {
	private static final Logger log = LoggerFactory.getLogger(GenericsUtils.class);

	private GenericsUtils() {
	}
	/**
	 * 通过反射,获得指定类的父类的泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>
	 * @param clazz clazz 需要反射的类,该类必须继承范型父类
	 * @param index 泛型参数所在索引,从0开始.
	 * @return 范型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz, int index) {
		Type genType = clazz.getGenericSuperclass();// 得到泛型父类
		// 如果没有实现ParameterizedType接口，即不支持泛型，直接返回Object.class
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		// 返回表示此类型实际类型参数的Type对象的数组,数组里放的都是对应类型的Class, 如BuyerServiceBean extends
		// DaoSupport<Buyer,Contact>就返回Buyer和Contact类型
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}
	/**
	 * 通过反射,获得指定类的父类的第一个泛型参数的实际类型. 如BuyerServiceBean extends DaoSupport<Buyer>
	 * @param clazz clazz 需要反射的类,该类必须继承泛型父类
	 * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}
	/**
	 * 通过反射,获得方法返回值泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
	 * @param Method method 方法
	 * @param int index 泛型参数所在索引,从0开始.
	 * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getMethodGenericReturnType(Method method, int index) {
		Type returnType = method.getGenericReturnType();
		if (returnType instanceof ParameterizedType) {
			ParameterizedType type = (ParameterizedType) returnType;
			Type[] typeArguments = type.getActualTypeArguments();
			if (index >= typeArguments.length || index < 0) {
				throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
			}
			return (Class) typeArguments[index];
		}
		return Object.class;
	}
	/**
	 * 通过反射,获得方法返回值第一个泛型参数的实际类型. 如: public Map<String, Buyer> getNames(){}
	 * @param Method method 方法
	 * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getMethodGenericReturnType(Method method) {
		return getMethodGenericReturnType(method, 0);
	}
	/**
	 * 通过反射,获得方法输入参数第index个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer> maps, List
	 * <String> names){}
	 * @param Method method 方法
	 * @param int index 第几个输入参数
	 * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
	 */
	@SuppressWarnings("rawtypes")
	public static List<Class> getMethodGenericParameterTypes(Method method, int index) {
		List<Class> results = new ArrayList<Class>();
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		if (index >= genericParameterTypes.length || index < 0) {
			throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
		}
		Type genericParameterType = genericParameterTypes[index];
		if (genericParameterType instanceof ParameterizedType) {
			ParameterizedType aType = (ParameterizedType) genericParameterType;
			Type[] parameterArgTypes = aType.getActualTypeArguments();
			for (Type parameterArgType : parameterArgTypes) {
				Class parameterArgClass = (Class) parameterArgType;
				results.add(parameterArgClass);
			}
			return results;
		}
		return results;
	}
	/**
	 * 通过反射,获得方法输入参数第一个输入参数的所有泛型参数的实际类型. 如: public void add(Map<String, Buyer> maps, List
	 * <String> names){}
	 * @param Method method 方法
	 * @return 输入参数的泛型参数的实际类型集合, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回空集合
	 */
	@SuppressWarnings("rawtypes")
	public static List<Class> getMethodGenericParameterTypes(Method method) {
		return getMethodGenericParameterTypes(method, 0);
	}
	/**
	 * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
	 * @param Field field 字段
	 * @param int index 泛型参数所在索引,从0开始.
	 * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getFieldGenericType(Field field, int index) {
		Type genericFieldType = field.getGenericType();
		if (genericFieldType instanceof ParameterizedType) {
			ParameterizedType aType = (ParameterizedType) genericFieldType;
			Type[] fieldArgTypes = aType.getActualTypeArguments();
			if (index >= fieldArgTypes.length || index < 0) {
				throw new RuntimeException("你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数"));
			}
			return (Class) fieldArgTypes[index];
		}
		return Object.class;
	}
	/**
	 * 通过反射,获得Field泛型参数的实际类型. 如: public Map<String, Buyer> names;
	 * @param Field field 字段
	 * @param int index 泛型参数所在索引,从0开始.
	 * @return 泛型参数的实际类型, 如果没有实现ParameterizedType接口，即不支持泛型，所以直接返回 <code>Object.class</code>
	 */
	@SuppressWarnings("rawtypes")
	public static Class getFieldGenericType(Field field) {
		return getFieldGenericType(field, 0);
	}
	/**
	 * @Title: getMethodByMethodName
	 * @Description: TODO
	 * @param clazz
	 * @param methodName
	 * @return
	 * @return: Method
	 */
	@SuppressWarnings("rawtypes")
	public static Method getMethodByMethodName(Class clazz, String methodName) {
		for (Method method : clazz.getMethods()) {
			if (StringUtils.equals(methodName, method.getName())) {
				return method;
			}
		}
		return null;
	}
	/**
	 * @Title: getMethodParam
	 * @Description: TODO
	 * @param method
	 * @param index
	 * @return
	 * @return: Object
	 */
	@SuppressWarnings("rawtypes")
	public static List<Class> getMethodParam(Method method, int index) {
		List<Class> results = new ArrayList<Class>();
		Class[] parameterTypes = method.getParameterTypes();
		if (index >= parameterTypes.length || index < 0) {
			String excption  =  "你输入的索引" + (index < 0 ? "不能小于0" : "超出了参数的总数");
			log.error(excption);
			throw new RuntimeException(excption);
		}
		for (Class clazz : parameterTypes) {
			results.add(clazz);
		}
		return results;
	}
	/**
	 * @Title: getMethodParam
	 * @Description: TODO
	 * @param method
	 * @return
	 * @return: Class
	 */
	@SuppressWarnings("rawtypes")
	public static Class getMethodParam(Method method) {
		return getMethodParam(method, 0).get(0);
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getGenerateParamClass(Class clazz,int index) {
		String preClazzName = GenericsUtils.getSuperClassGenricType(clazz, index).toString();
		String clazzName = preClazzName.substring(6, preClazzName.length());
		try {
			return Class.forName(clazzName);
		} catch (ClassNotFoundException e) {
			String exception = "msg:类" + clazzName + "未找到";
			log.error("code:common," + exception);
		}
		return null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Object getParam(Class targetClass,T target,CalledMethodInterface methodParam){
		String exception = null;
		try{
			if(methodParam instanceof CalledMethodNoneparam){
				CalledMethodNoneparam paramNoneMethod = (CalledMethodNoneparam)methodParam;
				Method method = targetClass.getMethod(paramNoneMethod.getMethodName());
				return method.invoke(target);
			}else if(methodParam instanceof GetMethodParam){
				GetMethodParam param = (GetMethodParam)methodParam;
				Method method = param.getMethod();
				return method.invoke(target);
			}else if(methodParam instanceof SetMethodParam){
				SetMethodParam param = (SetMethodParam)methodParam;
				Method method = param.getMethod();
				return method.invoke(target,param.getValue());
			}
		}catch (IllegalAccessException e) {
			exception = "code : common-201,msg: 非法访问异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			exception = "code : common-202,msg: 非法参数异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			exception = "code : common-203,msg: 调用目标异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (SecurityException e) {
			exception = "code : common-204,msg: 安全异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			exception = "code : common-205,msg: 没有该方法";
			log.error(exception);
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return exception;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T setParam(Class targetClass,T target,List<CalledMethodInterface> methodParams){
		String exception = null;
		try{
			for(CalledMethodInterface param :methodParams){
				Method method = null;
				if(param instanceof CalledMethodNoneparam){
					CalledMethodNoneparam paramNoneMethod = (CalledMethodNoneparam)param;
					method = targetClass.getMethod(paramNoneMethod.getMethodName());
					method.invoke(target);
				}else if(param instanceof CalledMethodParam){
					CalledMethodParam paramMethod = (CalledMethodParam)param;
					method = targetClass.getMethod(paramMethod.getMethodName(),paramMethod.getMethodParamClass());
					method.invoke(target, paramMethod.getValue());
				}else if(param instanceof GetMethodParam){
					GetMethodParam _param = (GetMethodParam)param;
					method = _param.getMethod();
					method.invoke(target);
				}else if(param instanceof SetMethodParam){
					SetMethodParam _param = (SetMethodParam)param;
					method = _param.getMethod();
					method.invoke(target,_param.getValue());
				}
			}
		}catch (IllegalAccessException e) {
			exception = "code : common-201,msg: 非法访问异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (IllegalArgumentException e) {
			exception = "code : common-202,msg: 非法参数异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (InvocationTargetException e) {
			exception = "code : common-203,msg: 调用目标异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (SecurityException e) {
			exception = "code : common-204,msg: 安全异常";
			log.error(exception);
			log.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			exception = "code : common-205,msg: 没有该方法";
			log.error(exception);
			log.error(e.getMessage());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return target;
	}
	
	@SuppressWarnings("rawtypes")
	public static Object getInstance(Class clazz){
		String exception = null;
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			exception = "code : common-200,msg: 实例化异常";
			log.error(exception);
		} catch (IllegalAccessException e) {
			exception = "code : common-201,msg: 非法访问异常";
			log.error(exception);
		}
		return null; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> T getGeneticInstance(Class clazz){
		String exception = null;
		try {
			return (T) clazz.newInstance();
		} catch (InstantiationException e) {
			exception = "code : common-200,msg: 实例化异常";
			log.error(exception);
		} catch (IllegalAccessException e) {
			exception = "code : common-201,msg: 非法访问异常";
			log.error(exception);
		}
		return null; 
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> T setParams(Class targetClass,T target,CalledMethodInterface methodParam){
		List<CalledMethodInterface> params = new ArrayList<GenericsUtils.CalledMethodInterface>();
		params.add(methodParam);
		return setParam(targetClass, target, params);
	}
	
	public interface CalledMethodInterface{}
	
	public static class SetMethodParam implements CalledMethodInterface{
		private Method method;
		
		private Object value;
		
		public SetMethodParam(Method method,Object value) {
			this.method = method;
			this.value = value;
		}

		public Method getMethod() {
			return method;
		}

		public void setMethod(Method method) {
			this.method = method;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}
	
	public static class GetMethodParam implements CalledMethodInterface {
		private Method method;
		
		public GetMethodParam(Method method) {
			this.method = method;
		}

		public Method getMethod() {
			return method;
		}

		public void setMethod(Method method) {
			this.method = method;
		}
	}
	
	public static class CalledMethodNoneparam implements CalledMethodInterface{
		private String methodName;

		public CalledMethodNoneparam(String string) {
			this.methodName = string;
		}

		public String getMethodName() {
			return methodName;
		}

		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static class CalledMethodParam implements CalledMethodInterface{
		private String methodName;
		private Class methodParamClass;
		private Object value;
		
		
		public CalledMethodParam(String methodName,Class methodParamClass,Object value) {
			this.methodName = methodName;
			this.methodParamClass = methodParamClass;
			this.value = value;
		}

		public String getMethodName() {
			return methodName;
		}

		public void setMethodName(String methodName) {
			this.methodName = methodName;
		}

		public Class getMethodParamClass() {
			return methodParamClass;
		}

		public void setMethodParamClass(Class methodParamClass) {
			this.methodParamClass = methodParamClass;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}
	}

	@SuppressWarnings("rawtypes")
	public static Object setParam(Class generateParamClass, Object obj, String string) {
		CalledMethodNoneparam methodNoneparam = new CalledMethodNoneparam(string);
		return setParam(generateParamClass, obj, methodNoneparam);
	}
	@SuppressWarnings("rawtypes")
	private static Object setParam(Class generateParamClass, Object obj, CalledMethodNoneparam methodNoneparam) {
		List<CalledMethodInterface> list = new ArrayList<GenericsUtils.CalledMethodInterface>();
		list.add(methodNoneparam);
		return setParam(generateParamClass, obj, list);
	}
	@SuppressWarnings("rawtypes")
	public static Object setParam(Class generateParamClass, Object obj, String methodName, Class classMethodParam,
			Object value) {
		List<CalledMethodInterface> list = new ArrayList<GenericsUtils.CalledMethodInterface>();
		list.add(new CalledMethodParam(methodName, classMethodParam, value));
		return setParam(generateParamClass, obj, list);
	}
	@SuppressWarnings("rawtypes")
	public static Object getParentParam(Class generateParamClass, Object obj, CalledMethodInterface methodInterface) {
		List<CalledMethodInterface> list = new ArrayList<GenericsUtils.CalledMethodInterface>();
		list.add(methodInterface);
		return setParam(generateParamClass, obj, list);
	}
	
	@SuppressWarnings("rawtypes")
	public static Class getFiledClass(Class clazz,String fieldName){
		Field field = null;
		String exception = null;
		try {
			field = clazz.getDeclaredField(fieldName);
			return field.getType();
		} catch (SecurityException e) {
			exception = "code : common-204,msg: 安全异常";
			log.error(exception);
		} catch (NoSuchFieldException e) {
			exception = "code : common-205,msg: 未找到字段";
			log.error(exception);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Method constructSetMethod(Class clazz,String fieldName){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			return pd.getWriteMethod();
			
		} catch (IntrospectionException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Method constructGetMethod(Class clazz,String fieldName){
		try {
			PropertyDescriptor pd = new PropertyDescriptor(fieldName, clazz);
			return pd.getReadMethod();
		} catch (IntrospectionException e) {
			log.error(e.getMessage());
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public static Field[] getDeclareFields(Class clazz){
		return clazz.getDeclaredFields();
	}
	
	@SuppressWarnings("rawtypes")
	public static <T> void copyBean(Class clazz,int index,T oldModel,T newModel){
		Field[] fields = GenericsUtils.getDeclareFields(clazz);
		List<CalledMethodInterface> list = new ArrayList<GenericsUtils.CalledMethodInterface>();
		for(Field field : fields){
			if(!StringUtils.getArrayTrimBlank(field.getName()) && field.getName().equals("serialVersionUID")) continue;
			//1 get value
			Method getMethod = GenericsUtils.constructGetMethod(clazz, field.getName());
			Object value = GenericsUtils.getParam(clazz, newModel, new GenericsUtils.GetMethodParam(getMethod));
            if(value == null){
            	Object oldValue = GenericsUtils.getParam(clazz, oldModel, new GenericsUtils.GetMethodParam(getMethod));
            	//	2 set obj
            	list.add(new GenericsUtils.SetMethodParam(GenericsUtils.constructSetMethod(clazz,field.getName() ), oldValue));
            }
		}
		GenericsUtils.setParam(clazz,newModel , list);
	}
}
