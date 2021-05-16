<%-- 
    Document   : SysAdminViewUsers
    Created on : 16/05/2021, 8:14:48 PM
    Author     : Lewis
--%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Users</title>
    </head>
    <body>
        <h1>All Users</h1>
        <a style="float:right" class="button" href="main.jsp">Back</a>

        <table>
            <tr><th>Email</th><th>Name</th><th>Phone</th>
  </tr>
        <%  DBManager manager = (DBManager) session.getAttribute("dbmanager");
           if(manager ==null){
                manager = new DBManager((new DBConnector()).openConnection());
                session.setAttribute("dbmanager", manager);
           }
           ArrayList<User> users = manager.fetchUsers();
           for(int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                //System.out.println("user "+user.getName()+user.getPassword());
        %>
        <tr><td><%=user.getEmail()%></td><td><%=user.getName()%></td><td><%=user.getPhone()%></td>
        <td><a href="SysAdminUserEdit.jsp?edit=<%=user.getEmail()%>&password=<%=user.getPassword()%>">Edit</a>
        <td><a href="SysAdminDeleteUser.jsp?edit=<%=user.getEmail()%>&password=<%=user.getPassword()%>">Delete</a></tr>
        <%}%>
        </table>
    </body>
</html>
