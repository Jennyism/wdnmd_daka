package bean;

import java.util.ArrayList;
import java.util.List;

public class Daka {
	private int did;
	private User user;
	private String date;
	private String time;
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "{\"did\":" + did + ", \"user\":" + user + ", \"date\":\"" + date + "\", \"time\":\"" + time + "\"}";
	}
	
	
	public static void main(String[] args) {
		List<Daka> list = new ArrayList<Daka>();
		Daka daka = new Daka();
		daka.setTime("1999-0-0");
		list.add(daka);
		list.add(new Daka());
		list.add(new Daka());
		list.add(new Daka());
		System.out.println(list);
	}

}
