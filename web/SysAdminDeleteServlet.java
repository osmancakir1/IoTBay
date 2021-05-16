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

public class SysAdminDeleteServlet extends HttpServlet {
    
    HttpSession session;
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        session = request.getSession();
        DBManager manager = (DBManager) session.getAttribute("manager");
        if (manager == null) {
                try {
                    manager = new DBManager((new DBConnector()).openConnection());
                    session.setAttribute("manager", manager);
                } catch (Exception e) {
                    //Unspecified error
                    request.getRequestDispatcher("SysAdminDeleteUser.jsp").include(request, response);
                    return;
                }
        }
        String email = "";
                if(request.getParameter("email")!=null){
                    email=request.getParameter("email");
                }else{
                    System.out.println("no email parameter");
                }
        try {
            manager.deleteUser(email);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }catch (SQLException e) {
                //Database error 
            request.getRequestDispatcher("SysAdminDeleteUser.jsp").include(request, response);
            return;
        }
    }
}