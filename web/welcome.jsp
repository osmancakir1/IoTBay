<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Welcome Page</title>
    </head>
        <%
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String password = request.getParameter("password"); 
            String phone = request.getParameter("phone");
        %>
    <body> 
            <h1>Welcome, <%=name%>!</h1>
            <h2>Your email is <%=email%></h2>
            <a class="button" href="main.jsp"> Continue </a>
        <%
               User user = new User(email, name, password, phone);
               session.setAttribute("user", user);
        %>
    </body>
</html>
