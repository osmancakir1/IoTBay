/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import static java.util.logging.Level.SEVERE;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Device;
import uts.isd.model.dao.DBManager;

/**
 *
 * @author User
 */
@WebServlet(name = "EditDevice", urlPatterns = {"/EditDevice"})
public class EditDevice extends HttpServlet {

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
            out.println("<title>Servlet EditDevice</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditDevice at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        DBManager manager = (DBManager) session.getAttribute("manager");
        
        Device device = null;
        try {
            device = manager.findDevice(name);
            if (device != null) {
                session.setAttribute("device", device);
            } else {
                session.setAttribute("existErr", "Device does not exist in the Database.");
                request.getRequestDispatcher("EditDevice.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditDevice.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("EditDevice.jsp").include(request, response);
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
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        Device device = new Device(name, type, price, quantity);
        DBManager manager = (DBManager) session.getAttribute("manager");
        if (device != null) {
            session.setAttribute("device", device);
            manager.updateDevice(name, type, price, quantity);
            session.setAttribute("updated", "Update was successful");
            request.getRequestDispatcher("EditDevice.jsp").include(request, response);
        } else {
            session.setAttribute("updated", "Update was successful");
            request.getRequestDispatcher("EditDevice.jsp").include(request, response);
        }
        response.sendRedirect("EditDevice.jsp");
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
