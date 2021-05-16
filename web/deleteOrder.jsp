<%-- 
    Document   : deleteOrder
    Created on : May 16, 2021, 1:26:26 AM
    Author     : mapso
--%>

<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        Order order = (Order) request.getAttribute("order");
    %>
    <body>
        <h1>Do you want to delete this order ?</h1>
        <form action="DeleteOrderController" method="POST">
            <table>
                <input type="hidden" name="orderId" value="<%=order.getOrderID()%>"
                       <tr>
                    <td>Order ID: </td>
                    <td><%=order.getOrderID()%></td>
                </tr>
                <tr>
                    <td>Customer ID: </td>
                    <td><%=order.getCustomerID()%></td>
                </tr>
                <tr>
                    <td>Payment ID: </td>
                    <td><%=order.getPaymentID()%></td>
                </tr>
                <tr>
                    <td>Device ID: </td>
                    <td><%=order.getDeviceID()%></td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><%=order.getCount()%></td>
                </tr>
                <tr>
                    <td>Status: </td>
                    <td><%=order.getStatus()%></td>
                </tr>
                <tr>
                    <td>Invoice ID: </td>
                    <td><%=order.getInvoiceID()%></td>
                </tr>
                <tr>
                    <td>Date: </td>
                    <td><%=order.getDate()%></td>
                </tr>

            </table>
            <button type="submit">Yes</button>
            <a href="ViewOrdersController">No</a>
        </form>
    </body>
</html>
