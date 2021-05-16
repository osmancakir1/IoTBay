<%-- 
    Document   : DeleteDevice
    Created on : 2021/5/16, 下午 09:49:58
    Author     : User
--%>

<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Delete Device</title>
    </head>
     <%
        Device device = (Device) request.getAttribute("device");
    %>
    <body>
        <h1>Do you want to delete this device ?</h1>
        <form action="DeleteDevice" method="POST">
            <table>
                <input type="hidden" name="orderId" value="<%=device.getName()%>"
                       <tr>
                    <td>Device Name: </td>
                    <td><%=device.getName()%></td>
                </tr>
                <tr>
                    <td>Device Type: </td>
                    <td><%=device.getType()%></td>
                </tr>
                <tr>
                    <td>Price: </td>
                    <td><%=device.getPrice()%></td>
                </tr>
                <tr>
                    <td>Quantity: </td>
                    <td><%=device.getQuantity()%></td>
                </tr>
                

            </table>
            <button type="submit">Yes</button>
            <a href="ViewDevice.jsp">No</a>
        </form>
        
       
    </body>
</html>
