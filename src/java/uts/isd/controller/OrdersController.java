/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Customer;
import uts.isd.model.IotDevices;
import uts.isd.model.Order;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author mapso
 */
public class OrdersController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response, Exception e)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet OrdersController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet OrdersController at " + e.getMessage() + " </h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private DBConnector db;
    private DBManager manager;
    private Connection conn;

    @Override //Create an instance of DBConnector for deployment session
    public void init() {
        try {
            db = new DBConnector();
            manager = new DBManager(db.openConnection());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("connservlet init ok");
        //export the DB manager to the view-session JSPs
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
        // Load iot device to front end
        try {
            ArrayList<IotDevices> devices = manager.listAllDevices();
            request.setAttribute("devices", devices);
            request.getRequestDispatcher("createOrder.jsp").forward(request, response);
        } catch (Exception e) {

            processRequest(request, response, e);
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
//        
        //1- retrieve the current session
        try {
            HttpSession session = request.getSession();
            String deviceIdInput = request.getParameter("deviceId");
            if (!Validator.validateInteger(deviceIdInput, 0, Integer.MAX_VALUE)) {
                response.sendRedirect("OrdersController");
            }

            int deviceId = Integer.parseInt(deviceIdInput);
            String invoiceIdInput = request.getParameter("invoiceId");
            if (!Validator.validateInteger(invoiceIdInput, 0, Integer.MAX_VALUE)) {
                response.sendRedirect("OrdersController");
            }
            int invoiceId = Integer.parseInt(invoiceIdInput);
            String countInput = request.getParameter("count");
            if (!Validator.validateInteger(countInput, 0, Integer.MAX_VALUE)) {
                response.sendRedirect("OrdersController");
            }
            int count = Integer.parseInt(countInput);

//        OrderLineManager orderlinemanager = (OrderLineManager)session.getAttribute("orderlinemanager");
//        OrderManager manager = (OrderManager) session.getAttribute("ordermanager");
//        DeviceManager devicemanager = (DeviceManager) session.getAttribute("devicemanager");
            Customer customerObj = (Customer) session.getAttribute("customer");
            if (customerObj != null) {
                // create order with customer
                System.out.println(LocalDateTime.now().getYear());
                
                Order order = new Order(customerObj.getCustomerId(), 1, deviceId, "Saved", count, invoiceId, java.sql.Date.valueOf(LocalDate.now()));
//                        new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth()));
                manager.addOrder(order);
            } else {

                // create oder with annonymous customer
            }

            session.setAttribute("success", "success");
            response.sendRedirect("OrdersController");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            processRequest(request, response, e);
        }

        // retrieving anonymous user
//        int customerid = customerObj.getCustomerId();
//        int customerid = Integer.parseInt(request.getParameter("customerid"));
        // retrieving anonymous payment
//        int paymentid = Integer.parseInt(session.getAttribute("randompaymentid").toString());
//       
//        //int paymentid = Integer.parseInt(request.getParameter("paymentid"));
//        
//        
//        int deviceid = Integer.parseInt(request.getParameter("deviceid"));
//        
//        
//        int invoiceid = Integer.parseInt(request.getParameter("invoiceid"));
//        String date = session.getAttribute("date").toString();
//        int count = Integer.parseInt(request.getParameter("count"));
//        //validator.clear(session);
//        //5- retrieve the manager instance from session
//       
//        PrintWriter ps = response.getWriter();
        //ps.print(customerid);
        //try {
        //devicemanager.updateDeviceCount(deviceid,count);
        //manager.createOrder(customerid, paymentid, deviceid, invoiceid, date);
        //orderlinemanager.addOrderline(deviceid,count);
        //} catch (SQLException ex) {
        //Logger.getLogger(OrderController.class.getName()).log(Level.SEVERE, null, ex);
        //}
        //request.getRequestDispatcher("CreateOrder.jsp").include(request, response);
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
