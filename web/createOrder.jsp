<%@page import="uts.isd.model.IotDevices"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create order</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="main.jsp">Home</a></span>
        </div>
        <%
            ArrayList<IotDevices> devices = (ArrayList<IotDevices>) request.getAttribute("devices");
            if (session.getAttribute("success") != null) {

                session.setAttribute("success", null);
        %>
        <h1>OK</h1>
        <%
            }
        %>
        <br>
        <h2>Iot device list</h2>

        <table>
            <tr>
                <th>Device ID</th>
                <th>Name</th>
                <th>Number in stock</th>
            </tr>
            <%
                for (int i = 0; i < devices.size(); i++) {
            %>
            <tr>
                <td><%= devices.get(i).getDeviceId()%></td>
                <td><%= devices.get(i).getDeviceName()%></td>
                <td><%= devices.get(i).getNumberInStock()%></td>
            </tr>
            <%
                }
            %>
        </table>

        <h2>Order</h2>
        <form action="OrdersController" method="POST">
            <table>
                <tr>
                    <td>DeviceID:</td>
                    <td><input type="number" name="deviceId"></td>
                </tr>
                <tr>
                    <td>InvoiceID:</td>
                    <td><input type="number" name="invoiceId"></td>
                </tr>
                <tr>
                    <td>Count: </td>
                    <td><input type="number" name="count"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"></td>
                </tr>
            </table>
        </form>
        <br>
        <div>
            <span><a href="ViewOrderController">ViewOrder</a></span>
        </div>
    </body>
</html>
