package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
	public static Connection getConnection() {
		Connection c = null;
		try {
			//Tạo driver class của mySQL băng DriverManager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//Khai báo các thông tin đường dẫn, username, password
			String url = "jdbc:mySQL://localhost:3306/quanlynoithat";
			String username = "root";
			String password = "";
			//Tạo kết nối bằng DriverManager
			c = DriverManager.getConnection(url, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
