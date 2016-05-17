package controllers;

import dao.implementations.BankAccountDaoImpl;
import dao.interfaces.BankAccountDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "BlockBankAccountServlet")
public class BlockBankAccountServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();
        String accountId = request.getParameter("chosenCard");
        System.out.println(accountId);

        if (accountId != null) {
            if (bankAccountDao.blockBankAccountById(Integer.valueOf(accountId))) {
                request.getRequestDispatcher("CardOperations.jsp").forward(request, response);
            } else {
                PrintWriter out = response.getWriter();
                out.println("Can't perform the operation");
                out.close();
            }

        } else {
            PrintWriter out = response.getWriter();
            out.println("Couldn't retrieve bank account id");
            out.close();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
