package cn.com.study.application.order.pay.alipay;

import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.com.study.application.order.pay.alipay.util.AlipaySubmit;
import cn.com.study.application.order.pay.helper.Paymethod;
import cn.com.study.application.order.pay.helper.UseType;
import cn.com.study.application.order.pay.to.AbstractPaymentBean;
import cn.com.study.application.order.pay.to.PaymentBean;

public class AlipayPaymentBean extends AbstractPaymentBean implements PaymentBean<AlipayPaymentInfomation> {
	
	/** 签名方式:默认MD5 */
	public static final String SIGN_TYPE = "sign_type";
	/** */
	public static final String _INPUT_CHARSET = "_input_charset";
	
	/** 接口名称 不可空 */
	public static final String SERVICE_NAME = "service";
	
	/** 合作者身份ID */
	public static final String PARTNER_NAME = "partner";
	
	/** 卖家支付宝用户号 */
	public static final String SELLER_ID = "seller_id";
	
	/** 卖家支付宝账号  */
	public static final String SELLER_EMAIL = "seller_email";
	
	/** */
	public static final String PAY_METHOD = "paymethod";
	
	/** */
	public static final String PAYMENT_TYPE = "payment_type";
	
	/** */
	public static final String DEFAULT_BANK = "defaultbank";
	
	public static final String OUT_TRADE_NO = "out_trade_no";
	
	/** 商品描述 */
	public static final String BODY = "body";
	
	/** 商品名称 */
	public static final String SUBJECT = "subject";
	
	/** 总价:改价格与单价二选一,该价格若不为null且不为0则数量必须为1 */
	public static final String TOTAL_FEE = "total_fee";

	/** 单价:改价格与总价二选一,若总价格为null或为0,则该单价不能为null或0 */
	public static final String PRICE = "price";
	
	/** 数量 */
	public static final String QUANTITY = "quantity";
	
	/** */
	public static final String RETURN_URL = "return_url";
	
	/** */
	public static final String NOTIFY_URL = "notify_url";
	
	/** */
	public static final String KEY = "key";
	
	/** 公用回传参数 */
	public static final String EXTRA_COMMON_PARAM = "extra_common_param";
	
	/** 超时时间 */
	public static final String IT_B_PAY = "it_b_pay";
	
	public static final AlipayPaymentBean instance = new AlipayPaymentBean();
	
