<%-- 
    Document   : deleteProduct
    Created on : 9 thg 6, 2025, 02:00:48
    Author     : LAPTOP
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
    <h2>Confirm Deletion</h2>
    <c:if test="${not empty product}">
        <p>Are you sure you want to delete the following product?</p>
        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Name:</strong> ${product.name}</p>
        <p><strong>Price:</strong> ${product.price}</p>
        <form action="products?action=delete" method="post">
            <input type="hidden" name="id" value="${product.id}" />
            <button type="submit">Delete</button>
            <a href="products">Cancel</a>
        </form>
    </c:if>
</body>
</html>
