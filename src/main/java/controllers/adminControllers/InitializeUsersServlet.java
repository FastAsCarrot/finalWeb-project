package controllers.adminControllers;

import dao.entities.Client;
import dao.implementations.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "InitializeUsersServlet")
public class InitializeUsersServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        List<Client> clientList;
        ClientDaoImpl clientDao = new ClientDaoImpl();
        clientList = clientDao.getAllClients();

        request.setAttribute("users", clientList);
        request.getRequestDispatcher("/adminPages/ViewAllUsers.jsp").forward(request, response);
    }
}
