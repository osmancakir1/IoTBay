<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Logout</title>
    </head>
    <body>
        You have been logged out. Click <a class="button" href="index.jsp">Here</a> to return to the main page
        <% session.invalidate(); %>
    </body>
</html>
