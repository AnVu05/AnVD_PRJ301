<%-- 
    Document   : RE403
    Created on : Jan 19, 2026, 11:23:05 AM
    Author     : AN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String error = request.getAttribute("error")+"";
        %>
        <h1 style="color: red"><%=error%></h1>
    </body>
</html>
