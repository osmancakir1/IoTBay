<%-- 
    Document   : SysAdminUserSearch
    Created on : 16/05/2021, 9:42:21 PM
    Author     : Lewis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*"%>
<%@page import="uts.isd.model.dao.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import= "java.util.regex.Matcher"%>
<%@page import= "java.util.regex.Pattern"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
             <%@ include file="Style.css"%>
        </style>
        <title>User Search</title>
        
    </head>
    <body>
        <%
            DBManager manager = (DBManager) session.getAttribute("dbmanager");
           if(manager == null){
                manager = new DBManager((new DBConnector()).openConnection());
                session.setAttribute("dbmanager", manager);
           }%>
        <h1>Search for a user</h1>
        <form method="post" action="SysAdminUserSearch.jsp">
            <table>
                <tr>
                <tr><td><label for="searchBy">Search By:</label>
                <select name="searchBy" id="searchBy">
                            <option value="name">Name</option>
                            <option value="phone">Phone</option>
                </select></td></tr>
                <tr><td><label for="search">Search:</label></td>
                    <td><input type="text" id="search" name="search"></td></tr>
                        
                        <input type="hidden" id="searched" name="searched" value="true">
                <tr><td><input type="submit" value="Search"></td></tr>
                
        <% 
            if(request.getParameter("searched")!=null){
                
                boolean foundResult = false;
                String searchTerm = request.getParameter("search");
                Pattern regEx = Pattern.compile(".*"+searchTerm+".*");
                String searchBy = request.getParameter("searchBy");
                ArrayList<User> users = manager.fetchUsers();
                ArrayList<User> matchingUsers = new ArrayList<User>();
                for(int i = 0; i < users.size(); i++) {
                    User user = users.get(i);
                    Matcher match = regEx.matcher(user.getName());
                    if(searchBy.equals("name")){
                        match = regEx.matcher(user.getName());
                    }else{
                        match = regEx.matcher(user.getPhone());
                        System.out.println(user.getPhone()+" "+searchTerm+" "+ match.matches());
                    }
                    if(match.matches()){
                        foundResult=true;
                        matchingUsers.add(user);
                    }
                }
            if(!foundResult){
                %><tr><td>No results found!</td></tr><%
            }else{
                %><table>
                <tr><th>Email</th><th>Name</th><th>Phone</th></tr><%
                for(int i = 0; i < matchingUsers.size(); i++){
                    User user = matchingUsers.get(i);
                    %>
                <tr><td><%=user.getEmail()%></td><td><%=user.getName()%></td><td><%=user.getPhone()%></td>
                    <td><a href="SysAdminUserEdit.jsp?edit=<%=user.getEmail()%>&password=<%=user.getPassword()%>">Edit</a>
                        <td><a href="SysAdminDeleteUser.jsp?edit=<%=user.getEmail()%>&password=<%=user.getPassword()%>">Delete</a>
        <%}
    }
}%>
        </table>
        <a class="button" href="main.jsp">Back</a>

></td></tr>
            </table>
    </body>
</html>
