package controllers.userControllers;

import dao.entities.BankAccount;
import dao.implementations.BankAccountDaoImpl;
import dao.implementations.BankCardDaoImpl;
import dao.implementations.TransactionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "AddMoneyServlet")
public class AddMoneyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();

        String accountId = request.getParameter("chosenCard");
        if (bankAccountDao.getBankAccountById(Integer.valueOf(accountId)).getisBlocked()!=true) {
            if(bankAccountDao.operationsWithMoney(Integer.valueOf(accountId), 55.0d)) {
                TransactionDaoImpl transactionDao = new TransactionDaoImpl();
                java.util.Date date= new java.util.Date();
                BankCardDaoImpl bankCardDao = new BankCardDaoImpl();
                int cardId = bankCardDao.getBankCardIdByAccountId(Integer.valueOf(accountId));
                transactionDao.makeTransaction(new Timestamp(date.getTime()), 55.0d, cardId);
                request.setAttribute("message", "Operation has been successful!");
                request.getRequestDispatcher("/userPages/CardOperations.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("message", "Cannot perform operation: account is blocked!");
            request.getRequestDispatcher("/userPages/CardOperations.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
