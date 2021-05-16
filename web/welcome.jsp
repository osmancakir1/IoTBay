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
            User user = (User) session.getAttribute("user");
        %>
    <body> 
            <h1>Welcome, ${user.name}!</h1>
            <h2>Your email is ${user.email}></h2>
            <a class="button" href="main.jsp"> Continue </a>
    </body>
</html>
