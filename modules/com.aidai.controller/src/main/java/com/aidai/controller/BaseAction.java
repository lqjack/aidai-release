package com.aidai.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.json.JSONException;
import org.apache.struts2.json.JSONUtil;
import org.apache.struts2.util.TokenHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aidai.dao.Page;
import com.aidai.model.User;
import com.aidai.utils.DateUtils;
import com.aidai.utils.NumberUtils;
import com.aidai.utils.StringUtils;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction<T,F> extends ActionSupport
		implements ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	
	private final static Logger log = LoggerFactory.getLogger("base.action");
	
	protected ServletContext context;
	protected HttpSession session;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected ServletContext application;
	
	protected ByteArrayInputStream inputStream;
	protected String suffix = "-";
	protected int contentLength;
	protected String contentType;
	protected String CONTENT_TYPE = "contentType";
	
	protected String msg;
	protected String url;
	protected String actionType;
	protected String rsmsg;
	protected String backurl;
	protected String currentUrl;
	
	protected String customMetaTitle;
	protected String customMetaDescription;
	protected String customMetaKeywords;
	
	protected String id;
	protected String pid;
	protected String type;
	protected String userid;
	protected String name;
	protected String ids;
	protected Page<T> page;
	protected Map<String,String> params;
	
	protected F example;
	protected T vo;
	
	protected int NUM = 4;
	protected final String RANDOM_CODD = "random_code";
	public static String SINGLE_LOGIN = "single_login";

	protected void initSession() {
		session.setAttribute(WebConstants.ADMIN_URL, "/admin");
	}
	
	protected void initRequest(){}
	
	public BaseAction() {
//		JakartaMultiPartRequest 
		request = ServletActionContext.getRequest();
		initRequest();
		session = request.getSession();
		initSession();
		application = session.getServletContext();
		initApplication();
		page = new Page<T>();
		params = new HashMap<String, String>();
	}
	

	/**
	 * 封装获取Session中的用户对象
	 * @return
	 */
	protected User getSessionUser() {
		return (User) session.getAttribute(WebConstants.CURRENT_USER);
	}
	/**
	 * 封装获取Session中的用户对象
	 * @return
	 */
	protected User getAuthUser() {
		return (User) session.getAttribute(WebConstants.AUTH_USER);
	}
	/**
	 * 封装获取Session中的用户对象的用户名
	 * @return
	 */
	protected String getAuthUserName() {
		return getAuthUser().getUserName();
	}
	/**
	 * 封装获取Session中的用户对象的ID
	 * @return
	 */
	protected String getAuthUserId() {
		return getAuthUser().getId();
	}
	/**
	 * 获取http请求的实际IP
	 * @return
	 */
	/*protected String getRequestIp() {
		return IPUtils.getRemortIP(request);
	}*/
	/**
	 * 获取IP所在地
	 * @return
	 */
	/*protected String getAreaByIp() {
		return getRequestIp();
	}*/
	/*protected String getAreaByIp(String ip) {
		return IPSeeker.getInstance().getArea(ip);
	}*/
	/**
	 * 获取当前时间
	 * @return
	 */
	protected String getTimeStr() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}
	/**
	 * 提示消息
	 * @param msg
	 * @param url
	 */
	protected void message(String msg, String url) {
		String urltext = "";
		if (!StringUtils.isBlank(url)) {
			urltext = "<a class='color-blue' style='font-size: 14px;' href=" + request.getContextPath() + url
					+ " >返回上一页</a>";
			request.setAttribute("backurl", urltext);
		} else {
			urltext = "<a class='color-blue' style='font-size: 14px;' href='javascript:history.go(-1)'>返回上一页</a>";
		}
		message(msg, url, urltext);
	}
	/**
	 * 提示消息
	 * @param msg 消息 btname 名称 url
	 * @param url
	 */
	protected void clickmessage(String msg, String clname, String url) {
		String urldiv = "";
		if (!StringUtils.isBlank(url)) {
			urldiv = "<div class=\"back_url\" onclick=\"goto_url('" + request.getContextPath() + url + "')\">" + clname
					+ "</div>";
		} else
			urldiv = "<div class='back_url' onclick='javascript:history.go(-1)'>点击返回</div>";
		request.setAttribute(WebConstants.RESULT_MSG, msg);
		request.setAttribute(WebConstants.BACK_URL, urldiv);
	}
	/**
	 * 提示消息
	 * @param msg 消息 btname 名称 url
	 * @param url
	 */
	protected String oneMsg(String msg, String clname, String url) {
		if (!StringUtils.isBlank(url)) {
			String div = "<div class=\"one_msg\" >" + msg + "</div>";
			String div1 = "<div class=\"one_msg_1\" onclick=\"goto_url('" + request.getContextPath() + url + "')\">"
					+ clname + "</div>";
			return div + div1;
		}
		return "<div class='back_url' onclick='javascript:history.go(-1)'>点击返回</div>";
	}
	/**
	 * 提示消息
	 * @param msg 消息 btname 名称 url
	 * @param url
	 */
	protected String doubleMsg(String msg, String msg1, String url1, String msg2, String url2) {
		String urldiv = "";
		if (!StringUtils.isBlank(url1)) {
			String div = "<div class=\"double_msg\" >" + msg + "</div>";
			String div1 = "<div class=\"double_msg_1\" onclick=\"goto_url('" + request.getContextPath() + url1 + "')\">"
					+ msg1 + "</div>";
			String div2 = "<div class=\"double_msg_2\" onclick=\"goto_url('" + request.getContextPath() + url2 + "')\">"
					+ msg2 + "</div>";
			urldiv = div + div1 + div2;
		} else {
			urldiv = "<div class='back_url' onclick='javascript:history.go(-1)'>点击返回</div>";
		}
		return urldiv;
	}
	protected void message(String msg) {
		this.message(msg, getMsgUrl());
	}
	/**
	 * 提示消息
	 * @param msg
	 * @param url
	 * @param text
	 */
	protected void message(String msg, String url, String text) {
		request.setAttribute(WebConstants.RESULT_MSG, msg);
		String urltext = "<a href=" + request.getContextPath() + url + " >" + text + "</a>";
		request.setAttribute(WebConstants.URL, request.getContextPath() + url);
		request.setAttribute(WebConstants.BACK_URL, urltext);
	}
	/**
	 * 空白方法，不处理业务逻辑
	 * @return
	 * @throws Exception
	 */
	public String blank() throws Exception {
		return SUCCESS;
	}
	/**
	 * 校验参数actionType是否null或者空，是返回true.
	 * @return
	 */
	public boolean isBlank() {
		return StringUtils.isBlank(getActionType());
	}
	public boolean isSession() {
		return null == this.getSessionUser();
	}
	protected void setMsgUrl(String url) {
		request.setAttribute(WebConstants.CURREN＿URL, url);
		String msgurl = (String) session.getAttribute(WebConstants.MSG_URL);
		String query = request.getQueryString();
		if (!StringUtils.isBlank(query)) {
			url = url + "?" + query;
		}
		msgurl = url;
		session.setAttribute(WebConstants.MSG_URL, msgurl);
	}
	protected String getMsgUrl() {
		String msgurl = "";
		Object o = null;
		if ((o = session.getAttribute(WebConstants.MSG_URL)) != null) {
			msgurl = (String) o;
		}
		return msgurl;
	}
	protected String upload(File upload, String fileName, String destDir, String destFileName) throws Exception {
		if (upload == null)
			return "";
		if (log.isDebugEnabled()) {
			log.info("文件：" + upload);
			log.info("文件名：" + fileName);
		}
		String destFileUrl = destDir + "/" + destFileName;
		String destfilename = ServletActionContext.getServletContext().getRealPath(destDir) + "/" + destFileName;
		if(log.isDebugEnabled()) log.info(destfilename);
		File imageFile = null;
		imageFile = new File(destfilename);
		FileUtils.copyFile(upload, imageFile);
		return destFileUrl;
	}
	protected String getRef() {
		return StringUtils.isNull(request.getParameter(WebConstants.REF));
	}
	protected String getAndSaveRef() {
		String ref = getRef();
		request.setAttribute(WebConstants.REF, ref);
		return ref;
	}
	protected void printJson(String json) throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Cache-Control", "no-store, no-cache");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();
	}
	/**
	 * 
	 * @Title: printJson 
	 * @Description: flag为ture时，返回result:1的json对象
	 * @param json
	 * @param flag
	 * @throws IOException
	 * @throws JSONException
	 * @return: void
	 */
	protected void printJson(String json,boolean flag) {
		Map<String, String> result = new HashMap<String, String>();
		result.put("result", "1");
		try {
			printJson(JSONUtil.serialize(result));
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (JSONException e) {
			log.error(e.getMessage());
		}
	}
	
	protected void generateDownloadFile(String inFile, String downloadFile) throws IOException {
		InputStream ins = new BufferedInputStream(new FileInputStream(inFile));
		byte[] buffer = new byte[ins.available()];
		ins.read(buffer);
		ins.close();
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		response.reset();
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(downloadFile.getBytes()));
		response.addHeader("Content-Length", "" + new File(inFile).length());
		OutputStream ous = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		ous.write(buffer);
		ous.flush();
		ous.close();
	}
	protected int paramInt(String str) {
		return NumberUtils.getInt(request.getParameter(str));
	}
	protected long paramLong(String str) {
		return NumberUtils.getLong(request.getParameter(str));
	}
	protected double paramDouble(String str) {
		return NumberUtils.getDouble(request.getParameter(str));
	}
	protected String paramString(String str) {
		return StringUtils.isNull(request.getParameter(str));
	}
	protected void export(String infile, String downloadFile) throws Exception {
		File inFile = new File(infile);
		InputStream ins = new BufferedInputStream(new FileInputStream(infile));
		byte[] buffer = new byte[ins.available()];
		ins.read(buffer);
		ins.close();
		HttpServletResponse response = (HttpServletResponse) ActionContext.getContext()
				.get(ServletActionContext.HTTP_RESPONSE);
		response.reset();
		response.addHeader("Content-Disposition", "attachment;filename=" + new String(downloadFile.getBytes()));
		response.addHeader("Content-Length", "" + inFile.length());
		OutputStream ous = new BufferedOutputStream(response.getOutputStream());
		response.setContentType("application/octet-stream");
		ous.write(buffer);
		ous.flush();
		ous.close();
	}
	/**
	 * 检查表单提交的
	 * @param name
	 * @return
	 */
	protected String checkToken(String name) {
		String paramValue = paramString(name);
		String tokenValue = StringUtils.isNull((String) session.getAttribute(name));
		if (paramValue.isEmpty() && tokenValue.isEmpty()) {
			log.error("会话Token未设定！");
			return "会话Token未设定！";
		} else if (paramValue.isEmpty() && !tokenValue.isEmpty()) {
			log.error("表单Token未设定！");
			return "表单Token未设定！";
		} else if (paramValue.equals(tokenValue) && !tokenValue.isEmpty()) { // session中有token,防止重复提交检查
			session.removeAttribute(name);
			return "";
		} else {
			log.error("请勿重复提交！");
			return "请勿重复提交！";
		}
	}
	protected void saveToken(String name) {
		String token = TokenHelper.generateGUID();
		session.setAttribute(name, token);
	}
	/**
	 * 判断上传文件约束
	 * @param fileName
	 * @return
	 */
	protected boolean checkUpload(String fileName) {
		Pattern p = Pattern.compile(".(jsp|jspx|php|asp|aspx|js|sh)");
		Matcher m = p.matcher(fileName);
		return m.find();
	}
	public static String getCurrentApplicationContextPath() {
		return getServletContext().getContextPath();
	}
	
	public static ServletContext getServletContext() {
		return (ServletContext) ServletActionContext.getContext().get(ServletActionContext.SERVLET_CONTEXT);
	}
	
	/**
	 * 发送邮件(带附件)
	 * @param user
	 * @throws Exception
	 */
	/*protected void sendMailWithAttachment(User user, long borrow_id, long tender_id) throws Exception {
		String to = user.getEmail();
		String attachfile = ServletActionContext.getServletContext().getRealPath("/") + "/data/protocol/" + borrow_id
				+ "_" + tender_id + ".pdf";
		MailWithAttachment m = MailWithAttachment.getInstance();
		m.setTo(to);
		m.readProtocolMsg();
		// m.replace(user.getUserName(), to, "/user/identify/active.html?id=" +
		// m.getdecodeIdStr(user));
		m.attachfile(attachfile);
		m.sendMail();
	}*/
	/*protected void genernateValidateImage() throws IOException {
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");
		ServletOutputStream out = response.getOutputStream();
		try {
			String randomCode = RandomValidateCode.random(NUM);
			session.setAttribute(RANDOM_CODD, randomCode);
			contentType = "image/jpeg";
			inputStream = RandomValidateCode.getValidateCode(randomCode);
			suffix = "-";
//			contentLength = inputStream.read();
			
			byte[] byteArr = new byte[1024];  
            //读取的字节数  
            int readCount = inputStream.read(byteArr);  
            //如果已到达文件末尾，则返回-1  
            while (readCount != -1) {  
                for (int i = 0; i < readCount; i++) {  
                    out.write(byteArr[i]);  
                }  
                readCount = inputStream.read(byteArr);  
            }  
            inputStream.close();  
			
			out.flush();
		} catch (Exception e) {
			log.error(e);
		} finally {
			out.close();
		}
	}*/
	
	protected void innerMessage(String exceptionMsg,String msg,String url) {
		log .error(exceptionMsg);
		this.rsmsg = this.msg = msg;
		message(msg, url);
	}
	
	protected void innerMessage(String msg,String url) {
		innerMessage(msg, msg, url);
	}
	
	/**
	 * RSA 公钥的Modulus与PublicExponent的hex编码形式
	 */
	// protected void initRSAME() { Rule rsaFormEncrypt =
	// Global.getRule(EnumRuleNid.RSA_FORM_ENCRYPT.getValue()); if(rsaFormEncrypt != null &&
	// rsaFormEncrypt.getStatus() == 1){ // RSA RSAPublicKey rsap; try { rsap = (RSAPublicKey)
	// RSAUtil.getKeyPair().getPublic(); String module = rsap.getModulus().toString(16); String
	// empoent = rsap.getPublicExponent().toString(16); request.setAttribute("m", module);
	// request.setAttribute("e", empoent); } catch (Exception e) { e.printStackTrace();
	// log.error(e.getMessage()); } } request.setAttribute("rsaFormEncrypt", rsaFormEncrypt); }
	/**
	 * 校验校验码是否正确
	 * @param valid
	 * @return
	 */
	protected boolean checkValidImg(String valid) {
		// TODO:
		boolean b = false;
		// try {
		// b =
		// CaptchaServiceSingleton.getInstance().validateResponseForID(request.getSession().getId(),
		// valid.toLowerCase());
		// } catch (CaptchaServiceException e) {
		// b = false;
		// }
		return b;
	}
	/*
	 * public void saveParam(){ request.setAttribute("param", new SearchParam().toMap()); }
	 */
	/*
	 * protected void setPageAttribute(PageDataList plist,SearchParam param){
	 * request.setAttribute("page", plist.getPage()); request.setAttribute("list", plist.getList());
	 * request.setAttribute("param", param.toMap()); }
	 */
	/**
	 * 后台管理功能中的图片上传
	 * @param files
	 * @param filesFileName
	 * @param backUrl
	 * @return
	 * @throws Exception
	 */
	protected String upload(File files, String filesFileName, String backUrl) throws Exception {
		String newUrl = "";
		if (files != null) {
			boolean rs = checkUpload(filesFileName);
			if (rs) {
				message("上传附件格式不正确!", backUrl);
				return WebConstants.ADMINMSG;
			}
			String newFileName = generateUploadFilename(filesFileName);
			newUrl = upload(files, "", "/data/upload", newFileName);
		}
		return newUrl;
	}
	protected String generateUploadFilename() {
		User u = getSessionUser();
		String timeStr = DateUtils.dateStr3(new Date());
		if (u == null)
			return timeStr;
		return u.getId() + timeStr;
	}
	protected String generateUploadFilename(String fileName) {
		String suffix = null;
		if (fileName != null) {
			int last = fileName.lastIndexOf('.');
			suffix = fileName.substring(last);
		}
		return generateUploadFilename() + suffix;
	}
	/*public String getCustomMetaDescription() {
		if (StringUtils.isEmpty(customMetaDescription)) {
			return ThreadLocalMap.getTreadLocalStringValue("meta_webname")
					+ ThreadLocalMap.getTreadLocalStringValue("meta_description");
		}
		return customMetaDescription;
	}
	public void setCustomMetaDescription(String customMetaDescription) {
		this.customMetaDescription = customMetaDescription;
	}
	public String getCustomMetaKeywords() {
		if (StringUtils.isEmpty(customMetaDescription)) {
			return ThreadLocalMap.getTreadLocalStringValue("meta_webname") + ","
					+ ThreadLocalMap.getTreadLocalStringValue("meta_keywords");
		}
		return customMetaKeywords;
	}
	public void setCustomMetaKeywords(String customMetaKeywords) {
		this.customMetaKeywords = customMetaKeywords;
	}
	public String getCustomMetaTitle() {
		if (StringUtils.isEmpty(customMetaTitle)) {
			return ThreadLocalMap.getTreadLocalStringValue("meta_webname") + "_"
					+ ThreadLocalMap.getTreadLocalStringValue("meta_title");
		}
		return customMetaTitle;
	}*/
	public void setCustomMetaTitle(String customeMetaTitle) {
		this.customMetaTitle = customeMetaTitle;
	}
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	public String getActionType() {
		return setParam(actionType,"actionType");
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	public int getContentLength() {
		return contentLength;
	}
	public void setContentLength(int contentLength) {
		this.contentLength = contentLength;
	}
	public String getContentType() {
		return setParam(contentType,"contentType");
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}

	protected void initApplication() {
		application.setAttribute(WebConstants.MSG_URL, "http://share");
		application.setAttribute(WebConstants.IMG_URL, "http://share");
		application.setAttribute(WebConstants.RESULT_MSG, "");
		application.setAttribute(WebConstants.THEME_DIR, "http://share");
		application.setAttribute(WebConstants.BACK_URL, "http://share");
		application.setAttribute(WebConstants.ADMIN_URL, "true");
		application.setAttribute(WebConstants.ADMIN__URL, "localhost:8080/qlc");
		application.setAttribute(WebConstants.ADMIN_URL_CHECK, "true");
		application.setAttribute(WebConstants.CUSTOM_META_TITLE, "欢迎登陆");
		application.setAttribute(WebConstants.CUSTOM_META_DESCRIPTION, "描述");
		application.setAttribute(WebConstants.CUSTOM_META_KEYWORDS, "理财，趣理财");
		
		/*Properties props = System.getProperties();
		Runtime runtime = Runtime.getRuntime();
		long freeMemoery = runtime.freeMemory();
		long totalMemory = runtime.totalMemory();
		long usedMemory = totalMemory - freeMemoery;
		long maxMemory = runtime.maxMemory();
		long useableMemory = maxMemory - totalMemory + freeMemoery;
		request.setAttribute(PROPS, props);
		request.setAttribute(FREE_MEMORY, freeMemoery);
		request.setAttribute(TOTAL_MEMORY, totalMemory);
		request.setAttribute(USED_MEMORY, usedMemory);
		request.setAttribute(MAX_MEMORY, maxMemory);
		request.setAttribute(USEABLE_MEMORY, useableMemory);*/
		
		application.setAttribute(WebConstants.WEB_NAME, "趣理财");
		
		application.setAttribute(WebConstants.WEB_URL, getCurrentApplicationContextPath());
		application.setAttribute(WebConstants.WEB_ROOT, getCurrentApplicationContextPath());
	}
	public Page<T> getPage() {
		return page;
	}
	public void setPage(Page<T> page) {
		this.page = page;
	}
	public String getId() {
		return setParam(id,"id");
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return setParam(name,"name");
	}
	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	public String getUserid() {
		return setParam(userid,"userid");
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPid() {
		return setParam(pid,"pid");
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getType() {
		return setParam(type,"type");
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIds() {
		return setParam(ids,"ids");
	}

	public void setIds(String ids) {
		this.ids = ids;
	}
	
	private String setParam(String orinal,String param){
		if(orinal == null){
			orinal = request.getParameter(param);
		}
		if(orinal == null){
			orinal = (String) request.getAttribute(param);
		}
		return orinal;
	}
	
	@SuppressWarnings("unchecked")
	protected T getVO() {
//		if(vo == null) return vo = (T) request.getAttribute("vo");
		return (T) request.getAttribute("vo");
	}
	
}
