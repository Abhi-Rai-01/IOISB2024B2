package in.pw.test;

import java.util.Date;

public class CheckApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date uDate = new Date();
		System.out.println(uDate);
		
		long time = uDate.getTime();
		java.sql.Date sqlDate = new java.sql.Date(time);
		System.out.println(sqlDate);
	}
}
