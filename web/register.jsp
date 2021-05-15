<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Registration Page</title>
    </head>
    <body>
        <h1>Sign Up Form</h1>
        <form method="post" action="welcome.jsp">
            <table>
                <tr><td>First name: </td><td><input type = "text" placeholder = "Enter first name: " name = "firstname" required = "true"></td></tr>
                <tr><td>Last name: </td><td><input type = "text" placeholder = "Enter last name: " name = "lastname" required = "true"></td></tr>
                <tr><td>Email: </td><td><input type = "email" placeholder = "Enter your email: " name = "email" required></td></tr>
                <tr><td>User name: </td><td><input type = "text" placeholder = "Choose a user name: " name = "username" required = "true"></td></tr>
                <tr><td>Password: </td><td><input type = "password" placeholder = "Enter your password: " name = "password" required></td></tr>
         
            </table>
            <div>
                <button class="button" href = "main.jsp"> Cancel</button>
                <input class="button" type = "submit" value = "Register">
            </div>
        </form>
</body>
</html>
