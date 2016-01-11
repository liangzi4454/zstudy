package cn.com.study.application.order.pay.from;

import cn.com.study.application.order.pay.alipay.AlipayPaymentInfomation;

/**
 * @author LHY 2015年11月27日 下午2:07:59
 */
public class AlipayNotifyInfomation extends AlipayPaymentInfomation {
	/** 交易序列号 */
	private String bankSeqNo = "";
	/** 买家支付宝账号 */
	private String buyerId = "";
	
	private double discount;
	
	/** 支付宝上订单创建时间 */
	private String gmtCreate = "";
	
	/** 支付宝上交易时间 */
	private String gmtPayment = "";
	
	/** */
	private String isTotalFeeAdjust = "";
	
	/** 通知表示 */
	private String notifyId = "";
	
	/** 通知时间 */
	private String notifyTime = "";
	
	/** 通知类型：trade_status_sync异步通知 */
	private String notifyType = "";
	
	/** 支付宝返回签名 */
	private String sign = "";
	
	/** 交易流水号 */
	private String tradeNo = "";
	
	/** 交易状态: TRADE_SUCCESS交易成功,TRADE_FINISH交易完成 */
	private String tradeStatus = "";
	
	/** 是否使用优惠券: N为否,Y为是 */
	private String useCoupon = "N";

	public String getBankSeqNo() {
		return bankSeqNo;
	}

	public void setBankSeqNo(String bankSeqNo) {
		this.bankSeqNo = bankSeqNo;
	}

	public String getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(String gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getGmtPayment() {
		return gmtPayment;
	}

	public void setGmtPayment(String gmtPayment) {
		this.gmtPayment = gmtPayment;
	}

	public String getIsTotalFeeAdjust() {
		return isTotalFeeAdjust;
	}

	public void setIsTotalFeeAdjust(String isTotalFeeAdjust) {
		this.isTotalFeeAdjust = isTotalFeeAdjust;
	}

	public String getNotifyId() {
		return notifyId;
	}

	public void setNotifyId(String notifyId) {
		this.notifyId = notifyId;
	}

	public String getNotifyTime() {
		return notifyTime;
	}

	public void setNotifyTime(String notifyTime) {
		this.notifyTime = notifyTime;
	}

	public String getNotifyType() {
		return notifyType;
	}

	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}

	String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getTradeStatus() {
		return tradeStatus;
	}

	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}

	public String getUseCoupon() {
		return useCoupon;
	}

	public void setUseCoupon(String useCoupon) {
		this.useCoupon = useCoupon;
	}
}