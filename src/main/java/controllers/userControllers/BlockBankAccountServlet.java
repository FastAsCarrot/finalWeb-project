package controllers.userControllers;

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
        response.setContentType("text/html;charset=UTF-8");

        BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();
        String accountId = request.getParameter("chosenCard");
        System.out.println(accountId);

        if (accountId != null) {
            if (bankAccountDao.blockBankAccountById(Integer.valueOf(accountId))) {
                request.setAttribute("message", "Bank account has been successfully blocked!");
                request.getRequestDispatcher("/userPages/CardOperations.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Can't perform the operation at the moment");
                request.getRequestDispatcher("/userPages/CardOperations.jsp").forward(request, response);
            }

        } else {
            request.setAttribute("message", "Can't retrieve bank account id!");
            request.getRequestDispatcher("/userPages/CardOperations.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
