package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import core.SQLExecutor;

public class Building {
	SQLExecutor executor = new SQLExecutor();
	String b_no = "";
	String b_name ="";
	String b_price = "";
	String b_date = "";
	String b_type = "";
	String b_x = "";
	String b_y = "";
	String ar_no = "";
	String b_count = "";
	public Building(String b_no, String b_name, String b_price, String b_date, String b_type, String b_x, String b_y, String ar_no, String b_count){
		this.b_no = b_no;
		this.b_name = b_name;
		this.b_price = b_price;
		this.b_date = b_date;
		this.b_type = b_type;
		this.b_x = b_x;
		this.b_y = b_y;
		this.ar_no = ar_no;
		this.b_count = b_count;
	}
	public String getBuilidngName() {
		return b_name;
	}
	public String getBuildingPrice() {
		StringBuilder sb = new StringBuilder();
		String units[] = new String[] {"¸¸","¾ï"};
		int money = Integer.parseInt(b_price)/10000;
		int i;
		int count=0;
		int arr[] = new int[50];
		for(i=0;money!=0;i++) {
			arr[i]=money%10;
			money=money/10;
		}
		for(int k=i-1;k>=0;k--) {
			if(k%4==0&&k!=0)count++;
		}
		for(int k=i-1;k>=0;k--) {
			sb.append(arr[k]);
			if(k%4==0) {
				sb.append(units[count]);
				count--;
			}
		}
		return sb.toString();
	}
	public String getAreaName(){
		try {
			String areaname = "";
			executor.Connect();
			ResultSet rs = executor.executeReadQuery("SELECT ar_name FROM auction.area WHERE ar_no="+ar_no);
			while(rs.next()) {
				areaname = rs.getString("ar_name");
			}
			executor.close();
			return areaname;
		}catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
	}
}
