package simplilearn.com.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbcon {

	private String url ="jdbc:mysql://localhost:3306/lms_mgmt";
	private String userId = "root";
	private String password = "root";
	private Connection connection;
	
	public dbcon() {
		try {
			//Step 1: Register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Step 2: Get connection
			this.connection =DriverManager.getConnection(url,userId,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}

}
