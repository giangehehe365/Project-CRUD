<%-- 
    Document   : accessDenied
    Created on : 9 thg 6, 2025, 16:12:01
    Author     : LAPTOP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
    <h2 style="color:red;">${message}</h2>
    <a href="${pageContext.request.contextPath}/users?action=list">Quay lại danh sách User</a>
</body>
</html>
