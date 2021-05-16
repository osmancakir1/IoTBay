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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

/**
 *
 * @author OSMAN!
 */
public class ConnServlet extends HttpServlet {
    
    private DBConnector db;
    private Connection conn;
    private DBManager manager;
    
    @Override //Create an instance of DBConnector for deployment session
    public void init(){
        try {
            db = new DBConnector();
        } catch (ClassNotFoundException|SQLException ex){
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
    }
    @Override //Add the DBConnector, DBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       response.setContentType("text/html;charset=UTF-8");
       HttpSession session = request.getSession();
       conn = db.openConnection();
       try {
           manager = new DBManager(conn);
       } catch (SQLException ex) {
           Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       //export the DB manager to the view-session (JSPs)
       session.setAttribute("manager", manager);
     
    }
    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)
    public void destroy() {
        try {
            db.closeConnection();
        }catch(SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
//    
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        request.getRequestDispatcher("welcome.jsp").include(request, response);
//    }
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
    
}
