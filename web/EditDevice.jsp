<%-- 
    Document   : EditDevice
    Created on : 2021/5/16, 下午 09:49:24
    Author     : User
--%>

<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Edit Device</title>
    </head>
    <body onload="startTime()">

        <% 
            Device device = (Device)session.getAttribute("device");
            String updated = (String)session.getAttribute("updated");
        %>
        <div class="panel_div">
            <a class="button" href="MainServlet?name='<%= device.getName()%>'"Main</a>
            <a class="button" href="ViewDevice.jsp" >View</a>
        </div>
        
        <h1>Edit Device Information</h1>
        <form method="post" action="EditDevice">
            <table id="DeviceTable">
                <tr><td>Name:</td><td><input type="text" name="name" value=<% device.getName()>%></td></tr>
                <tr><td>Type:</td><td><input type="text" name="type" value="$device.type"></td></tr>
                <tr><td>Price:</td><td><input type="number" name="price" value="$device.price"></td></tr>
                <tr><td>Quantity:</td><td><input type="number" name="quantity" value="$device.quantity"></td></tr>
                <tr><td></td>
                    <td>
                        <br>
                        <input class="button" type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </form>
        <div>
            <a type="button" href="ViewDevice.jsp">Back</a>
        </div>
    </body>
</html>
