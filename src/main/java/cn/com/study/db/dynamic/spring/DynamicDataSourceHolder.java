package cn.com.study.db.dynamic.spring;

public class DynamicDataSourceHolder {
	public static final String DATASOURCE1 = "datasource1";
	public static final String DATASOURCE2 = "datasource2";
	private static ThreadLocal<String> routeKey = new ThreadLocal<String>();
	
	/**
	 * 获取当前线程的数据源路由的key
	 * 
	 * @return
	 */
	public static String getDataSource() {
		return routeKey.get();
	}

	/**
	 * 绑定当前线程数据源路由的key 使用完成后必须调用removeRouteKey删除
	 * 
	 * @param key
	 */
	public static void setDataSource(String key) {
		routeKey.set(key);
	}

	/**
	 * 删除与当前线程绑定的数据源路由的key
	 */
	public static void removeDataSource() {
		routeKey.remove();
	}
}