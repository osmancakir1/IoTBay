/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.Customer;
import uts.isd.model.Order;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author soleane
 */
public class EditOrderController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditOrderController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditOrderController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Customer customer = (Customer) request.getSession().getAttribute("customer");
            DBConnector db = new DBConnector();
            DBManager manager = new DBManager(db.openConnection());
            String orderIdInput = request.getParameter("orderId");
            if (!Validator.validateInteger(orderIdInput, 1, Integer.MAX_VALUE)) {
                throw new Exception("Invalid input");
            }
            int orderId = Integer.parseInt(orderIdInput);
            Order order = manager.getOrderById(orderId, customer.getCustomerId());
            if (order == null) {
                response.sendRedirect("ViewOrdersController");
            }
            request.setAttribute("order", order);
            request.getRequestDispatcher("editOrder.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            int deviceId = Integer.parseInt(request.getParameter("paymentId"));
            int paymentId = Integer.parseInt(request.getParameter("paymentId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int invoiceId = Integer.parseInt(request.getParameter("invoiceId"));
            Order order = new Order();
            order.setOrderID(orderId);
            order.setDeviceID(deviceId);
            order.setPaymentID(paymentId);
            order.setInvoiceID(invoiceId);
            order.setCount(quantity);
            DBConnector con = new DBConnector();
            DBManager manager = new DBManager(con.openConnection());
            manager.updateOrderEdit(order);
            response.sendRedirect("ViewOrdersController");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
