# Bank Management System

Java Swing + MySQL Bank Management System with secure login, account signup, deposit, withdrawal, fast cash, mini statement, balance enquiry, and PIN change features.

## Features

- Multi-step account signup flow
- Login with card number and PIN
- Deposit and withdrawal transactions
- Fast cash shortcuts
- Balance enquiry and mini statement
- PIN change

## Tech Stack

- Java (Swing UI)
- MySQL
- JDBC (MySQL Connector/J)

## Project Structure

- src/bank/management/system: Java source files
- lib: external jar dependencies
- bin: compiled classes

## Required Dependencies

- jcalendar-1.4.jar
- mysql-connector-j-8.4.0.jar

Both jars should be present in the lib folder.

## Database Configuration

Current connection settings are configured in src/bank/management/system/Connn.java:

- Host: 127.0.0.1
- Port: 3306
- Database: banksystem
- Username: root
- Password: samop@12

The app auto-creates required tables if they do not exist.

## Run Instructions

1. Make sure MySQL is running.
2. Ensure database banksystem exists.
3. Compile:

   javac -cp "lib/\*" -d bin src\bank\management\system\*.java

4. Run login screen:

   java -cp "bin;lib/\*" bank.management.system.Login

## Notes

- Change DB credentials in Connn.java if needed.
- Do not commit real production credentials in public repositories.
