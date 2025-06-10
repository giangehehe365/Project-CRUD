<%-- 
    Document   : editUser
    Created on : 26 thg 5, 2025
    Author     : LAPTOP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> <!-- thêm dòng này -->

<html>
<head>
    <title>Edit User - User Management</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2><a href="${pageContext.request.contextPath}/users?action=list">List All Users</a></h2>
</center>

<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/users?action=edit">
        <input type="hidden" name="id" value="${user.id}" />
        <table border="1" cellpadding="5" cellspacing="0">
            <caption><h2>Edit User</h2></caption>
            <tr>
                <th>User Name:</th>
                <td><input type="text" name="name" value="${fn:escapeXml(user.name)}" size="45" required /></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="email" name="email" value="${fn:escapeXml(user.email)}" size="45" required /></td>
            </tr>
            <tr>
                <th>Country:</th>
                <td><input type="text" name="country" value="${fn:escapeXml(user.country)}" size="15" /></td>
            </tr>
            <tr>
                <th>Role:</th>
                <td>
                    <select name="role" required>
                        <option value="User" <c:if test="${user.role == 'User'}">selected</c:if>>User</option>
                        <option value="Admin" <c:if test="${user.role == 'Admin'}">selected</c:if>>Admin</option>
                        <option value="Moderator" <c:if test="${user.role == 'Moderator'}">selected</c:if>>Moderator</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <input type="radio" name="status" value="1" <c:if test="${user.status}">checked</c:if> required /> Active
                    <input type="radio" name="status" value="0" <c:if test="${not user.status}">checked</c:if> required /> Inactive
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td><input type="password" name="password" value="${fn:escapeXml(user.password)}" size="45" required /></td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td>
                    <input type="date" name="dob" 
                        value="<fmt:formatDate value='${user.dob}' pattern='yyyy-MM-dd'/>" required />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>