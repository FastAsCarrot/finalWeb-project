package controllers.adminControllers;

import dao.entities.Client;
import dao.implementations.BankAccountDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "UnblockAccountServlet")
public class UnblockAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        int bankAccountId = Integer.valueOf(request.getParameter("bankAccountId"));
        BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();

        if(bankAccountDao.unblockBankAccountById(bankAccountId)) {
            request.setAttribute("message", "Bank account has been successfully unblocked!");
            request.getRequestDispatcher("/adminPages/UnblockAccount.jsp").forward(request,response);
        } else {
            request.setAttribute("message", "Error. Can't unblock account!");
            request.getRequestDispatcher("/adminPages/UnblockAccount.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
