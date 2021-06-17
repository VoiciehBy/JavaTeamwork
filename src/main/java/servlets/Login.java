package servlets;

import accountsystem.Authorization;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("loginTxt");
        String pass = request.getParameter("passTxt");
        try {
            if (Authorization.isRecognized(username, pass)) {
                request.setAttribute("username", username);
                request.getRequestDispatcher("DBDataShow.jsp").forward(request, response);
            } else {
                request.setAttribute("error", "Niepoprawne dane logowanie!!1");
                request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
