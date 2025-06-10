<%-- 
    Document   : login
    Created on : 28 thg 5, 2025, 22:10:22
    Author     : LAPTOP
--%>

<%@ page import="jakarta.servlet.http.Cookie" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String savedUsername = "";
    boolean rememberChecked = false;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
            if ("name".equals(c.getName())) {
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
        <label for="name">Tên đăng nhập:</label>
        <input type="text" name="name" id="name" value="<%= savedUsername %>" required />

        <label for="password">Mật khẩu:</label>
        <input type="password" name="password" id="password" required />

        <label>
            <input type="checkbox" name="rememberMe" value="yes" <%= rememberChecked ? "checked" : "" %> />
            Ghi nhớ đăng nhập
        </label>

        <button type="submit">Đăng nhập</button>
    </form>

</body>
</html>

