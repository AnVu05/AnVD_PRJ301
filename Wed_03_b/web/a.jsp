<%-- 
    Document   : a
    Created on : Jan 8, 2026, 11:19:50 AM
    Author     : AN
--%>

<%@page import="model.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String fullname = (String)request.getAttribute("fullname");
        %>
        <h1>Welcome, <%=fullname%></h1>
        <h3>Bang chuc nang</h3><br/>
        <h1>Chuc nang 1</h1><br/>
        <h1>Chuc nang 2</h1><br/>
        <h1>Chuc nang 3</h1><br/>
    </body>
</html>
