<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Index</title>
    </head>
    <body>
        <%
            if(!(session.getAttribute("user") == null)) {
                User user = (User)session.getAttribute("user");
        %>
         <ul>
            <li><a href="edit_user.jsp">My Account</a></li>
            <li style="float:right"><a href="logout.jsp">Logout</a></li>
        </ul> 
         
        <p> You are logged in as ${user.name} < ${user.email} > </p>
        <% } else { %>
        
        <h1>Welcome to the system</h1>
        <a class="button" href="register.jsp">Sign up</a>
        <!-- <a class="button" href="Login.jsp">Login</a> -->
        <% } %>
    </body>
</html>
