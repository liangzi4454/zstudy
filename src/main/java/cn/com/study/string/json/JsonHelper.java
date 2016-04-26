package cn.com.study.string.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author LHY
 * JSON帮助类
 * @param <T>
 */
@SuppressWarnings("all")
public class JsonHelper<T> {
	/**
	 * 对象转换为字符串
	 * @param oInput
	 * @return
	 */
	public String object2String(T oInput) {
		ObjectMapper om = new ObjectMapper();
		om.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

		String sResponseString = null;
		try {
			sResponseString = om.writeValueAsString(oInput);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return sResponseString;
	}
	
	/**
	 * 字符串转为对象
	 * @param sInput JSON字符串
	 * @param t 接收JSON转换的对象
	 * @return t 对象
	 */
	public T string2Object(String sInput, T t) {
		ObjectMapper om = new ObjectMapper();
		try {
			t = (T) om.readValue(sInput, t.getClass());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}