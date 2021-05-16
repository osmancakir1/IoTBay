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
        <h1>Sign Up Form</h1>
        <form method="post" action="RegisterServlet">
            <table>
                <tr>
                    <td><label for="email">Email:</label></td>
                    <td><input type="text" name="email" placeholder="email@email.com" required>
                        <%
                            if (session.getAttribute("emailErr") != null) {
                        %>
                        <div><span><%=session.getAttribute("emailErr")%></span></div>

                        <% }
                        %></td>
                </tr>
                <tr>
                    <td><label for="name">Full Name:</label></td>
                    <td><input type="text" name="name" placeholder="John Smith" required>
                        <%
                            if (session.getAttribute("nameErr") != null) {
                        %>
                        <div><span><%=session.getAttribute("nameErr")%></span></div>

                        <% }
                        %></td>
                </tr>
                <tr>
                    <td><label for="password">Password:</label></td>
                    <td><input type="text" name="password" placeholder="password" required>
                        <%
                            if (session.getAttribute("passErr") != null) {
                        %>
                        <div><span><%=session.getAttribute("passErr")%></span></div>

                        <% }
                        %></td>
                </tr>
                <tr>
                    <td><label for="phone">Phone No:</label></td>
                    <td><input type="text" name="phone" placeholder="1234 567 890" required>
                        <%
                            if (session.getAttribute("phoneErr") != null) {
                        %>
                        <div><span><%=session.getAttribute("phoneErr")%></span></div>

                        <% }
                        %></td>
                </tr>
                <tr>
                    <td></td>
                    <td><center>
                    <button class="button" href = "main.jsp"> Cancel</button>
                    <input class="button" type = "submit" value = "Register">
                </center>
                </td>
                </tr>
            </table>
            <div>

            </div>
        </form>
</body>
</html>