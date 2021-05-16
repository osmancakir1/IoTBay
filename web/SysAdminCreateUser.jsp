<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Create User</title>
    </head>
    <body>
        <h1>Create User</h1>
        <form method="post" action="CreateUserServlet">
            <table>
                <tr><td><label for="email">email</label><br></td>
                    <td><input type="name" id="email" name="email"><br></td></tr>
                <tr><td><label for="email">Name:</label><br></td>
                    <td><input type="text" id="name" name="name"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="password" id="password" name="password"><br></td></tr>
                <tr><td><label for="phone">Phone: </label><br></td>
                    <td><input type="text" id="phone" name="phone"><br></td></tr>
                <tr><td><input type="submit" value="Continue"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
></td></tr>
            </table>
       
</body>
</html>