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
            User user = (User)session.getAttribute("user");
            String name = user.getName();
            String email = user.getEmail();
            String password = user.getPassword();
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
        <h2>Payment Details</h2>
        <button class="button" onclick="paymentDetails()">Click to show/hide Payment Details</button>
        <div id="paymentDetails">
            <form method="post" action="EditServlet">
                <table> 
                    <tr><td>Name on Card:</td><td><input type="text" name="cardName" <!--value="${user.name}"-->></td></tr>
                    <tr><td>Card Number:</td><td><input type="number" name="cardNo" maxlength="16" <!--value="${user.name}"-->></td></tr>
                    <tr><td>CVV:</td><td><input type="number" name="CardCVV" maxlength="3" <!--value="${user.email}"-->></td></tr>
                    <tr><td>Expiry:</td><td><input type="month" name="cardExpiry" <!--value="${user.password}"-->></td></tr>
                    <tr><td><input class="button" type="submit" value="Update"></td></tr> 

                </table>
            </form>
        </div>
        <script>
        function accountDetails() {
          var x = document.getElementById("accountDetails");
          if (x.style.display === "none") {
            x.style.display = "block";
          } else {
            x.style.display = "none";
          }
        }
        </script>
        <script>
        function paymentDetails() {
          var x = document.getElementById("paymentDetails");
          if (x.style.display === "none") {
            x.style.display = "block";
          } else {
            x.style.display = "none";
          }
        }
        </script>
        <%
            user = new User(email, name, password,phone);
            session.setAttribute("user", user);
        %>
    </body>
</html>
