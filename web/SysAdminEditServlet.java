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

public class SysAdminEditServlet extends HttpServlet {
    
    HttpSession session;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("SysAdminEditServlet called");
        Boolean invalidValues = false;
        session = request.getSession();
        Validator validator = new Validator();        
        String phone = request.getParameter("phone");
        if (!validator.validatePhone(phone)) {
                        System.out.println("PHoneErr");

            session.setAttribute("phoneErr", "You have entered an invalid phone number!");
            invalidValues = true;
        }
        
        String name = request.getParameter("name");
        if (!validator.validateName(name)) {
                        System.out.println("NameErr");

            session.setAttribute("nameErr", "You have entered an invalid name!");
            invalidValues = true;
        }
        
        String password = request.getParameter("password");
        if (!validator.validatePassword(password)) {
            System.out.println("passErr");
            session.setAttribute("passErr", "Your password needs to be an alphanumeric of at least four characters!");
            invalidValues = true;
        }
        
        if (false) {
            System.out.println("Values look bad");
            request.getRequestDispatcher("SysAdminUserEdit.jsp").include(request, response);
            return;
        } else {
            DBManager manager = (DBManager) session.getAttribute("manager");
            if (manager == null) {
                try {
                    manager = new DBManager((new DBConnector()).openConnection());
                    session.setAttribute("manager", manager);
                } catch (Exception e) {
                    //Unspecified error
                    request.getRequestDispatcher("SysAdminUserEdit.jsp").include(request, response);
                    return;
                }
            }
            String email = request.getParameter("email");
            try {
                System.out.println("updating user");
                manager.updateUser(email, name, password, phone);
                request.getRequestDispatcher("main.jsp").forward(request, response);
            } catch (SQLException e) {
                //Database error 
                request.getRequestDispatcher("SysAdminUserEdit.jsp").include(request, response);
                return;
            }
        }
    }
}