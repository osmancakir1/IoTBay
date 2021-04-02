<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
    </head>
        <%
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");   
        %>
    <body> 
            <h1>Welcome, <%=username%>!</h1>
            <h2>Your email is <%=email%></h2>
            <a class="button" href="index.jsp"> Continue </a>
        <%
               User user = new User(email,username,password);
               session.setAttribute("user", user);
        %>
    </body>
</html>
