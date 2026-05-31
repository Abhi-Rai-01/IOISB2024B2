package in.pw.ioi;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import com.mysql.cj.jdbc.MysqlConnectionPoolDataSource;

public class ConnectionPoolApp {

	public static void main(String[] args) {		
		try(FileInputStream stream = new FileInputStream("db.properties");) {
			Properties props = new Properties();
			props.load(stream);
			
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setUrl(props.getProperty("url"));
			dataSource.setUser(props.getProperty("username"));
			dataSource.setPassword(props.getProperty("password"));
			
			try(Connection connection = dataSource.getConnection();
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
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
