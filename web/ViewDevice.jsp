<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.Device"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">
        <title>View Device</title>
    </head>
    <body>
        <div>
            <span>IoTBay <a href="main.jsp">Home</a></span>
        </div>
        <br>

        <form action ="ViewDevice" method ="POST">
            
            <%
                ArrayList<Device> devicelist = (ArrayList<Device>) request.getAttribute("devices");
            %>
            <table id="Orderlist">
                <h2>List of orders</h2>
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                <%if (devicelist != null) {
                    for (Device element : devicelist) {%>
                <input type="hidden" value="<%=element.getName()%>" name="ids" />
                <tr>
                    <th><%=element.getName()%></th>
                    <th><%=element.getType()%></th>
                    <th><%=element.getPrice()%></th>
                    <th><%=element.getQuantity()%></th>
                </tr>

                <%}
                }%>

            </table>

        </form>
                <br><br><br>
            <a class="button" href="CreateDevice.jsp">Create</a>
            <a class="button" href="EditDevice.jsp">Edit</a>
            <a class="button" href="DeleteDevice.jsp">Delete</a>
    </body>
</html>