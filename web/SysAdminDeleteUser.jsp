<%-- 
    Document   : SysAdminDeleteUser
    Created on : 17/05/2021, 12:19:58 AM
    Author     : Lewis
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Delete User</title>
    </head>
    <body>
        <%
            //System.out.println("Delete user jsp start");
            DBManager manager = (DBManager) session.getAttribute("dbmanager");
           if(manager == null){
                manager = new DBManager((new DBConnector()).openConnection());
                session.setAttribute("dbmanager", manager);
           }%>
        <%
            if(request.getParameter("edit")!=null&&request.getParameter("password")!=null){
                //System.out.println("parameters edit and password check out");
                String email = request.getParameter("edit");
                
                String password = request.getParameter("password");
                User editUser = manager.findUser(email, password);
                //System.out.println("edituser: "+email+" "+password);
        %>
        <h1>This will delete the user <%=editUser.getEmail()%>! Are you sure?</h1>
                <form method="post" action="SysAdminDeleteServlet">
                <input type="hidden" id="email" name="email" value="<%=editUser.getEmail()%>">
                <tr><td><input type="submit" value="Delete"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
                </form>

        <%} %>
    </body>
</html>
