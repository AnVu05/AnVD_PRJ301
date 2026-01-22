<%-- 
    Document   : search
    Created on : Jan 22, 2026, 9:50:16 AM
    Author     : AN
--%>

<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.University"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            if (user == null) {
                response.sendRedirect("login.jsp");
            }
            String keyword = request.getAttribute("keyword") + "";
            keyword = keyword.equals("null")? "":request.getAttribute("keyword") + "";
        %>
        <!-- From -->
        <form action="MainController" method="Get">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <input type="text" name="keyword" value="<%=keyword%>">
                            <input type="hidden" name="action" value="search">
                        </td>
                        <td>
                            <input type="submit" value="Search">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <!-- Display list University -->
        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Short Name</th>
                    <th>Description</th>
                    <th>Founded Year</th>
                    <th>Address</th>
                    <th>City</th>
                    <th>Region</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    if (request.getAttribute("listUniversity") != null) {
                        ArrayList<University> list = (ArrayList<University>) request.getAttribute("listUniversity");
                        if (!list.isEmpty()) {
                            for (University u : list) {
                %>
                <tr>
                    <td><%=u.getId()%></td>
                    <td><%=u.getName()%></td>
                    <td><%=u.getShortName()%></td>
                    <td><%=u.getDescription()%></td>
                    <td><%=u.getFoundedYear()%></td>
                    <td><%=u.getAddress()%></td>
                    <td><%=u.getCity()%></td>
                    <td><%=u.getRegion()%></td>
                    <td>
                        <%
                            if (u.isDraft()) {
                        %>
                        <input type="button" name="name" value="Edit">
                        <%
                            }
                        %>
                    </td>
                </tr>
                <%
                    }
                } else {
                %>
            <p style="color: red">This University do not exit!</p>
            <%
                    }
                }
            %>
        </tbody>
    </table>
</body>
</html>