	protected Map<String, String> getResult(UseType useType) {
		Map<String, String> result = getResult();
		Iterator<Map.Entry<String, String>> it = result.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			String key = entry.getKey();
			if(UseType.web==useType) {
				if(key.endsWith(SERVICE_NAME) && !key.startsWith(SERVICE_NAME)) {
					it.remove(); // OK
				} else if(key.endsWith(NOTIFY_URL) && !key.startsWith(NOTIFY_URL)) {
					it.remove();
				} else if(key.endsWith(RETURN_URL) && !key.startsWith(RETURN_URL)) {
					it.remove();
				}
			} else if (UseType.wap==useType) {
				if(key.endsWith(SERVICE_NAME) && key.startsWith(String.valueOf(UseType.mobile))) {
					it.remove(); // OK
				} else if(key.endsWith(KEY) && key.startsWith(String.valueOf(UseType.wap))) {
					it.remove(); // OK
				} else if(key.endsWith(SERVICE_NAME) && key.startsWith(String.valueOf(UseType.wap))) {
					result.put(SERVICE_NAME, result.get(key));
					it.remove(); // OK
				} else if(key.endsWith(NOTIFY_URL) && key.startsWith(String.valueOf(UseType.mobile))) {
					it.remove(); // OK
				} else if(key.endsWith(NOTIFY_URL) && key.startsWith(String.valueOf(UseType.wap))) {
					result.put(NOTIFY_URL, result.get(key));
					it.remove(); // OK
				} else if(key.endsWith(RETURN_URL) && key.startsWith(String.valueOf(UseType.mobile))) {
					it.remove(); // OK
				} else if(key.endsWith(RETURN_URL) && key.startsWith(String.valueOf(UseType.wap))) {
					result.put(RETURN_URL, result.get(key));
					it.remove(); // OK
				}
			} else if(UseType.mobile==useType) {
				if(key.endsWith(SERVICE_NAME) && key.startsWith(String.valueOf(UseType.wap))) {
					it.remove(); // OK
				} else if(key.endsWith(KEY) && key.startsWith(String.valueOf(UseType.mobile))) {
					result.put(KEY, result.get(key));
					it.remove(); // OK
				} else if(key.endsWith(SERVICE_NAME) && key.startsWith(String.valueOf(UseType.mobile))) {
					result.put(SERVICE_NAME, result.get(key));
					it.remove(); // OK
				} else if(key.endsWith(NOTIFY_URL) && key.startsWith(String.valueOf(UseType.wap))) {
					it.remove(); // OK
				} else if(key.endsWith(NOTIFY_URL) && key.startsWith(String.valueOf(UseType.mobile))) {
					result.put(NOTIFY_URL, result.get(key));
					it.remove(); // OK
				} else if(key.endsWith(RETURN_URL) && key.startsWith(String.valueOf(UseType.wap))) {
					it.remove(); // OK
				} else if(key.endsWith(RETURN_URL) && key.startsWith(String.valueOf(UseType.mobile))) {
					it.remove(); // OK
				} else if(key.endsWith(RETURN_URL) && key.startsWith(String.valueOf(UseType.mobile))) {
					it.remove(); // OK
				} 
			}
		}
		return result;
	}

	public Map<String, String> processCheckBean(AlipayPaymentInfomation infomation) {
		UseType useType = infomation.getWapOrMobile();
		Map<String, String> result = this.getResult(useType);
		
		result.put(OUT_TRADE_NO, infomation.getOutTradeNo());
		result.put(_INPUT_CHARSET, infomation.getCharset());
		result.put(SIGN_TYPE, infomation.getSignType());
		result.put(SUBJECT, infomation.getSubject());
		result.put(PAYMENT_TYPE, infomation.getPaymentType());
		result.put(SELLER_ID, result.get(PARTNER_NAME));
		
		if(infomation.getTotalFee()==null||infomation.getTotalFee()==0) {
			if(infomation.getPrice()==null||infomation.getPrice()==0) {
				return result;
			}
			if(infomation.getQuantity()==0) {
				return result;
			}
			result.put(PRICE, String.valueOf(infomation.getPrice()));
			result.put(QUANTITY, String.valueOf(infomation.getQuantity()));
		} else {
			result.put(TOTAL_FEE, String.valueOf(infomation.getTotalFee()));
			result.put(QUANTITY, "1");
		}
		if(StringUtils.isBlank(infomation.getSubject())) {
			return result;
		}
		if(StringUtils.isNotBlank(infomation.getBody())) {
			result.put(BODY, infomation.getBody());
		}
		
		result.put(PAY_METHOD, String.valueOf(infomation.getPaymethod()));
		if(infomation.getDefaultBank()!=null) {
			result.put(DEFAULT_BANK, String.valueOf(infomation.getDefaultBank()));
			result.put(PAY_METHOD, String.valueOf(Paymethod.bankPay));
		}
		if(useType==UseType.web && StringUtils.isNotBlank(infomation.getExtraCommonParam())) {
			result.put(EXTRA_COMMON_PARAM, infomation.getExtraCommonParam());
		}
		if(useType==UseType.mobile && StringUtils.isNotBlank(infomation.getItBPay())) {
			result.put(IT_B_PAY, infomation.getItBPay());
		}
		return result;
	}
	
	/**
	 * 生成form表单
	 */
	public String process(AlipayPaymentInfomation infomation) {
		readProperties(infomation);
		Map<String, String> result = processCheckBean(infomation);
		if(UseType.mobile.equals(infomation.getWapOrMobile())) {
			//提交到支付宝的地址为:https://wappaygw.alipay.com/service/rest.htm?也要传过去,暂时没传
			return AlipaySubmit.buildMobileRequest(result);
		} else {
			return AlipaySubmit.buildRequest(result, "ok");
		}
	}
}
