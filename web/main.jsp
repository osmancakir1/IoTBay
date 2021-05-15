<%@page import="uts.isd.model.User"%>
<%@page import="uts.isd.model.Staff"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Index</title>
    </head>
    <body>
        <%
            if(!(session.getAttribute("user") == null)) {
                User user = (User)session.getAttribute("user");
                if(session.getAttribute("usertype").equals("staff")){
                    Staff staff = (Staff)session.getAttribute("staff");
                    %>
                    <p> Staff Login as ${staff.getRole()} ${staff.getFirstname()}
                       <a href="logout.jsp">Logout</a>
                    <%
                        if(staff.getRole().equals("sysadmin")){
                            %><a href="SysAdminCreateUser.jsp">Create user><%
                        }
                    %>
                <%}else{
        %>
        <ul>
            <li><a href="edit_user.jsp">My Account</a></li>
            <li><a href="order_history.jsp">View Order History</a></li>
            <li style="float:right"><a href="logout.jsp">Logout</a></li>
        </ul> 
         
        <p> You are logged in as ${user.getUsername()} < ${user.getEmail()} > </p>
        <%       }
        } else { %>
        
        <h1>Welcome to IOTBay</h1>
        <a class="button" href="register.jsp">Sign up</a>
        <a class="button" href="login.jsp">Login</a>
        <jsp.include page="/ConnServlet" flush ="true"/>
        <% } %>
    </body>
</html>
