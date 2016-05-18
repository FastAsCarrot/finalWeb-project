package controllers;

import connectionPool.ConnectionPool;
import dao.implementations.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try(PrintWriter out = response.getWriter()) {

            String name = request.getParameter("name");
            String login = request.getParameter("login").toLowerCase();
            String password = request.getParameter("password");

            if(password.length() < 4) {
                request.setAttribute("message", "password is too short!");
                request.getRequestDispatcher("Registration.jsp").forward(request, response);
            }

            ClientDaoImpl clientDao = new ClientDaoImpl();
            if (clientDao.isLoginAlreadyExist(login)){
                request.setAttribute("message", "Login '" + login + "' is already in use !!!");
                request.getRequestDispatcher("Registration.jsp").forward(request, response);
            } else {
                clientDao.addClient(name, login, password);
                request.setAttribute("message", "Account '" + login + "' has successfully created :)");
                request.getRequestDispatcher("Registration.jsp").forward(request, response);
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
