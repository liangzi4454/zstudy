package cn.com.stuty.cache.ehcache;

import org.junit.Test;

import cn.com.study.cache.ehcache.TableCache;

public class TableCacheTest {
	@Test
	public void testCache() {
		TableCache tableCache = new TableCache();
		tableCache.upOne("123");
		tableCache.inElement("table_name", "user_t");
		System.out.println(tableCache.upValue("table_name"));
	}
}
