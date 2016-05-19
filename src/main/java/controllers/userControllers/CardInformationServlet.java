package controllers.userControllers;

import connectionPool.ConnectionPool;
import dao.entities.BankAccount;
import dao.entities.BankCard;
import dao.entities.Client;
import dao.implementations.BankAccountDaoImpl;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "CardInformationServlet")
public class CardInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        Client currentUser = (Client)session.getAttribute("client");

        BankCardDaoImpl bankCardDao = new BankCardDaoImpl();
        List<BankCard> cards = bankCardDao.getBankCardsByOwnerId(currentUser.getId());

        session.setAttribute("cards", cards);

        List<BankAccount> bankAccounts = new ArrayList<>();
        BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();

        for (BankCard bankCard:cards) {
            bankAccounts.add(bankAccountDao.getBankAccountById(bankCard.getBankAccountId()));
        }

        session.setAttribute("bankAccounts", bankAccounts);
        request.getRequestDispatcher("/userPages/CardInformation.jsp").forward(request, response);

    }
}
