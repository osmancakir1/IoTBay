/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;
/**
 *
 * @author Lewis
 */
public class CreateUserServlet extends HttpServlet {

   
    

    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   
                        throws ServletException, IOException {       
         HttpSession session = request.getSession();
         DBManager manager = (DBManager) session.getAttribute("manager");
         if (manager == null) {
           try {
               manager = new DBManager((new DBConnector()).openConnection());
               session.setAttribute("manager", manager);
           } catch (Exception e) {
               //Unspecified error occurred
               System.out.println("Exception");
               return;
           }
        }
         Validator validator = new Validator();
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         String name = request.getParameter("name");
         String phone = request.getParameter("phone");
         System.out.println("user: "+email+" "+name+" "+phone);
         try{
             manager.addUser(email, name, password, phone);
         }catch(SQLException ex){
                       Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex); 
         }        
         request.getRequestDispatcher("main.jsp").include(request, response);
    }
}
