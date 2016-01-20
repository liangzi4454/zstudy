package cn.com.stuty.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;

import cn.com.study.db.dynamic.c3p0.DBPool;
import cn.com.study.db.dynamic.c3p0.UsePoolBackedDataSource;

public class DBPoolTest {
	@Test
	public void testDBPool() {
		Connection con = null;
		try {
			con = DBPool.getInstance().init("root", "", "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test?user=root&password=&useUnicode=true&characterEncoding=utf8").getConnection();
			ResultSet rs = con.createStatement().executeQuery("select * from user_t");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getObject(2));
				System.out.println(rs.getObject(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Test
	public void testUsePoolBackedDataSource() {
		UsePoolBackedDataSource usePoolBackedDataSource = new UsePoolBackedDataSource();
		DataSource dataSource = usePoolBackedDataSource.getDataSource("root", "", "", "jdbc:mysql://localhost:3306/test?user=root&password=&useUnicode=true&characterEncoding=utf8");
		Connection con = null;  
        Statement stmt = null;  
        ResultSet rs = null;  
        try {  
            con = dataSource.getConnection();  
            stmt = con.createStatement();  
            rs = stmt.executeQuery("select * from user_t");  
            while (rs.next())  
                System.out.println(rs.getString(1));  
        } catch (SQLException e) {
			e.printStackTrace();
		} finally {  
        	usePoolBackedDataSource.attemptClose(rs);  
        	usePoolBackedDataSource.attemptClose(stmt);  
        	usePoolBackedDataSource.attemptClose(con);  
        }  
	}
}
