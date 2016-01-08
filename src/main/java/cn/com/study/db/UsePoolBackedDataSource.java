package cn.com.study.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.DataSources;

/**
 * 此示例演示如何以编程方式，直接使用数据库连接池中的数据源
 * 
 * @author LHY 2016年1月6日 上午10:59:15
 */
public class UsePoolBackedDataSource {
	
	public DataSource getDataSource(String user, String password, String driverClass, String jdbcUrl) {
		DataSource pooled = null;
		try {
			DataSource dataSource = DataSources.unpooledDataSource(jdbcUrl, user, password);
			pooled = DataSources.pooledDataSource(dataSource);  
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pooled;
	}
	
	public void attemptClose(ResultSet o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void attemptClose(Statement o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void attemptClose(Connection o) {
		try {
			if (o != null)
				o.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}