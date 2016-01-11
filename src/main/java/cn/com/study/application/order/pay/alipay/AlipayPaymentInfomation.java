package cn.com.study.application.order.pay.alipay;

import cn.com.study.application.order.pay.helper.BankType;
import cn.com.study.application.order.pay.helper.Paymethod;
import cn.com.study.application.order.pay.to.AbstractPaymentInfomation;

/**
 * @author LHY 2015年11月27日 下午2:07:59
 */
public class AlipayPaymentInfomation extends AbstractPaymentInfomation {
	
	/** 合作者身份ID: 以2088开头的16位纯数字组成  */
	private String partner = "";
	
	/** 商户网站唯一订单号 */
	private String outTradeNo = "";
	
	/** 商品名称 */
	private String subject = "商品";
	
	/** 支付类型:1、 商品购买 */
	private String paymentType = "1";
	
	/** 交易金额:取值范围为[0.01,100000000.00],精确到小数点后两位 */
	private Double totalFee = 0d;
	
	/** 卖家支付宝用户号: 以2088开头的纯16位数字  不可空*/
	private String sellerId = "";
	
	/** 卖家支付宝账号: 格式为手机号或邮箱  可为空 */
	private String sellerEmail = "";
	
	/** 卖家别名支付宝账号: 卖家信息优先级：seller_id>seller_account_name>seller_email 可为空*/
	private String sellerAccountName = "";
	
	/** 商品单价: 取值范围为[0.01,100000000.00],精确到小数点后两位 */
	private Double price = 0d;
	
	/** 购买数量: 存在total_fee,就不能存在price和quantity;存在price和quantity,就不能存在total_fee */
	private int quantity = 0;

	/** 商品描述: 可为空 */
	private String body = "";
	
	/** 商品展示网址 */
	private String showUrl = "";
	
	/** 默认支付方式: 如果不设置,默认识别为余额支付;bankPay(网银支付)、directPay(余额宝支付)、creditPay(信用支付)*/
	private Paymethod paymethod = Paymethod.directPay;
	
	/** 银行卡支付 :如CMB、CMB */
	private BankType defaultBank;
	
	/** 交易超时时间,该参数需要与支付宝联系*/
	private String itBPay;
	
	/** 公用回传参数:如果用户请求时传递了该参数，则返回给商户时会回传该参数 */
	private String extraCommonParam = "";
	
	public String getPartner() {
		return partner;
	}

	protected void setPartner(String partner) {
		this.partner = partner;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPaymentType() {
		return paymentType;
	}

	protected void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public Double getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(Double totalFee) {
		this.totalFee = totalFee;
	}

	public String getSellerId() {
		return sellerId;
	}

	protected void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	protected void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerAccountName() {
		return sellerAccountName;
	}

	protected void setSellerAccountName(String sellerAccountName) {
		this.sellerAccountName = sellerAccountName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	protected String getShowUrl() {
		return showUrl;
	}

	protected void setShowUrl(String showUrl) {
		this.showUrl = showUrl;
	}

	public Paymethod getPaymethod() {
		return paymethod;
	}

	/**
	 * 支付方式范围: 如果不设置,默认识别为余额支付;bankPay(网银支付)、directPay(余额宝支付)、creditPay(信用支付)
	 * @see cn.com.study.application.order.pay.helper.Paymethod
	 * @param paymethod
	 */
	public void setPaymethod(Paymethod paymethod) {
		this.paymethod = paymethod;
	}

	public String getExtraCommonParam() {
		return extraCommonParam;
	}

	public void setExtraCommonParam(String extraCommonParam) {
		this.extraCommonParam = extraCommonParam;
	}

	public BankType getDefaultBank() {
		return defaultBank;
	}

	/**
	 * 银行卡支付,使用简写代码 :如CMB(招商银行)、CCB(建设银行)
	 * @see cn.com.study.application.order.pay.helper.BankType
	 * @param defaultBank
	 */
	public void setDefaultBank(BankType defaultBank) {
		this.defaultBank = defaultBank;
	}

	public String getItBPay() {
		return itBPay;
	}

	/**
	 * 超时时间,该参数需要与支付宝联系开通
	 * @param itBPay
	 */
	public void setItBPay(String itBPay) {
		this.itBPay = itBPay;
	}
}