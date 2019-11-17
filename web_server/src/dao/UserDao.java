package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import bean.User;

import util.Jdbc;

public class UserDao {
	public static User login(String username,String password){
		Connection conn = Jdbc.openDB();
		User user = null;
		String sql ="select * from user where username=? and password = ?";
		
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			
		     ResultSet rs =  pre.executeQuery();
			 if(rs.next()){
		     user = new User();
		     user.setUid(rs.getInt("uid"));
			 user.setUsername(rs.getString("username"));
			 user.setPassword(rs.getString("password"));
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return user;
		
	}
	public boolean Regist(String username,String password) {
		Connection conn = Jdbc.openDB();
		String sql = "insert into user(username,password) VALUES(?,?)";
		try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setString(1, username);
			pre.setString(2, password);
			int rs = pre.executeUpdate();
		
			if(rs==1) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
}
