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
                <tr><td><label for="email">Email:</label><br></td>
                    <td><input type="text" id="email" name="email"><br></td></tr>
                <tr><td><label for="username">Username:</label><br></td>
                    <td><input type="text" id="username" name="username"><br></td></tr>
                <tr><td><label for="text">Password:</label><br></td>
                    <td><input type="text" id="password" name="name"><br></td></tr>
                <tr><td><input type="submit" value="Submit"></td></tr>
            </table>
        </form>
    </body>
</html>
