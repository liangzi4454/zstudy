package cn.com.study.application.order.pay.to;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cn.com.study.application.order.pay.helper.PropertyUtils;
import cn.com.study.application.order.pay.helper.UseType;

public abstract class AbstractPaymentBean {
	private Map<String, String> result = new HashMap<String, String>();
	/**
	 * 格式:
	 * beta_appCode_os_*
	 * <br>
	 * 参数：
	 * appCode:2009 家有汇
	 * beta:beta测试版,""生产版
	 * os:alipay
	 * <br>
	 * 说明:
	 * beta_2009_alipay_* 家有汇测试版
	 * @param bean
	 */
	private String setPrefix(AbstractPaymentInfomation bean) {
		StringBuffer buffer = new StringBuffer();
		if(StringUtils.isNotBlank(bean.getBeta())){
			buffer.append(bean.getBeta()).append("_");
		}
		buffer.append(bean.getAppCode()).append("_");
		buffer.append(bean.getPayType()).append("_");
		return buffer.toString();
	}
	
	public Map<String, String> readProperties(AbstractPaymentInfomation infomation) {
		String prefix = setPrefix(infomation);
		Map<String, String> map = PropertyUtils.loadProperties(prefix);
		for(String key: map.keySet()) {
			if(key.startsWith(prefix)) {
				result.put(key.substring(prefix.length(), key.length()), map.get(key));
			}
		}
		return result;
	}

	protected Map<String, String> getResult() {
		return result;
	}

	protected void setResult(Map<String, String> result) {
		this.result = result;
	}
	protected Map<String, String> getResult(UseType useType) {
		return null;
	}

}