package restaurant;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	    // Method to get database connection
	    public static Connection getConnection() throws Exception {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	    
	        // Database connection details
	        return DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/restaurant_db",
	                "root",
	                "cd177257"
	        );
	    }
	}

