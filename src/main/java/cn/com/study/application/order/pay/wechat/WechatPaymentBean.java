package cn.com.study.application.order.pay.wechat;

import java.util.Map;

import cn.com.study.application.order.pay.to.AbstractPaymentBean;
import cn.com.study.application.order.pay.to.PaymentBean;

public class WechatPaymentBean extends AbstractPaymentBean implements PaymentBean<WechatPaymentInfomation> {
	protected Map<String, String> processCheckBean(WechatPaymentInfomation infomation) {
		
		return null;
	}

	public static final WechatPaymentBean instance =  new WechatPaymentBean();
	
	public String process(WechatPaymentInfomation infomation) {
		readProperties(infomation);
		return null;
	}
}
