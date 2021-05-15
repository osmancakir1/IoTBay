<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Order History</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        <h1>${user.username}'s Order History</h1>
    </body>
</html>
