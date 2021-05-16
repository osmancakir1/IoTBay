<%-- 
    Document   : editOrder
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
        <form action="EditOrderController" method="POST">
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
                    <td><input type="text" name="paymentId" value="<%=order.getPaymentID()%>" /></td>
                </tr>
                <tr>
                    <td>Device ID: </td>
                    <td><input type="text" name="deviceId" value="<%=order.getDeviceID()%>" /></td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><input type="text" name="quantity" value="<%=order.getCount()%>" /></td>
                </tr>
                <tr>
                    <td>Status: </td>
                    <td><%=order.getStatus()%></td>
                </tr>
                <tr>
                    <td>Invoice ID: </td>
                    <td><input type="text" name="invoiceId" value="<%=order.getInvoiceID()%>" /></td>
                </tr>
                <tr>
                    <td>Date: </td>
                    <td><%=order.getDate()%></td>
                </tr>
                
            </table>
                <button type="submit">Save</button>
                <a href="ViewOrdersController">Back</a>
        </form>
    </body>
</html>
