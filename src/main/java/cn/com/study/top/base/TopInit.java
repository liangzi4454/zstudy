package cn.com.study.top.base;

import cn.com.study.cache.ehcache.TableCache;

/**
 * 初始化类
 * 
 */
public class TopInit extends RootInit implements IBaseInit {

	public synchronized boolean onInit() {
		initTop();
		return true;

	}

	/**
	 * 初始化顶级配置
	 */
	private void initTop() {
		TableCache tableCache = new TableCache();
		topInitCache(tableCache);
	}
	
	@Override
	public boolean onDestory() {
		boolean bFlagInit = true;

		return bFlagInit;
	}

}
