import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/inventory";
    private static final String USER = "root";  
    private static final String PASSWORD = "Maya@22"; 

    public static Connection getConnection() throws SQLException {
    	 try {
             Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             System.out.println("Connection successful!");
             return connection;
         } catch (SQLException e) {
             System.out.println("Error connecting to the database: " + e.getMessage());
             throw e;
         }
    }
}
