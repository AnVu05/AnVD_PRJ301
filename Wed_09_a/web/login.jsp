<%-- 
    Document   : login
    Created on : Jan 19, 2026, 9:38:25 AM
    Author     : AN
--%>

<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController?action=login" method="post">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <input type="text" name="username" placeholder="username" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="password" name="password" placeholder="password" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="name" value="Login">
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <c:if test = "${not empty requestScope.error}">
                                <p style="color: red">
                                    ${error}
                                </p>
                            </c:if>
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
