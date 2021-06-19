package connection;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(String DBName) throws SQLException {
        String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/" + DBName;
        Properties properties = new Properties();
        properties.setProperty("user", "sql11419677");
        properties.setProperty("password", "IzsbGnUa2l");//changePassword

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

    public static void executeDML(String query) throws SQLException {
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
}
