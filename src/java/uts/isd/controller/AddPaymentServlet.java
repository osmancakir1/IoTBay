package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Payment;
import uts.isd.model.dao.*;

public class AddPaymentServlet extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        String cardNumber = request.getParameter("cardNumber");
        String updated = request.getParameter("updated");
        String cardExpiry = request.getParameter("cardExpiry");
        String cardCVC = request.getParameter("cardCVC");
        
        String origin = request.getParameter("origin");
        try {
            DBManager db = (DBManager) session.getAttribute("manager");
            if(updated.equals("true")) {
                String oldNumber = request.getParameter("oldNumber");
                if(!validator.validateCardNumber(cardNumber)) {
                    session.setAttribute("cardNumberErr", "Error: Card Number format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else if(!validator.validateCardExpiry(cardExpiry)) {
                    session.setAttribute("cardExpiryErr", "Error: Card Expiry format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else if(!validator.validateCardCVC(cardCVC)) {
                    session.setAttribute("cardCVCErr", "Error: Card CVC format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else {
                    try {
                        db.updatePayment(oldNumber, cardNumber, cardExpiry, cardCVC);
                        session.setAttribute("successful", "Successfully updated payment details");
                        session.setAttribute("cardNumberError", cardNumber);
                        session.setAttribute("cardExpiryError", cardExpiry);
                        session.setAttribute("cardCVCError", cardCVC);
                        request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } catch (Exception ex) {
                    session.setAttribute("successful", "Unable to add payment details");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                }
            }
        } else {
            if(!validator.validateCardNumber(cardNumber)) {
                    session.setAttribute("cardNumberErr", "Error: Card Number format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else if(!validator.validateCardExpiry(cardExpiry)) {
                    session.setAttribute("cardExpiryErr", "Error: Card Expiry format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else if(!validator.validateCardCVC(cardCVC)) {
                    session.setAttribute("cardCVCErr", "Error: Card CVC format incorrect");
                    request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                } else {
                    try {
                        db.addPayment(cardNumber, cardExpiry, cardCVC, origin);
                        session.setAttribute("successful", "Successfully updated payment details");
                        request.getRequestDispatcher("paymentDetails.jsp").include(request, response);
                    } catch (Exception e) {
                        session.setAttribute("successful", "Unable to add payment details");
                        request.getRequestDispatcher("paymentDetails.jsp").include(request, response);}
                }
        }
    } catch (Exception ex) {}
}
}
