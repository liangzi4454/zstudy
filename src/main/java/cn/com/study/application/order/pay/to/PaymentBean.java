package cn.com.study.application.order.pay.to;

import java.util.Map;

public interface PaymentBean<T extends AbstractPaymentInfomation> {
	/**
	 * 系统处理
	 * @param infomation
	 * @return
	 */
	public String process(T t);
	
//	public Map<String, String> processCheckBean(T t);
}
