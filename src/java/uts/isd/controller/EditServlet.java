package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.DBManager;

public class EditServlet extends HttpServlet {
    
    HttpSession session;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Boolean invalidValues = false;
        session = request.getSession();
        Validator validator = new Validator();
        
        flushInputErrors();
        
        String phone = request.getParameter("phone");
        if (!validator.validatePhone(phone)) {
            session.setAttribute("phoneErr", "You have entered an invalid phone number!");
            invalidValues = true;
        }
        
        String name = request.getParameter("name");
        if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "You have entered an invalid name!");
            invalidValues = true;
        }
        
        String password = request.getParameter("password");
        if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Your password needs to be an alphanumeric of at least four characters!");
            invalidValues = true;
        }
        
        if (invalidValues) {
            request.getRequestDispatcher("edit_user.jsp").include(request, response);
            return;
        } else {
            DBManager manager = (DBManager) session.getAttribute("manager");
            if (manager == null) {
                try {
                    manager = new DBManager((new DBConnector()).openConnection());
                    session.setAttribute("manager", manager);
                } catch (Exception e) {
                    //Unspecified error
                    request.getRequestDispatcher("edit_user.jsp").include(request, response);
                    return;
                }
            }
            String email = request.getParameter("email");
            try {
                manager.updateUser(email, name, password, phone);
                User user = manager.findUser(email, password);
                session.setAttribute("user", user);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } catch (SQLException e) {
                //Database error 
                request.getRequestDispatcher("edit_user.jsp").include(request, response);
                return;
            }
        }
    }
    
    private void flushInputErrors() {
        session.setAttribute("emailErr", null);
        session.setAttribute("phoneErr", null);
        session.setAttribute("nameErr", null);
        session.setAttribute("passErr", null);
    }
}


