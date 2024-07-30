# Sensor Data Collector

Simulate sensor data (dis)continuously streaming from multiple edge devices, to a central cloud-hosted PostgreSql database.

Architecture strategy...
- Containerized edge device deployment via docker
- Version-controlled IaC via Terraform
- Centralized analytical store using industry-standard data warehousing via Redshift
- Data Modeling via by dbt 
- Live-stream analytics and dashboarding via Tableau

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
