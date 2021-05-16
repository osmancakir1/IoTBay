<%-- 
    Document   : viewOrder
    Created on : 15/05/2021, 12:30:46 AM
    Author     : Vaio
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="main.jsp">Home</a></span>
        </div>
        <br>
        <form action="ViewOrderHistoryController" method ="GET">
            Order id: <input type="text" name="idSearch" />
            Date: <input type="date" name="dateSearch" />
            <input type="submit" value="seach" />
        </form>
        <%

            ArrayList<Order> orderlist = (ArrayList<Order>) request.getAttribute("orders");

        %>
        <table id="Orderlist">
            <h2>List of orders</h2>
            <tr>
                <th>Order ID</th>
                <th>Customer ID</th>
                <th>Payment ID</th>
                <th>Device ID</th>
                <th>Quantity</th>
                <th>Status</th>
                <th>Invoice ID</th>
                <th>Date</th>
            </tr>
            <%if (orderlist != null) {
                    for (Order element : orderlist) {%>
            <tr>
                <th><%=element.getOrderID()%></th>
                <th><%=element.getCustomerID()%></th>
                <th><%=element.getPaymentID()%></th>
                <th><%=element.getDeviceID()%></th>
                <th><%=element.getCount()%></th>
                <th><%=element.getStatus()%></th>
                <th><%=element.getInvoiceID()%></th>
                <th><%=element.getDate()%></th>
            </tr>

            <%}
                }%>

        </table>

        <br>
        <br>
        <a href="ViewOrderController">Back to order</a>
    </body>
</html>
