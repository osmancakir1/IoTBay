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
         Validator validator = new Validator();
         String email = request.getParameter("email");
         String password = request.getParameter("password");
         String userType = request.getParameter("userType");
         System.out.println("adding new staff");
         if(userType.equals("staff")){
             String firstname = request.getParameter("firstname");
             String lastname = request.getParameter("lastname");
             String othernames = request.getParameter("othernames");
             String role = request.getParameter("role");
             try{
             manager.addStaff(email, password, firstname, lastname, othernames, role);
             }catch(SQLException ex){
                       Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex); 
                   }
             
         }
     }

}
