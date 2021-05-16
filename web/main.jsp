<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Index</title>
    </head>
    <body>
        <%
            if(!(session.getAttribute("user") == null)) {
                User user = (User)session.getAttribute("user");
        %>
        <ul>
            <li><a href="edit_user.jsp">My Account</a></li>
            <li><a href="order_history.jsp">View Order History</a></li>
            <li style="float:right"><a href="logout.jsp">Logout</a></li>
        </ul> 
         <% if(user.getEmail().equals("sysadmin@iotbay.com")){ 
            %>
        <ul>
            <li><a href="SysAdminCreateUser.jsp">Create User</a></li>
            <li><a href="SysAdminViewUsers.jsp">View All Users</a></li>
            <li><a href="SysAdminUserSearch.jsp">Search for a User</a></li>

        </ul>
        <%
        }%>
        <p style="color: #c29100;"><i> You are logged in as &lt ${user.email} &gt </i></p>
        <% } else { %>
        <h1>Welcome to IOTBay</h1>
        <a class="button" href="register.jsp">Sign up</a>
        <a class="button" href="login.jsp">Login</a>
        <jsp.include page="/ConnServlet" flush ="true"/>
        <% } %>
    </body>
</html>
