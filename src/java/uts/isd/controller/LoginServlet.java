/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

    public class LoginServlet extends HttpServlet {
        
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {  
        
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        
        String email = request.getParameter("email");
        if (email == null || !validator.validateEmail(email)) {
            session.setAttribute("loginErr", "The email address you have entered is invalid!");
            dispatcher.include(request, response);
            return;
        }
        
        String password = request.getParameter("password");

             
        DBManager manager = (DBManager) session.getAttribute("manager");
        if (manager == null) {
           try {
               manager = new DBManager((new DBConnector()).openConnection());
               session.setAttribute("manager", manager);
           } catch (Exception e) {
               //Unspecified error occurred
               return;
           }

        }
        User user = null;
        try {
            user = manager.findUser(email, password);
        } catch (SQLException ex) {
            // database error
        } catch (Exception e) {
            // some error
        }
        if (user == null) {
            //invalid credentials
            session.setAttribute("loginErr", "User does not exist in the Database!");
            request.getRequestDispatcher("login.jsp").include(request, response);
            return;
        } 
        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("loginErr", null);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        } else {
            session.setAttribute("loginErr", "An unspecified error has occured");
            dispatcher.include(request, response);
        }
    }
}
    

