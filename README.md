# Sensor Data Collector

Attempt to simulate sensor data (dis)continuously streaming to a PostgreSql database. This represents an edge device running independently from a central datastore and analytics platform.

## Table of Contents
- [Basic Run Steps](#basicrunsteps)

## Basic Run Steps
1. Ensure PostgreSQL is installed. Eventually this will be a cloud hosted database.
2. Execute Powershell... Must run from administrator mode. Eventually will have init script running only particular scripts with elevated priveleges 
   ```powershell
   .\run.ps1
   ```
   ...or Shell
   ```sh
   .\run.sh
   ```
