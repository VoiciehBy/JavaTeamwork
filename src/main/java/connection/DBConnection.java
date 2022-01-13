package connection;

import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection(String DBName) throws SQLException {
        String url = "here_goes_connection_url" + DBName;
        Properties properties = new Properties();
        properties.setProperty("user", "here_goes_username");
        properties.setProperty("password", "here_goes_password");

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
