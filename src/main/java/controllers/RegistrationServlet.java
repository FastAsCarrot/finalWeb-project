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
            String login = request.getParameter("login");
            String password = request.getParameter("password");

            ClientDaoImpl clientDao = new ClientDaoImpl();
            if (clientDao.registrationCheck(login)){
                clientDao.addClient(name, login, password);
            } else {
                out.print("Login '" + login + "' is already in use !!!");
            }

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
