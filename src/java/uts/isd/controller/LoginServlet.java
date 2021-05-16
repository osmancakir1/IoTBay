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
import uts.isd.model.Customer;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();//1- retrieve the current session
        Validator validator = new Validator();//2- create an instance of the Validator class
        String email = request.getParameter("email");//3- capture the posted email      
        String password = request.getParameter("password"); //4- capture the posted password    
        DBManager manager = (DBManager) session.getAttribute("manager");
        if (manager != null) {
            System.out.println("manager ok");
        } else {
            DBConnector dbcon = new DBConnector();
            manager = new DBManager(dbcon.openConnection());
        }
        User user = null;
        try {
            System.out.println("Finding User " + email + " " + password);
            user = manager.findUser(email, password);//6- find user by email and password
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (!validator.validateEmail(email)) {
            /*7-   validate email  */
            System.out.println("email error");
            session.setAttribute("emailErr", "Error: Email format incorrect"); //8-set incorrect email error to the session           
            request.getRequestDispatcher("login.jsp").include(request, response);//9- redirect user back to the login.jsp     
        } else if (!validator.validatePassword(password)) {
            System.out.println("password error");
            session.setAttribute("passwordErr", "Error: Password format incorrect");    //11-set incorrect password error to the session           
            request.getRequestDispatcher("login.jsp").include(request, response);   //12- redirect user back to the login.jsp          
        } else if (user != null) {
            session.setAttribute("user", user);
            Customer customer = manager.findCustomer(user.getUserId());
            session.setAttribute("customer", customer);
            //13-save the logged in user object to the session  
            request.getRequestDispatcher("main.jsp").include(request, response);//14- redirect user to the main.jsp     
        } else {
            System.out.println("user not found error");
            session.setAttribute("existErr", "User does not exist in the Database");//15-set user does not exist error to the session           
            response.sendRedirect("login.jsp");//16- redirect user back to the login.jsp       
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
