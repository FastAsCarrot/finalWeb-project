package controllers;

import dao.entities.Client;
import dao.entities.Role;
import dao.implementations.RoleDaoImpl;

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
@WebServlet(name = "ProfileServlet")
public class ProfileServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();

        Client client;
        client = (Client)session.getAttribute("client");

        if (client != null) {
            request.getRequestDispatcher("Profile.jsp").include(request,response);
        } else {
            request.setAttribute("message", "Sign in first!");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

    }
}
