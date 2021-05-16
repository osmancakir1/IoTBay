<%@page import="uts.isd.model.Payment"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Details</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            String cardEmail = (String) session.getAttribute("userEmail");
            String cardNumberErr = (String) session.getAttribute("cardNumberErr");
            String cardExpiryErr = (String) session.getAttribute("cardExpiryErr");
            String cardCVCErr = (String) session.getAttribute("cardCVCErr");
            String successful = (String) session.getAttribute("successful");
            String updated = (String) session.getAttribute("updated");
        %>
        <h2>Add Payment Details</h2>
        <div id="paymentDetails">
            <form method="post" action="main.jsp">
                <%
                    if(successful != null) {
                %>
                <h4><%=successful%></h4>
                <% } %>
                <table> 
                    <tr>
                        <td><label for="cardNumber">Card Number:</label></td>
                        <td><input type="text" name="cardNo" placeholder="<%=(cardNumberErr != null ? cardNumberErr : "1234567890987654")%>" required></td>
                    </tr>
                    <tr>
                        <td><label for="cardExpiry">Card Expiry:</label></td>
                        <td><input type="text" name="cardExpiry" placeholder="<%=(cardExpiryErr != null ? cardExpiryErr : "12/21")%>" required></td>
                    </tr>
                    <tr>
                        <td><label for="cardCVC">Card CVC:</label></td>
                        <td><input type="text" name="cardCVC" placeholder="<%=(cardCVCErr != null ? cardCVCErr : "111")%>" required></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                    <center>
                        <input type="hidden" name="isUpdate" value="false">
                        <input type="hidden" name="oldPayment" value="null">
                        <input type="hidden" name="tempPayment" value="yes">
                        <input type="hidden" name="origin" value="<%=cardEmail%>">
                        <input class="button" type="submit" value="Add" required>
                    </center>
                    </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
