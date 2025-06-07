<%-- 
    Document   : login
    Created on : 28 thg 5, 2025, 22:10:22
    Author     : LAPTOP
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String savedUsername = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("username".equals(c.getName())) {
                savedUsername = c.getValue();
                break;
            }
        }
    }
%>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Login Form</h2>

    <% if (request.getAttribute("errorMessage") != null) { %>
        <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
    <% } %>

    <form action="login" method="post">
        <label>Tên đăng nhập:</label>
        <input type="text" name="name" required />

        <label>Mật khẩu:</label>
        <input type="password" name="password" required />

        <label>Ghi nhớ đăng nhập:</label>
        <input type="checkbox" name="rememberMe" value="yes" />

        <button type="submit">Đăng nhập</button>
    </form>

</body>
</html>

