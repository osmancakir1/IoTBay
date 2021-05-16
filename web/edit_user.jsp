<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>Edit User</title>
    </head>
    <body>
        <%
            String name = "";
            String email = "";
            String password = "";
            
            User user = (User)session.getAttribute("user");
            name = user.getName();
            email = user.getEmail();
            password = user.getPassword();
            String phone = user.getPhone();
        %>
        
        <h1>${user.getName()}'s Account</h1>
        <tr><td><a href="main.jsp" class="button">Back</a></td></tr>
        <h2>Account Details</h2>
        <button class="button" onclick="accountDetails()">Click to show/hide Account Details</button>
        <div id="accountDetails">
            <form method="post" action="EditServlet">
                <table> 
                    <tr>
                        <td><label for="name">Full name</label></td>
                        <td><input type="text" name="name" placeholder="John Smith" required value="<%=name%>">
                            <% 
                                if (session.getAttribute("nameErr") != null) {
                            %>
                            <div><span><%=session.getAttribute("nameErr")%></span></div>
                            <% } %>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="password">Password</label></td>
                        <td><input type="text" name="password" placeholder="password" required value="<%=password%>">
                            <% 
                                if (session.getAttribute("passErr") != null) {
                            %>
                            <div><span><%=session.getAttribute("passErr")%></span></div>
                            <% } %>
                    </tr>
                    <tr>
                        <td><label for="phone">Phone Number</label></td>
                        <td><input type="text" name="phone" placeholder="1234 567 890" required value="<%=phone%>">
                            <% 
                                if (session.getAttribute("phoneErr") != null) {
                            %>
                            <div><span><%=session.getAttribute("phoneErr")%></span></div>
                            <% } %>
                    </tr>
                    <tr>
                        <td></td>
                        <td><center>
                        <input class="button" type ="submit" value="Update" required>
                        </center>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <%
            user = new User(email, name, password,phone);
            session.setAttribute("user", user);
        %>
    </body>
</html>
