<%-- 
    Document   : productList
    Created on : 9 thg 6, 2025, 02:00:57
    Author     : LAPTOP
--%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product List</h2>

<a href="products?action=create">+ Create New Product</a>

<c:set var="pageSize" value="10" />
<c:set var="currentPage" value="${param.page != null ? param.page : 1}" />
<c:set var="start" value="${(currentPage - 1) * pageSize}" />
<c:set var="totalProducts" value="${fn:length(products)}" />
<c:set var="totalPages" value="${(totalProducts / pageSize) + (totalProducts % pageSize == 0 ? 0 : 1)}" />

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Stock</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}" varStatus="status">
        <c:if test="${status.index >= start && status.index < (start + pageSize)}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.stock}</td>
                <td>
                    <a href="products?action=edit&id=${product.id}">Edit</a> |
                    <a href="products?action=delete&id=${product.id}">Delete</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
</table>

<!-- Pagination -->
<div style="margin-top: 10px;">
    <c:if test="${currentPage > 1}">
        <a href="products?page=${currentPage - 1}">Previous</a>
    </c:if>

    <c:forEach var="i" begin="1" end="${totalPages}">
        <c:choose>
            <c:when test="${i == currentPage}">
                <strong>${i}</strong>
            </c:when>
            <c:otherwise>
                <a href="products?page=${i}">${i}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>

    <c:if test="${currentPage < totalPages}">
        <a href="products?page=${currentPage + 1}">Next</a>
    </c:if>
</div>
</body>
</html>
