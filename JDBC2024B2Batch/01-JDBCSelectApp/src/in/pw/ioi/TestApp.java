package in.pw.ioi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// step1: load and register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("JRE: JVM + DB Environment");
		
		// step2: Establish the connection
		String url = "jdbc:mysql://localhost:3306/ioi_24B2_batch";
		String username = "root";
		String password = "23092004";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		System.out.println("Connection to:" + url);
		
		// step3: Send the query for execution
		Statement statement = connection.createStatement();
		String sqlSelectQuery = "select sid, sname, sage from student";
		ResultSet resultSet = statement.executeQuery(sqlSelectQuery);
		
		System.out.println("SID\tSNAME\tSAGE");
		
		// step4: Use the data [ResultSet]
		while(resultSet.next()) {
			int sid = resultSet.getInt(1);
			String sname = resultSet.getString(2);
			int sage = resultSet.getInt("sage");
			
			System.out.println(sid+"\t"+sname+"\t"+sage);
		}
		
		// step5: close the resources [LIFO order]
		resultSet.close();
		statement.close();
		connection.close();
	}
}
