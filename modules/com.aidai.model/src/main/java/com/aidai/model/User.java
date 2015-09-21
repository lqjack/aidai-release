package com.aidai.model;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private String id;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String userPassword;

    /**
     * 用户推广码
     */
    private String userCode;

    /**
     * 手机号码
     */
    private String userMobile;

    /**
     * 0:普通用户；1：管理员
     */
    private Integer badmin;

    /**
     * 推荐人类型
     */
    private String introducerType;

    /**
     * 推荐人主键
     */
    private String introducer;

    /**
     * 0:有效；1：用户冻结；
     */
    private Integer status;

    /**
     * 总资产
     */
    private String totalAssets;

    /**
     * 冻结资产
     */
    private String freezeAssets;

    /**
     * 净资产
     */
    private String pureAsserts;

    /**
     * 利息
     */
    private String interest;

    /**
     * 余额
     */
    private String balance;

    /**
     * 用户等级
     */
    private Integer userLevel;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 支付密码
     */
    private String payPassword;

    /**
     * 银行卡号，通过逗号间隔
     */
    private String bankCardNo;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 0：未单点登录；1：已经单点登录
     */
    private Integer bsingle;

    /**
     * 0:未被删除；1：已被删除
     */
    private Integer bdelete;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 修改时间
     */
    private Date modifyDatetime;

    /**
     * 修改人
     */
    private String modifyUser;

    /**
     * 备注
     */
    private String memo;

    /**
     * 总积分
     */
    private String totalIntegral;

    /**
     * 当前积分
     */
    private String currentIntegral;

    /**
     * 待收总额
     */
    private String waittingReceivedAssets;

    /**
     * 最近待收总额
     */
    private String lastReceivedAsserts;

    /**
     * 待收利息
     */
    private String waittingReceivedInterest;

    /**
     * 最近待收时间
     */
    private Date lastWaittingReceivedDatetime;

    /**
     * 待还总额
     */
    private String waittingEarnedAwards;

    /**
     * 借款总额
     */
    private String totalBorrowedAsserts;

    /**
     * 待付总额
     */
    private String waitttingPayedAsserts;

    /**
     * 最近待还金额
     */
    private String lastWaittingPayedAsserts;

    /**
     * 最近待还时间
     */
    private Date lastWaittingPayedDatetime;

    private static final long serialVersionUID = 1L;
    
    public User() {
	}

    /*public User(RegVO regVO) {
    	this.userPassword = regVO.getPassword();
    	this.userName=regVO.getUserName();
    	this.badmin = 0;
    	this.balance = "0";
    	this.bdelete = 0;
    	this.bsingle = 0;
    	this.currentIntegral = 0 + "";
    	this.freezeAssets = "0";
    	this.interest = "0";
    	this.introducer = regVO.getRecommendName(); //TODO:
    	this.introducerType = regVO.getIntroducerType();//TODO:
    	this.lastReceivedAsserts = "0";
    	this.lastWaittingPayedAsserts = "0";
    	this.lastWaittingPayedDatetime = null;
    	this.lastWaittingReceivedDatetime = null;
    	this.payPassword = "";
    	this.pureAsserts = "0";
    	this.realName = "";
    	this.status = 1;
    	this.totalAssets = "0";
    	this.totalBorrowedAsserts = "0";
    	this.userLevel = 1;
    	this.userMobile = regVO.getUserMobile();
    	this.waittingEarnedAwards = "0";
    	this.waittingReceivedAssets = "0";
    	this.waittingReceivedInterest = "0";
    	this.waitttingPayedAsserts = "0";
    }
*/
	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置   用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 用户密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置   用户密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取 用户推广码
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * 设置   用户推广码
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * 获取 手机号码
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     * 设置   手机号码
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     * 获取 0:普通用户；1：管理员
     */
    public Integer getBadmin() {
        return badmin;
    }

    /**
     * 设置   0:普通用户；1：管理员
     */
    public void setBadmin(Integer badmin) {
        this.badmin = badmin;
    }

    /**
     * 获取 推荐人类型
     */
    public String getIntroducerType() {
        return introducerType;
    }

    /**
     * 设置   推荐人类型
     */
    public void setIntroducerType(String introducerType) {
        this.introducerType = introducerType;
    }

    /**
     * 获取 推荐人主键
     */
    public String getIntroducer() {
        return introducer;
    }

    /**
     * 设置   推荐人主键
     */
    public void setIntroducer(String introducer) {
        this.introducer = introducer;
    }

    /**
     * 获取 0:有效；1：用户冻结；
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置   0:有效；1：用户冻结；
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取 总资产
     */
    public String getTotalAssets() {
        return totalAssets;
    }

    /**
     * 设置   总资产
     */
    public void setTotalAssets(String totalAssets) {
        this.totalAssets = totalAssets;
    }

    /**
     * 获取 冻结资产
     */
    public String getFreezeAssets() {
        return freezeAssets;
    }

    /**
     * 设置   冻结资产
     */
    public void setFreezeAssets(String freezeAssets) {
        this.freezeAssets = freezeAssets;
    }

    /**
     * 获取 净资产
     */
    public String getPureAsserts() {
        return pureAsserts;
    }

    /**
     * 设置   净资产
     */
    public void setPureAsserts(String pureAsserts) {
        this.pureAsserts = pureAsserts;
    }

    /**
     * 获取 利息
     */
    public String getInterest() {
        return interest;
    }

    /**
     * 设置   利息
     */
    public void setInterest(String interest) {
        this.interest = interest;
    }

    /**
     * 获取 余额
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 设置   余额
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 获取 用户等级
     */
    public Integer getUserLevel() {
        return userLevel;
    }

    /**
     * 设置   用户等级
     */
    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    /**
     * 获取 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置   真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取 支付密码
     */
    public String getPayPassword() {
        return payPassword;
    }

    /**
     * 设置   支付密码
     */
    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    /**
     * 获取 银行卡号，通过逗号间隔
     */
    public String getBankCardNo() {
        return bankCardNo;
    }

    /**
     * 设置   银行卡号，通过逗号间隔
     */
    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    /**
     * 获取 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置   邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取 0：未单点登录；1：已经单点登录
     */
    public Integer getBsingle() {
        return bsingle;
    }

    /**
     * 设置   0：未单点登录；1：已经单点登录
     */
    public void setBsingle(Integer bsingle) {
        this.bsingle = bsingle;
    }

    /**
     * 获取 0:未被删除；1：已被删除
     */
    public Integer getBdelete() {
        return bdelete;
    }

    /**
     * 设置   0:未被删除；1：已被删除
     */
    public void setBdelete(Integer bdelete) {
        this.bdelete = bdelete;
    }

    /**
     * 获取 创建时间
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * 设置   创建时间
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * 获取 创建人
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * 设置   创建人
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * 获取 修改时间
     */
    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    /**
     * 设置   修改时间
     */
    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    /**
     * 获取 修改人
     */
    public String getModifyUser() {
        return modifyUser;
    }

    /**
     * 设置   修改人
     */
    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    /**
     * 获取 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 设置   备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 获取 总积分
     */
    public String getTotalIntegral() {
        return totalIntegral;
    }

    /**
     * 设置   总积分
     */
    public void setTotalIntegral(String totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    /**
     * 获取 当前积分
     */
    public String getCurrentIntegral() {
        return currentIntegral;
    }

    /**
     * 设置   当前积分
     */
    public void setCurrentIntegral(String currentIntegral) {
        this.currentIntegral = currentIntegral;
    }

    /**
     * 获取 待收总额
     */
    public String getWaittingReceivedAssets() {
        return waittingReceivedAssets;
    }

    /**
     * 设置   待收总额
     */
    public void setWaittingReceivedAssets(String waittingReceivedAssets) {
        this.waittingReceivedAssets = waittingReceivedAssets;
    }

    /**
     * 获取 最近待收总额
     */
    public String getLastReceivedAsserts() {
        return lastReceivedAsserts;
    }

    /**
     * 设置   最近待收总额
     */
    public void setLastReceivedAsserts(String lastReceivedAsserts) {
        this.lastReceivedAsserts = lastReceivedAsserts;
    }

    /**
     * 获取 待收利息
     */
    public String getWaittingReceivedInterest() {
        return waittingReceivedInterest;
    }

    /**
     * 设置   待收利息
     */
    public void setWaittingReceivedInterest(String waittingReceivedInterest) {
        this.waittingReceivedInterest = waittingReceivedInterest;
    }

    /**
     * 获取 最近待收时间
     */
    public Date getLastWaittingReceivedDatetime() {
        return lastWaittingReceivedDatetime;
    }

    /**
     * 设置   最近待收时间
     */
    public void setLastWaittingReceivedDatetime(Date lastWaittingReceivedDatetime) {
        this.lastWaittingReceivedDatetime = lastWaittingReceivedDatetime;
    }

    /**
     * 获取 待还总额
     */
    public String getWaittingEarnedAwards() {
        return waittingEarnedAwards;
    }

    /**
     * 设置   待还总额
     */
    public void setWaittingEarnedAwards(String waittingEarnedAwards) {
        this.waittingEarnedAwards = waittingEarnedAwards;
    }

    /**
     * 获取 借款总额
     */
    public String getTotalBorrowedAsserts() {
        return totalBorrowedAsserts;
    }

    /**
     * 设置   借款总额
     */
    public void setTotalBorrowedAsserts(String totalBorrowedAsserts) {
        this.totalBorrowedAsserts = totalBorrowedAsserts;
    }

    /**
     * 获取 待付总额
     */
    public String getWaitttingPayedAsserts() {
        return waitttingPayedAsserts;
    }

    /**
     * 设置   待付总额
     */
    public void setWaitttingPayedAsserts(String waitttingPayedAsserts) {
        this.waitttingPayedAsserts = waitttingPayedAsserts;
    }

    /**
     * 获取 最近待还金额
     */
    public String getLastWaittingPayedAsserts() {
        return lastWaittingPayedAsserts;
    }

    /**
     * 设置   最近待还金额
     */
    public void setLastWaittingPayedAsserts(String lastWaittingPayedAsserts) {
        this.lastWaittingPayedAsserts = lastWaittingPayedAsserts;
    }

    /**
     * 获取 最近待还时间
     */
    public Date getLastWaittingPayedDatetime() {
        return lastWaittingPayedDatetime;
    }

    /**
     * 设置   最近待还时间
     */
    public void setLastWaittingPayedDatetime(Date lastWaittingPayedDatetime) {
        this.lastWaittingPayedDatetime = lastWaittingPayedDatetime;
    }
}