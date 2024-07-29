# Run project on Windows

# Start PostgreSQL server
Write-Output "Starting PostgreSQL server..."
net start postgresql-x64-16

# Wait for a few seconds to ensure the server starts
Start-Sleep -Seconds 5

# Compile the Java program
Write-Output "Compiling Java program..."
javac -cp "lib/postgresql-42.7.3.jar" DatabaseInfo.java

# Running the Java program
java -cp ".;lib/postgresql-42.7.3.jar" DatabaseInfo

# Stop PostgreSQL server
Write-Output "Stopping PostgreSQL server..."
net stop postgresql-x64-16
Write-Output "PostgreSQL server stopped."