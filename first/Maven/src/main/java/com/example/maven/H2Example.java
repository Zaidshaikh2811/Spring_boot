import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class H2Example {
    public static void main(String[] args) {
        // JDBC URL for an in-memory H2 database
        String jdbcURL = "jdbc:h2:mem:testdb";  // In-memory DB
        // For file-based: jdbc:h2:./data/testdb

        String username = "sa";  // default
        String password = "";    // default

        try {
            // Load H2 driver (optional in modern JDBC)
            Class.forName("org.h2.Driver");

            // Connect
            Connection connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to H2 database!");

            // Create a table
            Statement stmt = connection.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT PRIMARY KEY, name VARCHAR(255))");

            // Insert a row
            stmt.execute("INSERT INTO users VALUES (1, 'Zaid')");

            // Query the table
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
            }

            // Close resources
            rs.close();
            stmt.close();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
