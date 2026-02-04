<%-- 
    Document   : university-from
    Created on : Feb 2, 2026, 10:58:02 AM
    Author     : AN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="MainController" method="Post">
            <table>
                <tbody>
                    <tr>
                        <td>ID:</td>
                        <td>
                            <input type="text" name="id" value="${u.id}" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>Name:</td>
                        <td>
                            <input type="text" name="name" value="${u.name}" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>Short Name:</td>
                        <td>
                            <input type="text" name="shortname" value="${u.shortName}">
                        </td>
                    </tr>
                    <tr>
                        <td>Description:</td>
                        <td>
                            <input type="text" name="description" value="${u.description}">
                        </td>
                    </tr>
                    <tr>
                        <td>FoundedYear:</td>
                        <td>
                            <input type="number" step="1" min="0" name="foundedYear" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td>
                            <input type="text" name="address" value="${u.address}" required="">
                        </td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td>
                            <input type="text" name="city" value="${u.city}">
                        </td>
                    </tr>
                    <tr>
                        <td>Region:</td>
                        <td>
                            <input type="text" name="region" value="${u.region}">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td>
                            <select id="id" name="type">
                                <option value="Đại học Quốc gia">Đại học Quốc gia</option>
                                <option value="Đại học Công lập">Đại học Công lập</option>
                                <option value="Đại học Tư thục">Đại học Tư thục</option>
                            </select>

                        </td>
                    </tr>
                    <tr>
                        <td>Total Students:</td>
                        <td>
                            <input type="number" name="totalStudents" value="${u.totalStudents}">
                        </td>
                    </tr>
                    <tr>
                        <td>Total Faculties:</td>
                        <td>
                            <input type="number" name="totalFaculties" value="${u.totalFaculties}">
                        </td>
                    </tr>
                    <tr>
                        <td>Draft</td>
                        <td>
                            <input type="checkbox" name="draft" checked="${u.draft}">
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <input type="submit" name="action" value="insert">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <c:if test="${not empty requestScope.error}">
            <span style="color: red">
                ${requestScope.error}
            </span>
        </c:if>
        <c:if test="${empty requestScope.error}">
            <span style="color: green">
                ${requestScope.megs}
            </span>
        </c:if>                
    </body>
</html>
