package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Jdbc;
import bean.Daka;
import bean.User;

public class DakaDao {
	 public int daka(int uid,String date,String time) {
		 int num = 0;
		 Connection conn = Jdbc.openDB();
		 String sql1 = "select * from daka where uid = ? and date = ?";
		 PreparedStatement pre;
		 ResultSet rs;
		 try {
			pre = conn.prepareStatement(sql1);
			pre.setInt(1, uid);
			pre.setString(2, date);
			rs = pre.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getInt("uid"));
				return -1;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		 String sql = "insert into daka(uid,date,time) value (?,?,?)";
		
		try {
			pre = conn.prepareStatement(sql);
			pre.setInt(1, uid);
		    pre.setString(2, date);
		    pre.setString(3, time);
		    num = pre.executeUpdate();
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return num;
      
	 }
	 public List<Daka> ShowRecord(String uid){
		 List<Daka> dakalist = new ArrayList<Daka>();
		 Connection conn = Jdbc.openDB();
		 String sql = "select *  from user,daka where daka.uid = user.uid and daka.uid = ? ";
		 try {
			PreparedStatement pre = conn.prepareStatement(sql);
			pre.setInt(1, Integer.parseInt(uid));
			ResultSet rs = pre.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setUid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				Daka daka = new Daka();
				daka.setUser(user);
				daka.setDid(rs.getInt(4));
				daka.setDate(rs.getString(7));
				daka.setTime(rs.getString(6));
				dakalist.add(daka);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return dakalist;
		 
	 }
}
