package servlets;

import connection.DBConnection;
import dbclass.EmployeeDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

@WebServlet(name = "deleteEmployee", value = "/deleteEmployee")
public class DeleteEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idTxt"));
        String name = request.getParameter("nameTxt");
        String name2 = request.getParameter("name2Txt");
        String surname = request.getParameter("surnameTxt");
        String birthDate = request.getParameter("birthDateTxt");

        int yyyy = Integer.parseInt(birthDate.substring(0,4));
        int mm = Integer.parseInt(birthDate.substring(5,7));
        int dd = Integer.parseInt(birthDate.substring(8,10));
        Date bD = Date.valueOf(LocalDate.of(yyyy,mm,dd));
        try {
            DBConnection.getConnection("sql11419677");
            EmployeeDAO.deleteEmployee(id,name,name2,surname,bD.toString());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("DBDataShow.jsp").forward(request, response);
    }
}
