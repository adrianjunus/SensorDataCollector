
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInfo {

    private static final String DB_URL = "jdbc:postgresql://18.117.184.171:5432/postgres";
    private static final String USER = "myprojectuser";
    private static final String PASS = "xxx";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to the database.");

            String query = "SELECT current_database()";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                if (rs.next()) {
                    String dbName = rs.getString(1);
                    System.out.println("Connected to database: " + dbName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
