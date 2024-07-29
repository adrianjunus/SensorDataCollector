
# Start PostgreSQL server with elevated privileges
Write-Output "Starting PostgreSQL server with elevated privileges..."
.\scripts\elevated_init_postgresql.ps1 -scriptPath ".\scripts\start_postgresql.ps1"

# Wait for a few seconds to ensure the server starts
Start-Sleep -Seconds 5

# Compile the Java program
Write-Output "Compiling Java program..."
javac -cp "lib/postgresql-42.7.3.jar" DatabaseInfo.java

# Running the Java program
java -cp ".;lib/postgresql-42.7.3.jar" DatabaseInfo

# Stop PostgreSQL server
Write-Output "Stopping PostgreSQL server with elevated privileges..."
.\scripts\elevated_init_postgresql.ps1 -scriptPath ".\scripts\stop_postgresql.ps1"
Write-Output "PostgreSQL server stopped."