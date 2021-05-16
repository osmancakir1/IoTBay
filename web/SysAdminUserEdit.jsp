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
        <title>Edit User</title>
    </head>
    <body>
        <%
            DBManager manager = (DBManager) session.getAttribute("dbmanager");
           if(manager == null){
                manager = new DBManager((new DBConnector()).openConnection());
                session.setAttribute("dbmanager", manager);
           }%>
        <%
            if(request.getParameter("edit")!=null&&request.getParameter("password")!=null){
                String email = request.getParameter("edit");
                String password = request.getParameter("password");
                User editUser = manager.findUser(email, password);
        %>
        <h1>Edit User</h1>
        <form method="post" action="SysAdminEditServlet">
            <table>
                <tr><td><label for="email">Email </label><br></td>
                    <td><input type="text" id="email" name="email" value=<%=editUser.getEmail()%> readonly><br></td></tr>
                <tr><td><label for="name">Name: </label><br></td>
                    <td><input type="text" id="name" name="name" value="<%=editUser.getName()%>"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="text" id="password" name="password" value="<%=editUser.getPassword()%>"><br></td></tr>
                <tr><td><label for="phone">Phone: </label><br></td>
                    <td><input type="text" id="phone" name="phone" value="<%=editUser.getPhone()%>"><br></td></tr>
                <tr><td><input type="submit" value="Continue"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
></td></tr>
            </table>
        </form>
        <%}%>
</body>
</html>
