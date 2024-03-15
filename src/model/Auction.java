package model;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;



public class Auction {
	String a_no = "";
	String b_no = "";
	String u_no = "";
	String a_date ="d";
	public Auction(String a_no, String b_no, String u_no, String a_date) {
		this.a_no = a_no;
		this.b_no = b_no;
		this.u_no = u_no;
		this.a_date = a_date;
	}
	public int returnAucNum() {
		return Integer.parseInt(a_no);
	}
	
}
