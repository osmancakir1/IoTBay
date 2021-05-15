/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

/**
 *
 * @author Lewis
 */
public class ConnServlet extends HttpServlet {
    private DBConnector db;
    private DBManager manager;
    private Connection conn;
    @Override //Create an instance of DBConnector for deployment session
    public void init(){
        try {
            db= new DBConnector();
        } catch (ClassNotFoundException|SQLException ex){
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("connservlet init ok");
        //export the DB manager to the view-session JSPs
    }
    @Override //Add the DBConnector, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException{
       System.out.println("connservlet doGet ok");
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();
       conn = db.openConnection();
       try {
           manager = new DBManager(conn);
       } catch (SQLException ex) {
           Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       //export the DB manager to the view-session (JSPs)
       if(session.getAttribute("manager")==null){
           session.setAttribute("manager", manager);
       }
       response.sendRedirect("main.jsp");
    }
    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
        try {
            System.out.println("Closing connection");
            db.closeConnection();
        }catch(SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConnServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConnServlet at " + request.getContextPath() + "</h1>");
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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