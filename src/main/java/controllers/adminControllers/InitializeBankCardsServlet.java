package controllers.adminControllers;

import dao.entities.BankCard;
import dao.entities.Client;
import dao.implementations.BankCardDaoImpl;
import dao.implementations.ClientDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.smartcardio.Card;
import java.io.IOException;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "InitializeBankCardsServlet")
public class InitializeBankCardsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        List<BankCard> bankCardList;
        BankCardDaoImpl bankCardDao = new BankCardDaoImpl();
        bankCardList = bankCardDao.getAllBankCards();
        request.setAttribute("allCards", bankCardList);
        request.getRequestDispatcher("/adminPages/ViewAllCards.jsp").forward(request, response);
    }
}
