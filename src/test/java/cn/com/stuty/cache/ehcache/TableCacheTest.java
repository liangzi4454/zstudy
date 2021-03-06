package cn.com.stuty.cache.ehcache;

import org.junit.Test;

import cn.com.study.cache.ehcache.TableCache;
import cn.com.study.top.base.TopUp;

public class TableCacheTest {
	@Test
	public void testCache() {
		TableCache tableCache = new TableCache();
		tableCache.inElement("table_name", "user_t");
		System.out.println(tableCache.upValue("table_name"));
		tableCache.removeByKey("table_name");;
		System.out.println(tableCache.upValue("table_name"));
		
		System.out.println(TopUp.upConfig("mailUser"));
	}
}
