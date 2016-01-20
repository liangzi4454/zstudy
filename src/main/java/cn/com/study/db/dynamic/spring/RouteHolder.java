package cn.com.study.db.dynamic.spring;

public class RouteHolder {
	public static final String DATA_SOURCE_FROM = "dataSourceFrom";
	public static final String DATA_SOURCE_TO = "dataSourceTo";
	private static ThreadLocal<String> routeKey = new ThreadLocal<String>();
	
	/**
	 * 获取当前线程的数据源路由的key
	 * 
	 * @return
	 */
	public static String getRouteKey() {
		return routeKey.get();
	}

	/**
	 * 绑定当前线程数据源路由的key 使用完成后必须调用removeRouteKey删除
	 * 
	 * @param key
	 */
	public static void setRouteKey(String key) {
		routeKey.set(key);
	}

	/**
	 * 删除与当前线程绑定的数据源路由的key
	 */
	public static void removeRouteKey() {
		routeKey.remove();
	}
}