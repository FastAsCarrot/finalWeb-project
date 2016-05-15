package controllers;

import connectionPool.ConnectionPool;
import dao.entities.BankCard;
import dao.entities.Client;
import dao.implementations.BankCardDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "ProfileInformationServlet")
public class ProfileInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();
        Client currentUser = (Client)session.getAttribute("client");

        BankCardDaoImpl bankCardDao = new BankCardDaoImpl();
        List<BankCard> cards = bankCardDao.getBankCardsByOwnerId(currentUser.getId());

        session.setAttribute("cards", cards);
        request.getRequestDispatcher("ProfileInformation.jsp").forward(request, response);

    }
}
