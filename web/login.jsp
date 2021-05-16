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
            String loginErr = (String) session.getAttribute("loginErr");
        %>
        <h1>Login</h1>
        <form method="post" action="LoginServlet">
            <%
                if(loginErr != null) {
            %>
            <td><span style="color:red"><%=loginErr%></span></td>
            <% } %>
            <table>
                <tr>
                    <td><label for="email">Email</label></td>
                    <td><input type="email" name="email" placeholder="JohnSmith@gmail.com" required></td>
                </tr>
                <tr>
                    <td><label for="password">Password</label></td>
                    <td><input type="password" name="password" placeholder="Password" required></td>
                </tr>
                <tr>
                    <td></td>
                    <td><center>
                    <input type="hidden" name="origin"  value="login">
                    <input class="button" type ="submit" value="Login" required>
                </center>
                </td>
                </tr>
            </table>
        </form>
    </body>
</html>
