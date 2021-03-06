package cn.com.study.cache.ehcache;

import java.net.URL;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;

import org.apache.commons.lang.StringUtils;

import cn.com.study.top.base.TopBase;

/**
 * 缓存定义类
 * 
 * @author srnpr
 * 
 */
public class CacheDefine extends TopBase {

	private static CacheManager cManager;

	/**
	 * Cache名称如果以该值开始 则标记该cache继承自rootcache
	 */
	private final static String CACHE_TYPE_NO_ETERNAL = "rootcache:";

	/**
	 * 自定义cache 该cache自由设置配置 清除缓存时不清除该类cache
	 */
	private final static String CACHE_TYPE_CUSTOM = "customcache:";

	/**
	 * 缓存定义
	 */
	public CacheDefine() {
		if (cManager == null) {
			URL url = this.getClass().getResource("/META-INF/ehcache/ehcache.xml");
			cManager = CacheManager.create(url);
		}
	}

	/**
	 * 添加缓存:
	 * 一个CacheManager管理多个cache,每个cache必须有不同的名字,否则报错;
	 * 所以该方法的作用是通过硬编码的方式将原来ehcache.xml中的配置的每个cache换成编码的方式添加到CacheManager;
	 * 
	 * @param sCacheName
	 * @return
	 */
	public synchronized Cache inCache(String sCacheName) {

		sCacheName = CACHE_TYPE_NO_ETERNAL + sCacheName;

		if (cManager.cacheExists(sCacheName)) {
			return upCache(sCacheName);
		} else {

			CacheConfiguration cacheConfiguration = new CacheConfiguration();
			cacheConfiguration.setName(sCacheName);
			cacheConfiguration.setEternal(true);
			cacheConfiguration.setTimeToIdleSeconds(0);
			//cacheConfiguration.setTimeToIdleSeconds(0);
			cacheConfiguration.setMaxEntriesLocalHeap(99999999);
			Cache memoryOnlyCache = new Cache(cacheConfiguration);
			cManager.addCache(memoryOnlyCache);
			return memoryOnlyCache;
		}
	}

	/**
	 * 添加自定义的缓存
	 * 
	 * @param sCacheName
	 * @param cacheConfiguration
	 * @return
	 */
	public synchronized Cache inCustomCache(String sCacheName,
			CacheConfiguration cacheConfiguration) {

		sCacheName = CACHE_TYPE_CUSTOM + sCacheName;

		if (cManager.cacheExists(sCacheName)) {
			return upCache(sCacheName);
		} else {

			Cache memoryOnlyCache = new Cache(cacheConfiguration);

			cManager.addCache(memoryOnlyCache);

			return memoryOnlyCache;
		}
	}

	/**
	 * 获取缓存
	 * 
	 * @param sCacheName
	 * @return
	 */
	public Cache upCache(String sCacheName) {
		return cManager.getCache(sCacheName);
	}

	/**
	 * 清除所有继承自rootcache的缓存
	 */
	public synchronized void removeAllCache() {

		for (String sKey : cManager.getCacheNames()) {

			if (StringUtils.startsWith(sKey, CACHE_TYPE_NO_ETERNAL)) {
				Cache cache = upCache(sKey);

				bLogInfo(0, "remove cache:" + cache.getName());
				cache.removeAll();
			}

		}

	}

}
