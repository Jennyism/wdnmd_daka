package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbc {
	private static String URL="jdbc:mysql://localhost:3306/wdnmd_daka";
	private static String USER="root";
	private static String PASSWORD="1234";
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public static Connection openDB(){
		
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public static void close(Connection conn){
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Connection conn = openDB();
		if(conn!=null){
			System.out.println("数据库访问成功");
	
			close(conn);
		}else{
			System.out.println("数据库启动失败");
		}
	}
}
