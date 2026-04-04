package bank.management.system;

import java.sql.*;

public class Connn {
    Connection connection;
    Statement statement;

    public Connn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String dbHost = System.getenv().getOrDefault("BANK_DB_HOST", "127.0.0.1");
            String dbPort = System.getenv().getOrDefault("BANK_DB_PORT", "3306");
            String dbName = System.getenv().getOrDefault("BANK_DB_NAME", "banksystem");
            String dbUser = System.getenv().getOrDefault("BANK_DB_USER", "root");
            String dbPassword = System.getenv().getOrDefault("BANK_DB_PASSWORD", "samop@12");

            String jdbcUrl = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName
                + "?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

            connection = DriverManager.getConnection(
                jdbcUrl,
                dbUser,
                dbPassword
            );

            statement = connection.createStatement();
                initializeSchema();
        }catch (Exception e){
            throw new RuntimeException("Database connection failed. Check MySQL server, database name, username/password, and JDBC driver.", e);
        }


    }

            private void initializeSchema() throws SQLException {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS signup ("
                + "formno VARCHAR(30),"
                + "name VARCHAR(100),"
                + "fname VARCHAR(100),"
                + "dob VARCHAR(30),"
                + "gender VARCHAR(20),"
                + "email VARCHAR(100),"
                + "marital VARCHAR(20),"
                + "address VARCHAR(255),"
                + "city VARCHAR(100),"
                + "pincode VARCHAR(20),"
                + "state VARCHAR(100))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS signuptwo ("
                + "formno VARCHAR(30),"
                + "religion VARCHAR(50),"
                + "category VARCHAR(50),"
                + "income VARCHAR(50),"
                + "education VARCHAR(50),"
                + "occupation VARCHAR(50),"
                + "pan VARCHAR(30),"
                + "aadhar VARCHAR(30),"
                + "senior_citizen VARCHAR(10),"
                + "existing_account VARCHAR(10))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS signupthree ("
                + "formno VARCHAR(30),"
                + "account_type VARCHAR(50),"
                + "card_number VARCHAR(30),"
                + "pin VARCHAR(10),"
                + "facility VARCHAR(255))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS login ("
                + "formno VARCHAR(30),"
                + "card_number VARCHAR(30),"
                + "pin VARCHAR(10))");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS bank ("
                + "pin VARCHAR(10),"
                + "date VARCHAR(60),"
                + "type VARCHAR(30),"
                + "amount VARCHAR(30))");
            }
}
