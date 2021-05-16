<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Registration Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String phoneErr = (String) session.getAttribute("phoneErr");
        %>
        <h1>Sign Up Form</h1>
        <form method="post" action="RegisterServlet">
            <table>
                <tr><td>Email: </td><td><input type = "email" placeholder="<%=(emailErr != null ? emailErr : "Enter your email")%>" name ="email" required ></td></tr>
                <tr><td>Name: </td><td><input type = "text" placeholder="<%=(nameErr != null ? nameErr : "Enter first name")%>" name = "name" required = "true"></td></tr>
                <tr><td>Password: </td><td><input type = "password" placeholder="<%=(passErr != null ? passErr : "Enter your password")%>" name = "password" required = "true"></td></tr>
                <tr><td>Phone: </td><td><input type = "text" placeholder="<%=(phoneErr != null ? phoneErr : "Enter phone number")%>" name = "phone" required = "true"></td></tr>
         
            </table>
            <div>
                <button class="button" href = "main.jsp"> Cancel</button>
                <input class="button" type = "submit" value = "Register">
            </div>
        </form>
</body>
</html>