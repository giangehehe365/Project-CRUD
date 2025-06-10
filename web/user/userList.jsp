<%-- 
    Document   : userList
    Created on : 26 thg 5, 2025
    Author     : LAPTOP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <center>
        <h1>User Management</h1>
        <h2>
            <a href="${pageContext.request.contextPath}/users?action=new">Add New User</a>
        </h2>
    </center>

    <div align="center">
        <table border="1" cellpadding="5">
            <caption>
                <h2>List of Users</h2>
            </caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
                <th>Status</th>
            </tr>
            <c:forEach var="user" items="${listUser}">
                <tr>
                    <td><c:out value="${user.id}" /></td>
                    <td><c:out value="${user.name}" /></td>
                    <td><c:out value="${user.email}" /></td>
                    <td><c:out value="${user.country}" /></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/users?action=edit&id=${user.id}">Edit</a>
                        <c:if test="${user.status}">
                            <a href="${pageContext.request.contextPath}/users?action=delete&id=${user.id}" onclick="return confirm('Are you sure?')">Delete</a>
                        </c:if>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${user.status}">Active</c:when>
                            <c:otherwise>Inactive</c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <center>
        <a href="${pageContext.request.contextPath}/logout">Log out</a>
    </center>
</body>
</html>
