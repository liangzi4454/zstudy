package cn.com.study.application.order.pay.to;

import cn.com.study.application.order.pay.alipay.AlipayPaymentBean;
import cn.com.study.application.order.pay.alipay.AlipayPaymentInfomation;
import cn.com.study.application.order.pay.wechat.WechatPaymentBean;
import cn.com.study.application.order.pay.wechat.WechatPaymentInfomation;

public class Payment {
	private static Payment instance = null;
	private Payment() {}
	
	public static final Payment getInstance() {
		if(instance==null) {
			instance = new Payment();
			return instance;
		}
		return instance;
	}
	public String doProcess(AbstractPaymentInfomation infomation) {
		if(null==infomation) {
			throw new NullPointerException("cn.com.study.application.order.pay.AbstractPaymentInfomation 对象不能为空");
		}
		String submitForm = "";
		if(infomation instanceof AlipayPaymentInfomation) {
			submitForm = AlipayPaymentBean.instance.process((AlipayPaymentInfomation) infomation);
		} else {
			submitForm = WechatPaymentBean.instance.process((WechatPaymentInfomation) infomation);
		}
		return submitForm;
	}
}