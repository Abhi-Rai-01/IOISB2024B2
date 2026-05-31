package in.pw.ioi;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args) {
		try(Connection connection = DBConnection.getConnection();
				Statement smt = connection.createStatement();
				ResultSet rst = smt.executeQuery("Select * from student");) {
				
				System.out.println("SID\tSNAME\tSAGE");
				while(rst.next()){
					System.out.println(rst.getInt(1)+"\t"+rst.getString(2)+"\t"+rst.getInt(3));
				}
				
		} catch (SQLException e) {
				e.printStackTrace();
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
}
