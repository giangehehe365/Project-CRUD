<%-- 
    Document   : createUser
    Created on : 26 thg 5, 2025
    Author     : LAPTOP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Add New User - User Management</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2><a href="${pageContext.request.contextPath}/users">List All Users</a></h2>
</center>

<div align="center">
    <form action="${pageContext.request.contextPath}/users?action=insert" method="post">
        <table border="1" cellpadding="5" cellspacing="0">
            <caption><h2>Add New User</h2></caption>
            <tr>
                <th>User Name:</th>
                <td><input type="text" name="name" size="45" required /></td>
            </tr>
            <tr>
                <th>Email:</th>
                <td><input type="email" name="email" size="45" required /></td>
            </tr>
            <tr>
                <th>Country:</th>
                <td><input type="text" name="country" size="15" /></td>
            </tr>
            <tr>
                <th>Role:</th>
                <td>
                    <select name="role" required>
                        <option value="User" selected>User</option>
                        <option value="Admin">Admin</option>
                        <option value="Moderator">Moderator</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Status:</th>
                <td>
                    <input type="radio" name="status" value="1" checked required /> Active
                    <input type="radio" name="status" value="0" required /> Inactive
                </td>
            </tr>
            <tr>
                <th>Password:</th>
                <td><input type="password" name="password" size="45" required /></td>
            </tr>
            <tr>
                <th>Date of Birth:</th>
                <td><input type="date" name="dob" required /></td>
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

