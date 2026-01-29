<%-- 
    Document   : Home
    Created on : Jan 19, 2026, 9:52:41 AM
    Author     : AN
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:if test="${not empty userWasLogin}">
        <h2>Xin chao, ${userWasLogin.fullName}</h2>
        <h3>Chuc nang 1</h3>
        <h3>Chuc nang 2</h3>
        <h3>Chuc nang 3</h3>
        <a href="MainController?action=logout">Log Out</a>
        <br>
        <a href="search.jsp">Search</a>
        </c:if>
        <c:if test="${empty userWasLogin}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
    </body>
</html>
