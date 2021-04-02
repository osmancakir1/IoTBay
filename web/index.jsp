<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <%
            if(!(session.getAttribute("user") == null)) {
                User user = (User)session.getAttribute("user");
        %>
        <p> You are logged in as ${user.username} < ${user.email} > </p>
        <a class="button" href="edit_user.jsp">My Account</a>
        <a class="button" href="logout.jsp">Logout</a>

        <% } else { %>
        
        <h1>Welcome to the system</h1>
        <a class="button" href="register.jsp">Sign up</a>
        <!-- <a class="button" href="Login.jsp">Login</a> -->
        <% } %>
    </body>
</html>
