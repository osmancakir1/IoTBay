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

    public class LoginServlet extends HttpServlet {
    @Override   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {       
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
             
        DBManager manager = (DBManager) session.getAttribute("manager");
        User user = null;
        
        validator.clear(session);

        if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("login.jsp").include(request, response);
        } else {
            try {
                user = manager.findUser(email, password);
                System.out.println(user != null ? "user  exists" : "no user");
                if (user == null) {
                    session.setAttribute("existErr", "User does not exist in the Database!");
                    request.getRequestDispatcher("login.jsp").include(request, response);
                } else {
                    if (user != null) {
                        session.setAttribute("user", user);
                    }
                    request.getRequestDispatcher("welcome.jsp").include(request, response);
                }
            } catch (SQLException | NullPointerException ex) {
                System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
                session.setAttribute("existErr", "User does not exist in the Database!");
                request.getRequestDispatcher("login.jsp").include(request, response);
             }
         }

}

}
