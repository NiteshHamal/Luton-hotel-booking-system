package mylibs;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database2 {
	
	
	public Connection connect() {
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java", "root", "");
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return conn;
		
	}

}
