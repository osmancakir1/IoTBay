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
             String usernameErr = (String) session.getAttribute("usernameErr");
            String fnameErr = (String) session.getAttribute("fnameErr");
            String lnameErr = (String) session.getAttribute("lnameErr");
        %>
        <h1>Sign Up Form</h1>
        <form method="post" action="welcome.jsp">
            <table>
                <tr><td>First name: </td><td><input type = "text" placeholder="<%=(fnameErr != null ? fnameErr : "Enter first name")%>" name = "firstname" required = "true"></td></tr>
                <tr><td>Last name: </td><td><input type = "text" placeholder="<%=(lnameErr != null ? lnameErr : "Enter last name ")%>" name = "lastname" required = "true"></td></tr>
                <tr><td>Email: </td><td><input type = "email" placeholder="<%=(emailErr != null ? emailErr : "Enter your email")%>" name ="email" required ></td></tr>
                <tr><td>User name: </td><td><input type = "text" placeholder="<%=(usernameErr != null ? usernameErr : "Choose a user name")%>" name = "username" required = "true"></td></tr>
                <tr><td>Password: </td><td><input type = "password" placeholder="<%=(passErr != null ? passErr : "Enter your password")%>" name = "password" required></td></tr>
         
            </table>
            <div>
                <button class="button" href = "main.jsp"> Cancel</button>
                <input class="button" type = "submit" value = "Register">
            </div>
        </form>
</body>
</html>
