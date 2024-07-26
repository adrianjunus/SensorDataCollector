# Running stuff

Attempt to simulate sensor data (dis)continuously streaming to a postgressql database. This represents and edge device running independently from a central datastore and analytics platform.

## Table of Contents
- [Basic Run Steps](#basicrunsteps)

## Basic Run Steps
1. Start up your postgres server (i need to find out how to get version control on the databases)
2. Set up credentals in your local clonced version of main
3. Compile
   ```sh
	javac -cp ".;lib/postgresql-42.7.3.jar" DatabaseInfo.java
4. Run
   ```sh
	java -cp ".;lib/postgresql-42.7.3.jar" file
