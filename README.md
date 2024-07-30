# Sensor Data Collector

Simulate sensor data (dis)continuously streaming from multiple edge devices, to a central cloud-hosted PostgreSql database.

Architecture strategy...
- Containerized edge device deployment
- Version-controlled IaC
- Centralized analytical store using industry-standard data warehousing
- Data Modeling power by dbt 
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
