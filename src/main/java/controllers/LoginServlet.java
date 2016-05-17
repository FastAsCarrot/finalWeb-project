package controllers;

import dao.entities.Client;
import dao.entities.Role;
import dao.implementations.ClientDaoImpl;
import dao.implementations.RoleDaoImpl;
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
        String login = request.getParameter("login").toLowerCase();
        String password = request.getParameter("password");

        ClientDaoImpl clientDao = new ClientDaoImpl();

        try(PrintWriter out = response.getWriter()) {

            name = clientDao.loginValidation(login, password);

            if (name != null ) {
                HttpSession session = request.getSession(false);

                Client client;
                client = clientDao.getClientByLogin(login);

                Role role;
                RoleDaoImpl roleDao = new RoleDaoImpl();

                role = roleDao.getRoleById(client.getRoleId());
                session.setAttribute("client", client);
                session.setAttribute("role", role);
                request.setAttribute("message", "You've successfully signed in!");
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                request.setAttribute("message", "Your login or password is incorrect !");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
        }
    }
}
