package accountsystem;

import connection.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Authorization {
    private static ArrayList<User> getCredentialsFromDB(){
        String select = "SELECT * FROM credentials;";
        ArrayList<User> list = new ArrayList<>();
        ResultSet resultSet = null;
        try {
            DBConnection.getConnection("sql11419677");
            resultSet = DBConnection.getData(select);
            while(resultSet.next()){
                User u = new User();
                u.setId(resultSet.getInt("id"));
                u.setUsername(resultSet.getString("login"));
                u.setPassword(resultSet.getString("password"));
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  list;
    }

    public static boolean isRecognized(String login, String pass) throws SQLException{
        ArrayList<User> list = getCredentialsFromDB();
        for(User user : list)
            if(login.equals(user.getUsername()) && pass.equals(user.getPassword()))
                return true;
            return false;
    }
}
