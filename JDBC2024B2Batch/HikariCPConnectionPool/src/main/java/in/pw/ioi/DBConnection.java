package in.pw.ioi;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnection {
	
	public static HikariDataSource ds;
	
	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql:///ioi_24b2_batch");
		config.setUsername("root");
		config.setPassword("23092004");
		
		config.setMinimumIdle(5);			//idle connection kept ready
		config.setMaximumPoolSize(10);	    //max connections
		config.setConnectionTimeout(30000);	// wait for a free conn
		
		ds = new HikariDataSource(config);
	}
	
	public static Connection getConnection() throws Exception {
		return ds.getConnection();
	}
}
