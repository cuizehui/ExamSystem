package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GradeDBuitl {
	// table
	public static final String TABLE_PASSWORD = "table_user_password";
	public static final String TABLE_USERINFO = "table_user_info";

	// connect to MySql database
	public static Connection getConnect() {
		String url = "jdbc:mysql://localhost:3306/"+DBString.DBNAME+"?useUnicode=true&characterEncoding=utf-8"; // 数据库的Url
		Connection connecter = null;
		try {
			Class.forName("com.mysql.jdbc.Driver"); // java反射，固定写法
			connecter = (Connection) DriverManager.getConnection(url, "root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		}
		return connecter;
	}

	// connection close
	
	public static void  closeConnect(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
