package cn.com.study.application.order.pay.to;

import cn.com.study.application.order.pay.helper.AppCode;
import cn.com.study.application.order.pay.helper.PayType;
import cn.com.study.application.order.pay.helper.UseType;

public abstract class AbstractPaymentInfomation {
	/** 当前系统域名 */
	private String contextPath;
	
	/** 当前系统编号 */
	private AppCode appCode = AppCode.SI2009;
	
	/** 是否测试版 默认为PC端支付 */
	private String beta = "";
	
	/** 签名方式 */
	private String signType = "MD5";
	
	private String charset = "utf-8";
	
	/** 支付系统: 默认是支付宝支付,其他微信支付 */
	public PayType payType = PayType.alipay;
	
	/** 网页支付或是移动支付 */
	private UseType wapOrMobile = UseType.web;
	
	public String getContextPath() {
		return contextPath;
	}

	public void setContextPath(String contextPath) {
		this.contextPath = contextPath;
	}

	public AppCode getAppCode() {
		return appCode;
	}

	/**
	 * 当前系统编号:如 家有汇(SI2009),惠家有(SI2003);
	 * 默认家有汇(SI2009)
	 * @see cn.com.study.application.order.pay.helper.AppCode
	 * @param appCode
	 */
	public void setAppCode(AppCode appCode) {
		this.appCode = appCode;
	}

	public String getBeta() {
		return beta;
	}
	
	protected void setBeta(String beta) {
		this.beta = beta;
	}
	
	public PayType getPayType() {
		return payType;
	}
	
	/**
	 * 选择支付方式:支付宝或微信;
	 * @see cn.com.study.application.order.pay.helper.PayType
	 * @param payType
	 */
	public void setPayType(PayType payType) {
		this.payType = payType;
	}

	public String getCharset() {
		return charset;
	}

	protected void setCharset(String charset) {
		this.charset = charset;
	}

	public String getSignType() {
		return signType;
	}

	protected void setSignType(String signType) {
		this.signType = signType;
	}
	
	public UseType getWapOrMobile() {
		return wapOrMobile;
	}

	/**
	 * 使用支付种类选择:默认是PC网页版支付
	 * @see cn.com.study.application.order.pay.helper.UseType
	 * @param wapOrMobile
	 */
	public void setWapOrMobile(UseType wapOrMobile) {
		this.wapOrMobile = wapOrMobile;
	}
}