package com.courseportel.dbconnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection conn = null;

	public static Connection getDbConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", "courseportal",
					"courseportal");

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return conn;
	}
	public static void dbConnClose()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
