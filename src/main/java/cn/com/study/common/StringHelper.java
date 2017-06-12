package cn.com.study.common;

import java.util.UUID;


public class StringHelper {
	/**
	 * 随机生成32位字符串
	 * @return 32位字符串
	 */
	public static final String uUid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
