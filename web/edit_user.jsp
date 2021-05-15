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
        <tr><td><input class="button" type="submit" value="Update"></td></tr> 
        <tr><td><a href="main.jsp" class="button">Back</a></td></tr>
        <h2>Account Details</h2>
        <button onclick="accountDetails()">Click to show/hide Account Details</button>
        <div id="accountDetails">
            <form method="post" action="edit_user.jsp">
                <table> 
                    <tr><td>Username:</td><td><input type="text" name="username" value="${user.username}"></td></tr>
                    <tr><td>Email:</td><td><input type="text" name="email" value="${user.email}"></td></tr>
                    <tr><td>Password:</td><td><input type="text" name="password" value="${user.password}"></td></tr>
                </table>
            </form>
        </div>
        <h2>Payment Details</h2>
        <button onclick="paymentDetails()">Click to show/hide Payment Details</button>
        <div id="paymentDetails">

            <form method="post" action="edit_user.jsp">
                <table> 
                    <tr><td>Name on Card:</td><td><input type="text" name="cardName" <!--value="${user.username}"-->></td></tr>
                    <tr><td>Card Number:</td><td><input type="number" name="cardNo" maxlength="16" <!--value="${user.username}"-->></td></tr>
                    <tr><td>CVV:</td><td><input type="number" name="CardCVV" maxlength="3" <!--value="${user.email}"-->></td></tr>
                    <tr><td>Expiry:</td><td><input type="month" name="cardExpiry" <!--value="${user.password}"-->></td></tr>
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
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            user = new User(email,username,password);
            session.setAttribute("user", user);
        %>
    </body>
</html>
