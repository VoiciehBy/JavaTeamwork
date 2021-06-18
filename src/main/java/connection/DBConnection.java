package connection;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(String DBName) throws SQLException {
        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/" + DBName;
        Properties properties = new Properties();
        properties.setProperty("user", "sql11419677");
        properties.setProperty("password", "");//changePassword

        connection = DriverManager.getConnection(url, properties);
        return connection;
    }

    public static ResultSet getData(String query) throws SQLException {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return resultSet;
    }

    private static void executeSQL(String query) throws SQLException {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null && !statement.isClosed()) statement.close();
        }
    }

    public static void executeDML(String query) throws SQLException {
        executeSQL(query);
    }

    private static void executeDDL(String query) throws SQLException {
        executeSQL(query);
    }

    public static void createDB() throws SQLException {
        executeDDL("CREATE DATABASE IF NOT EXIST DB");
    }

    public static void createTables() throws SQLException {
        executeDDL("CREATE TABLE IF NOT EXISTS credentials(id int auto_increment primary key,"
                + "login varchar(20) not null,"
                + "password varchar(20) not null);");
        executeDDL("CREATE TABLE IF NOT EXISTS employees(id int auto_increment primary key,"
                + "name1 varchar(100) not null,"
                + "name2 varchar(100) not null,"
                + "surname varchar(100) not null,"
                + "birthDate date not null);");
    }
}
