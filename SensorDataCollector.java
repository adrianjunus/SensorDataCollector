
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.UUID;

public class SensorDataCollector {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "xxx";

    public static void main(String[] args) {
        Random random = new Random();
        int maxIterations = 50; // Limit the number of iterations for testing
        int count = 0;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            // Create the telemetry_data table if it doesn't exist
            String createTableQuery = "CREATE TABLE IF NOT EXISTS telemetry_data (" +
                                      "id SERIAL PRIMARY KEY, " +
                                      "sensor_id VARCHAR(50), " +
                                      "temperature DOUBLE PRECISION, " +
                                      "pressure DOUBLE PRECISION, " +
                                      "humidity DOUBLE PRECISION, " +
                                      "timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";

            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableQuery);
                System.out.println("Table 'telemetry_data' created or already exists.");
            }

            String insertQuery = "INSERT INTO telemetry_data (sensor_id, temperature, pressure, humidity, timestamp) VALUES (?, ?, ?, ?, CURRENT_TIMESTAMP)";

            while (count < maxIterations) {
                try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
                    String sensorId = UUID.randomUUID().toString();
                    double temperature = -20.0 + (50.0 - (-20.0)) * random.nextDouble();
                    double pressure = 980.0 + (1050.0 - 980.0) * random.nextDouble();
                    double humidity = 10.0 + (90.0 - 10.0) * random.nextDouble();

                    pstmt.setString(1, sensorId);
                    pstmt.setDouble(2, temperature);
                    pstmt.setDouble(3, pressure);
                    pstmt.setDouble(4, humidity);

                    pstmt.executeUpdate();
                    System.out.println("Inserted data: " + sensorId + ", " + temperature + ", " + pressure + ", " + humidity);
                }
                count++;
                Thread.sleep(500); // Collect data every half second
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
