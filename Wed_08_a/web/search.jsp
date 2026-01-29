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
        <c:if test="${empty sessionScope.userWasLogin}">
            <c:redirect url="login.jsp"></c:redirect>
        </c:if>
        <c:if test="${not empty requestScope.mesg}">
            <script>
                alert("${requestScope.mesg}");
            </script>
        </c:if>
        <!-- From -->
        <form action="MainController" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>
                            <input type="text" name="keyword" value="${keyword}">
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
                <c:if test="${not empty requestScope.listUniversity}">
                    <c:forEach items= "${listUniversity}" var="u">
                        <tr>
                            <td>${u.id}</td>
                            <td>${u.name}</td>
                            <td>${u.shortName}</td>
                            <td>${u.description}</td>
                            <td>${u.foundedYear}</td>
                            <td>${u.address}</td>
                            <td>${u.city}</td>
                            <td>${u.region}</td>
                            <td>
                                <c:if test="${u.draft}">
                                    <input type="button" name="name" value="Edit">
                                </c:if>
                                <form action="MainController" method="POST" id="delete" onsubmit="submit(this)">
                                    <input type="hidden" name="action" value="deleteUniversity">
                                    <input type="hidden" name="id" value="${u.id}">
                                    <input type="hidden" name="keyword" value="${keyword}">
                                    <input type="submit" name="name" value="Delete">
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty keyword and empty requestScope.listUniversity}">
                <p style="color: red">This University do not exit!</p>
            </c:if>
        </tbody>
    </table>
    <script>
        const formDelete = document.querySelector("#delete");

        formDelete.addEventListener("submit", function (e) {
            if (!confirm("Do you want to delete?")) {
                e.preventDefault();
            }
        });

    </script>
</body>
</html>
