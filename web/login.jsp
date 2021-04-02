<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="post" action="welcome.jsp">
            <table>
                <tr><td><label for="name">Username:</label><br></td>
                    <td><input type="text" id="name" name="name"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="text" id="password" name="name"><br></td></tr>
                <tr><td><input type="submit" value="Submit"></td></tr>
            </table>
        </form>
    </body>
</html>
