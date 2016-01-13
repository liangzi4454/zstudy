package cn.com.study.top.base;

import cn.com.study.cache.ehcache.TopConfig;

/**
 * 获取类 取该取的
 * @author srnpr
 *
 */
public class TopUp implements IBaseUp {
	/**
	 * 获取配置
	 * @param sKey
	 * @return
	 */
	public static String upConfig(String sKey) {
		return TopConfig.Instance.upValue(sKey);
	}
}