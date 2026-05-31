package in.pw.ioi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class TestApp {

	public static void main(String[] args) {
		// step2: Establish the connection
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		Scanner scanner = null;
		
		FileInputStream fis = null;
		
		String url = null;
		String username = null;
		String password = null;
		
		try {
			fis = new FileInputStream("db.properties");
			
			Properties props = new Properties();
			props.load(fis);
			
			url = props.getProperty("url");
			username = props.getProperty("username");
			password = props.getProperty("password");
			
			connection = DriverManager.getConnection(url, username, password);
			// step1: load and register the driver
			System.out.println("JRE: JVM + DB Environment");
			System.out.println("Connection to:" + url);
			
			if(connection != null) {
				// step3: Send the query for execution
				statement = connection.createStatement();
				
				if(statement != null) {
					scanner = new Scanner(System.in);
					System.out.print("Enter the User sid: ");
					int id = scanner.nextInt();
					String sqlSelectQuery = "select sid, sname, sage from student where sid="+id;
					System.out.println(sqlSelectQuery);
					resultSet = statement.executeQuery(sqlSelectQuery);
					
					// step4: Use the data [ResultSet]
					if(resultSet.next()) {
						System.out.println("SID\tSNAME\tSAGE");
						int sid = resultSet.getInt(1);
						String sname = resultSet.getString(2);
						int sage = resultSet.getInt("sage");
						
						System.out.println(sid+"\t"+sname+"\t"+sage);
					}
					else {
						System.out.println("Record not available for the given id: "+id);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// step5: close the resources [LIFO order]
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			scanner.close();
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
	}
}
