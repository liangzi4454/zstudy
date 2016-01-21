package cn.com.study.db.dynamic.spring;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 自定义的动态路由数据源 继承自 spring jdbc的AbstractRoutingDataSource
 * @author Administrator
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

	/**
	 * 获取与数据源相关的key
	 * 此key是Map<String,DataSource> resolvedDataSources 中与数据源绑定的key值
	 * 在通过determineTargetDataSource获取目标数据源时使用
	 */
	@Override
	protected Object determineCurrentLookupKey() {
		
		return DynamicDataSourceHolder.getRouteKey();
	}

}
