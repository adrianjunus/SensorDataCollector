import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.UUID;

public class SensorDataCollector {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASS = "password123";

    public static void main(String[] args) {
        Random random = new Random();

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String insertQuery = "INSERT INTO telemetry_data (sensor_id, temperature, pressure, humidity) VALUES (?, ?, ?, ?)";

            while (true) {
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

                Thread.sleep(5000); // Collect data every 5 seconds
            }
        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
