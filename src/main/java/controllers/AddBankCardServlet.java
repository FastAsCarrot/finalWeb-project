package controllers;

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
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Filipp Pisarev.
 */
@WebServlet(name = "AddBankCardServlet")
public class AddBankCardServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            HttpSession session = request.getSession();

            String number = request.getParameter("number").replaceAll(" ","");
            String cvv = request.getParameter("cvv");

            if (number.length() != 16 | cvv.length()!= 3) {
                request.setAttribute("message", "Number of digits in field 'number' or 'cvv' is incorrect!");
                request.getRequestDispatcher("AddingBankCard.jsp").forward(request, response);
            }

            String exp = request.getParameter("exp");

            BankAccountDaoImpl bankAccountDao = new BankAccountDaoImpl();

            try (PrintWriter out = response.getWriter()) {
                int bankAccountId = bankAccountDao.openBankAccount();
                if (bankAccountId!= -1) {
                    session.setAttribute("bankAccountId", bankAccountId);
                    request.setAttribute("message", "Bank account has been successfully created! ");
                    request.getRequestDispatcher("Profile.jsp").forward(request, response);
                } else {
                    request.setAttribute("message", "Attempt to create bank account has failed !");
                    request.getRequestDispatcher("Profile.jsp").forward(request, response);
                }
            }

            int bankAccountId = (int)session.getAttribute("bankAccountId");
            Client client = (Client)session.getAttribute("client");
            int clientId = client.getId();

            BankCardDaoImpl bankCardDao = new BankCardDaoImpl();

            int pin = (int)(Math.random() * 9000)+1000;
            String stringPin = String.valueOf(pin);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Date expires =  new java.sql.Date(sdf.parse(exp).getTime());
            int bankCardId = bankCardDao.addBankCard(new BankCard(
                                    bankAccountId,
                                    clientId,
                                    number,
                                    cvv,
                                    expires,
                                    stringPin
                    ));

            if (bankCardId != -1) {
                session.setAttribute("cardId", bankCardId);
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }  else {

                request.setAttribute("message", "Failed to add a cart!");
                request.getRequestDispatcher("Profile.jsp").forward(request, response);
            }

        } catch (ParseException e) {
            e.printStackTrace();
            request.setAttribute("message", "Failed to add a cart!");
            request.getRequestDispatcher("Profile.jsp").forward(request, response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
