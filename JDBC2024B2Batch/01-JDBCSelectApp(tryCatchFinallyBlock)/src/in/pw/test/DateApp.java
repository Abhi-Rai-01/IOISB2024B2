package in.pw.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the DOB: (yyyy-mm-dd)");
		String sDate = scanner.next();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(sDate);
			
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			System.out.println(sqlDate);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {			
			scanner.close();
		}
	}
}
