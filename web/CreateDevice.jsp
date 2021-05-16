<%@page import="uts.isd.model.Device"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>Create Device</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="main.jsp">Home</a></span>
        </div>
        <%
            ArrayList<Device> devices = (ArrayList<Device>) request.getAttribute("devices");
            if (session.getAttribute("name") != null) {
                session.setAttribute("name", null);
        %>
        <h1>OK</h1>
        <%
            }
        %>
        
        <form method="Post" action="CreateDevice">
            <table>
                <tr>
                    <td>Device name: </td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Device Type: </td>
                    <td><input type="text" name="type"></td>
                </tr>
                <tr>
                    <td>Device Price: </td>
                    <td><input type="number" name="price"></td>
                </tr>
                <tr>
                    <td>Device Quantity: </td>
                    <td><input type="number" name="quantity"></td>
                </tr>
                
            </table>
        </form>
        
        
        <br>
        <div>
            <button type="submit">Submit</button>
            <a type="button" href="ViewDevice.jsp">Back</a>
        </div>
    </body>
</html>