<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Edit User</title>
    </head>
    <body>
        <%
            User user = (User)session.getAttribute("user");
        %>
        
        <h1>${user.username}'s Account</h1>
        <form method="post" action="edit_user.jsp">
            <table> 
                <tr><td>Username:</td><td><input type="text" name="username" value="${user.username}"></td></tr>
                <tr><td>Email:</td><td><input type="text" name="email" value="${user.email}"></td></tr>
                <tr><td>Password:</td><td><input type="text" name="password" value="${user.password}"></td></tr>
                <tr><td><input class="button" type="submit" value="Update"></td></tr>
                <tr><td><a href="index.jsp" class="button">Back</a></td></tr>
            </table>
        </form>
        <%
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = new User(email,username,password);
            session.setAttribute("user", user);
        %>
    </body>
</html>
