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
 * @author osman
 */
public class RegisterServlet extends HttpServlet {
    

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)   
                        throws ServletException, IOException {
         HttpSession session  = request.getSession();
         Validator validator = new Validator();
         String email = request.getParameter("emaill");
         String password = request.getParameter("password");
         String name = request.getParameter("firstname");
         String username = request.getParameter("username");
         DBManager manager = (DBManager) session.getAttribute("manager");
         validator.clear(session);
         
         if (!validator.validateEmail(email)){
             session.setAttribute("emailErr", "Error: Email format is incorrect");
             request.getRequestDispatcher("resgister.jsp").include(request, response);
         }else if (!validator.validateName(name)){
             session.setAttribute("nameErr", "Error: Name format is incorrect");
             request.getRequestDispatcher("resgister.jsp").include(request, response);
         }else if (!validator.validatePassword(password)){
             session.setAttribute("passErr", "Error: Password format is incorrect");
             request.getRequestDispatcher("resgister.jsp").include(request, response);
         }else {
             try{
                 User exist = manager.findUser(email,password);
                 if(exist != null){
                     session.setAttribute("existErr", "User already exists in the Database");
                     request.getRequestDispatcher("register.jsp").include(request, response);
                 }else{
                     manager.addUser(name, email, password);
                     User user = new User(name, email, password);
                     session.setAttribute("user", user);
                     request.getRequestDispatcher("main.jsp").include(request, response);
                 }
             } catch (SQLException ex){
                 Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
         
         
     }
}
