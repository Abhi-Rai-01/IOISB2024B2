package in.pw.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetaDataApp {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql:///ioi_24b2_batch?user=root&password=23092004");){
			DatabaseMetaData dbMetaData = con.getMetaData();
			
			String catalog = null;
			String schemaPattern = null;
			String tableNamePattern = null;
			String types[] = null;
			
			ResultSet resultSet = dbMetaData.getTables(catalog, schemaPattern, tableNamePattern, types);
			
			int count = 0;
			while(resultSet.next()) {
				System.out.println(resultSet.getString(3));
				count++;
			}
			System.out.println("Total no. of Tables: "+count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
