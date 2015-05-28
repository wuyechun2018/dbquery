package org.wuyechun.util.dbquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	/**
	 * 
	 * 功能 :获取数据库连接
	
	 * 开发：ycwu3 2015-4-28
	
	 * @return
	 */
	public static Connection getDbConn(String url,String user,String password){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection conn=null;
		try {
			conn = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
}
