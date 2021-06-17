package servlets;

import connection.DBConnection;
import dbclass.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "DBDataShow", value = "/DBDataShow")
public class DBDataShow extends HttpServlet {
    public static ArrayList<Employee> getDataFromDB() {
        String select = "SELECT * FROM employees;";
        ArrayList<Employee> list = new ArrayList<>();
        try {
            DBConnection.getConnection("sql11419677");
            ResultSet resultSet = DBConnection.getData(select);
            while (resultSet.next()) {
                Employee e = new Employee();
                e.setId(resultSet.getInt("id"));
                e.setFirstName(resultSet.getString("name1"));
                e.setSecondName(resultSet.getString("name2"));
                e.setSurname(resultSet.getString("surname"));
                e.setBirthDate(resultSet.getDate("birthDate"));
            list.add(e);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("DBDataShow.jsp").forward(request,response);
    }
}
