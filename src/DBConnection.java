import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Load properties from file
            Properties props = new Properties();
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");

            // Connect to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Could not read config.properties");
            e.printStackTrace();
        }
        return conn;
    }
}
