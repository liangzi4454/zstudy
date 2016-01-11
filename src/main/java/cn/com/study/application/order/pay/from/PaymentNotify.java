package cn.com.study.application.order.pay.from;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.com.study.application.order.pay.alipay.AlipayPaymentBean;
import cn.com.study.application.order.pay.alipay.util.AlipayNotify;
import cn.com.study.application.order.pay.helper.AppCode;

public class PaymentNotify {
	private static PaymentNotify instance = null;
	private PaymentNotify() {}
	
	public static final PaymentNotify getInstance() {
		if(instance==null) {
			instance = new PaymentNotify();
			return instance;
		}
		return instance;
	}
	public AlipayNotifyInfomation doProcess(AppCode appCode, Map requestParams) {
		
		Map<String,String> params = new HashMap<String,String>();
		for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			if(name.equals("subject")) {
				params.put(name, "商品1");
			} else {
				params.put(name, valueStr);
			}
		}
		AlipayNotifyInfomation infomation = new AlipayNotifyInfomation();
		infomation.setAppCode(appCode);
		infomation = this.setInfomation(infomation, params);
		Map<String, String> result = AlipayPaymentBean.instance.readProperties(infomation);
		params.put("partner", result.get("partner"));
		params.put("charset", infomation.getCharset());
		params.put("key", result.get("key"));
		boolean a = cn.com.study.application.order.pay.alipay.util.AlipayNotify.verify(params);
		return infomation;
	}
	private AlipayNotifyInfomation setInfomation(AlipayNotifyInfomation infomation, Map<String,String> params) {
		infomation.setBankSeqNo(params.get("bank_seq_no"));
		infomation.setBody(params.get("body"));
		infomation.setBuyerId(params.get("buyer_id"));
		infomation.setDiscount(Double.parseDouble(params.get("discount")));
		infomation.setGmtCreate(params.get("gmt_create"));
		infomation.setGmtPayment(params.get("gmt_payment"));
		infomation.setIsTotalFeeAdjust(params.get("is_total_fee_adjust"));
		infomation.setNotifyId(params.get("notify_id"));
		infomation.setNotifyTime(params.get("notify_time"));
		infomation.setNotifyType(params.get("notify_type"));
		infomation.setOutTradeNo(params.get("out_trade_no"));
		infomation.setPrice(Double.parseDouble(params.get("price")));
		infomation.setQuantity(Integer.parseInt(params.get("quantity")));
		infomation.setSubject(params.get("subject"));
		infomation.setTotalFee(Double.parseDouble(params.get("total_fee")));
		infomation.setTradeNo(params.get("trade_no"));
		infomation.setTradeStatus(params.get("trade_status"));
		infomation.setUseCoupon(params.get("use_coupon"));
		infomation.setExtraCommonParam(params.get("extra_common_param"));
		return infomation;
	}
}