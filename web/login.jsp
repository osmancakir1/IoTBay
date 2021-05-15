<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Login Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
        %>
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            <table>
                <tr><td><label for="email">email</label><br></td>
                    <td><input type="text" id="email" name="email"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="text" id="password" name="password"><br></td></tr>
                <tr><td><input type="submit" value="Submit"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
></td></tr>
            </table>
        </form>
    </body>
</html>
