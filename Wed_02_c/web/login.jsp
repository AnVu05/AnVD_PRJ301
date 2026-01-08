<%-- 
    Document   : login
    Created on : Jan 8, 2026, 11:08:32 AM
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
        <form action="MainController" method="post">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Username</td>
                        <td>
                            <input type="text" name="username">
                        </td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td>
                            <input type="password" name="password">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="name" value="Submit">
                        </td>
                    </tr>
                </tbody>
            </table>

        </form>
    </body>
</html>
