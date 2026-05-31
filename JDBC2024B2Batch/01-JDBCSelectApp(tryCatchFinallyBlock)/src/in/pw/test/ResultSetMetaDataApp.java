package in.pw.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetMetaDataApp {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///ioi_24b2_batch?user=root&password=23092004");
			 Statement smt = con.createStatement();
			 ResultSet rst = smt.executeQuery("Select * from Student")){
			
			ResultSetMetaData rstMetaData = rst.getMetaData();
			System.out.println("Column count is: "+rstMetaData.getColumnCount());
			
			for (int i = 1; i <= rstMetaData.getColumnCount(); i++) {
				System.out.print("Column No.: "+i+"\t");
				System.out.print("ColumnName is: "+rstMetaData.getColumnName(i)+"\t");
				System.out.println("ColumnType is: "+rstMetaData.getColumnClassName(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
