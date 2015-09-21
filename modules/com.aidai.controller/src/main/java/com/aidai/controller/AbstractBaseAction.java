package com.aidai.controller;

import java.util.List;

import com.aidai.service.BaseService;
import com.aidai.service.ServiceException;
import com.aidai.utils.GenericsUtils;
import com.aidai.utils.GenericsUtils.CalledMethodInterface;
import com.aidai.utils.StringUtils;
import com.opensymphony.xwork2.ModelDriven;

public abstract class AbstractBaseAction<T,F> extends BaseActionTemlate<T,F> implements ModelDriven<T>,BaseActionInterface {

	private static final long serialVersionUID = 1L;
	
	protected BaseService<T, F> baseService;
	
	public AbstractBaseAction() {
		//vo = GenericsUtils.getGeneticInstance(getGenerateParamClass(0));
		example = GenericsUtils.getGeneticInstance(getGenerateParamClass(1));
	}
	
	@Override
	public T getModel() {
		return vo = GenericsUtils.getGeneticInstance(getGenerateParamClass(0));
	}
	
	@SuppressWarnings("unchecked")
	protected Object getExampleObject(){
		if(example == null){
			return example = (F) getGenerateParamClass(1);
		}
		return example;
	}
	
	@SuppressWarnings("rawtypes")
	protected Class getGenerateParamClass(int i) {
		return GenericsUtils.getGenerateParamClass(this.getClass(),i);
	}

	@SuppressWarnings("rawtypes")
	protected Object getCriteria(Object example/*,boolean isNew*/){
		CalledMethodInterface methodInterface = new GenericsUtils.CalledMethodNoneparam("getOredCriteria");
		List criterias = (List) GenericsUtils.getParam(getGenerateParamClass(1), example, methodInterface);
		if(criterias.size() == 0){
			return orCriteria(example);
		}else{
			return criterias.get(0);
		}
	}
	
	protected Object orCriteria(Object example) {
		Object criteria = GenericsUtils.getParam(getGenerateParamClass(1), example, new GenericsUtils.CalledMethodNoneparam("createCriteria"));
		GenericsUtils.setParam(getGenerateParamClass(1), example, "or", criteria.getClass(), criteria);
		return criteria;
	}
	
	protected void _init(){
		vo  = getVO();
		setService();
	}
	
	@Override
	public String init() {
		_init();
		try {
			initBefore(vo, example);
			if (!StringUtils.getTrimBlank(getId())) {
				initFindBefore(vo,example);
				vo = baseService.findByPrimarykey(getId());
				
				initFirstAfter(vo, example);
			}
			initSecondBefore(vo, example);
			
			List<T> items = baseService.selectByExample(example);
			
			initAfter(vo,  example,items);
		} catch (ServiceException e) {
			innerMessage(e.getMessage(),"初始化错误！","/msg.html");
			return WebConstants.MSG;
		}
		return SUCCESS;
	}
	
	@Override
	public String add() {
		if (vo == null) {
			msg = "表单为空，请重新输入";
			message(msg, "/msg.html");
			return WebConstants.MSG;
		}
		try {
			_init();
			addBefore(vo,  example);
			baseService.insert(vo);
			
			addAfter(vo, example);
		} catch (ServiceException e) {
			innerMessage(e.getMessage(),"插入失败！","/msg.html");
			return ERROR;
		}
		return WebConstants.MSG;
	}
	@Override
	public String modify() {
		try {
			if (vo != null) {
				_init();
				Object criteria = getCriteria(example);
				String idString = (String)GenericsUtils.getParam(getGenerateParamClass(0), vo, new GenericsUtils.CalledMethodNoneparam("getId"));
				T oldModel = baseService.findByPrimarykey(idString);
				modifyBefore(oldModel,vo, example);
				if(!StringUtils.getTrimBlank(idString)){
					GenericsUtils.setParam(criteria.getClass(), criteria, "andIdEqualTo",String.class, idString);
				}
				baseService.updateByExample(vo,  example);
				modifyAfter(vo, example);
			}
		} catch (ServiceException e) {
			innerMessage(e.getMessage(),"修改失败！","/msg.html");
			return ERROR;
		}
		return WebConstants.MSG;
	}
	@Override
	public String del() {
		try {
			_init();
			Object criteria = getCriteria(example);
			String idString = getId();
			delBefore(vo, example);
			if(!StringUtils.getTrimBlank(idString)){
				GenericsUtils.setParam(criteria.getClass(), criteria, "andIdEqualTo",String.class, getId());
			}
			if(!StringUtils.getTrimBlank(ids)){
				GenericsUtils.setParam(criteria.getClass(), criteria, "andIdIn",List.class, getIds().split(","));
			}
			baseService.deleteByExample( example);
			delAtfer(vo, example);
		} catch (ServiceException e) {
			innerMessage(e.getMessage(),"删除失败！","/msg.html");
			return ERROR;
		}
		return SUCCESS;
	}
	@Override
	public String list() {
		try {
			_init();
			listBefore(vo, example);
			page = baseService.selectByExample(page.getStart(), page.getPernum(), example);
			
			listAtfer(vo, example);
		} catch (ServiceException e) {
			innerMessage(e.getMessage(),"查询失败！","/msg.html");
			return ERROR;
		}
		return SUCCESS;
	}
}
