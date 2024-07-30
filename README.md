# Sensor Data Collector

Simulate edge IoT sensor data (dis)continuously streaming to a PostgreSql database.

To feature...
- Centralized analytical store using industry-standard data warehouse management 
- Containerized edge device deployment
- Version-controlled IaC
- Live-stream analytics and dashboarding

## Table of Contents
- [Basic Run Steps](#basicrunsteps)

## Basic Run Steps
1. Ensure PostgreSQL is installed. Eventually this will be a cloud hosted database.
2. Execute Powershell...
   ```powershell
   .\run_SensorDataCollector.ps1
   ```
   ...or Shell
   ```sh
   .\run_SensorDataCollector.sh
   ```
