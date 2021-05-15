<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Style.css">
        <title>Registration Page</title>
    </head>
    <body>
        <%if(request.getParameter("CreateUserType")==null){
            %>
        <h1>Create User</h1>
        <form method="post" action="SysAdminCreateUser.jsp">
            <table>
                <tr><td><label for="email">email</label><br></td>
                    <td><input type="text" id="email" name="email"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="password" id="password" name="password"><br></td></tr>
                <tr><td><label for="CreateUserType">User Type::</label>
                        <select name="CreateUserType" id="CreateUserType">
                            <option value="staff">Staff</option>
                            <option value="customer">Customer</option>
                        </select></td><tr>
                <tr><td><input type="submit" value="Continue"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
></td></tr>
            </table>
        </form><%}else if(request.getParameter("CreateUserType").equals("staff")){
        String email = request.getParameter("email");
        String password = request.getParameter("password");%>
        <h1>New Staff</h1>
        <form method="post" action="CreateUserServlet">
            <input type="hidden" id="submitted" name="userType" value="staff">
            <table>
                <tr><td><label for="email">email</label><br></td>
                    <td><input type="text" id="email" name="email"value="<%=email%>"><br></td></tr>
                <tr><td><label for="password">Password:</label><br></td>
                    <td><input type="password" id="password" name="password"value="<%=password%>"><br></td></tr>
                <tr><td><label for="firstname">First Name:</label><br></td>
                    <td><input type="text" id="firstname" name="firstname"><br></td></tr>
                <tr><td><label for="lastname">Last Name:</label><br></td>
                    <td><input type="text" id="lastname" name="lastname"><br></td></tr
                <tr><td><label for="othernames">Other Names:</label><br></td>
                    <td><input type="text" id="othernames" name="othernames"><br></td></tr
                <tr><td><label for="role">Role:</label><br></td>
                    <td><input type="text" id="role" name="role"><br></td></tr
                <tr><td><input type="submit" value="Create"></td></tr>
                <tr><td><a class="button" href="main.jsp">Cancel</a></td></tr>
                
></td></tr>
            </table>
        <%}%>
</body>
</html>
