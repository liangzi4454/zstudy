package cn.com.study.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 使用c3p0数据库连接池
 * @author LHY
 * 2016年1月6日 上午11:11:53
 */
public class DBPool {
	private static DBPool dbPool;
	private ComboPooledDataSource comboPooledDataSource;
	
	static {
		dbPool = new DBPool();
	}
	
	private DBPool() {
	}
	
	public static final DBPool getInstance() {
		return dbPool;
	}
	
	public ComboPooledDataSource init(String user, String password, String driverClass, String jdbcUrl) {
		try {
			comboPooledDataSource = new ComboPooledDataSource();
			comboPooledDataSource.setUser(user);
			comboPooledDataSource.setPassword(password);
			comboPooledDataSource.setDriverClass(driverClass);
			comboPooledDataSource.setJdbcUrl(jdbcUrl);
			//设置初始连接池的大小
			comboPooledDataSource.setInitialPoolSize(2);
			//设置连接池的最小值
			comboPooledDataSource.setMinPoolSize(1);
			//设置连接池的最大值
			comboPooledDataSource.setMaxPoolSize(10);
			//设置连接池中的最大Statements数量！
			comboPooledDataSource.setMaxStatements(60);
			//设置连接池的最大空闲时间
			comboPooledDataSource.setMaxIdleTime(60);
		} catch (Exception e) {
			comboPooledDataSource.close();
			comboPooledDataSource = null;
			throw new RuntimeException(e);
		}
		return comboPooledDataSource;
	}
}