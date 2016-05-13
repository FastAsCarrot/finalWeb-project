package controllers;

import dao.entities.Client;
import dao.implementations.ClientDaoImpl;
import dao.interfaces.ClientDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String name = null;
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        ClientDaoImpl clientDao = new ClientDaoImpl();

        try(PrintWriter out = response.getWriter()) {

            name = clientDao.loginValidation(login, password);

            if (name != null ) {
                HttpSession session = request.getSession(false);
                Client client;
                client = clientDao.getClientByLogin(login);
                session.setAttribute("client", client);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                out.print("Your login or password is incorrect !");
                request.getRequestDispatcher("Login.jsp");
            }
        }
    }
}
