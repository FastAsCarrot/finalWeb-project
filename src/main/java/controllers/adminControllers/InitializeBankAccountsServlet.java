package controllers.adminControllers;

import dao.entities.BankAccount;
import dao.implementations.BankAccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "InitializeBankAccountsServlet")
public class InitializeBankAccountsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        BankAccountDaoImpl bankAccountDaoImp = new BankAccountDaoImpl();
        List<BankAccount> bankAccountList;

        bankAccountList = bankAccountDaoImp.getAllBankAccounts();

        request.setAttribute("bankAccounts", bankAccountList);
        request.getRequestDispatcher("/adminPages/UnblockAccount.jsp").forward(request, response);

    }
}
