<%-- 
    Document   : Home
    Created on : Jan 19, 2026, 9:52:41 AM
    Author     : AN
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("userWasLogin");
            if (user != null) {
        %>
        <h2>Xin chao,<%=user.getFullName()%></h2>
        <h3>Chuc nang 1</h3>
        <h3>Chuc nang 2</h3>
        <h3>Chuc nang 3</h3>
        <a href="MainController?action=logout">Log Out</a>
        <br>
        <a href="search.jsp">Search</a>
        <%
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
