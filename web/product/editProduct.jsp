<%-- 
    Document   : editProduct
    Created on : 9 thg 6, 2025, 02:00:10
    Author     : LAPTOP
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Edit Product</title>
</head>
<body>
    <center>
        <h1>Product Management</h1>
        <h2>
            <a href="products?action=list">List All Products</a>
        </h2>
    </center>
    <div align="center">
        <form method="post" action="/SU25_Demo_MainController/products?action=edit">
            <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
            <table border="1" cellpadding="5">
                <caption><h2>Edit Product</h2></caption>
                <tr>
                    <th>Product Name:</th>
                    <td>
                        <input type="text" name="name" size="45" value="<c:out value='${product.name}' />" required />
                    </td>
                </tr>
                <tr>
                    <th>Price:</th>
                    <td>
                        <input type="number" name="price" step="0.01" size="15" value="<c:out value='${product.price}' />" required />
                    </td>
                </tr>
                <tr>
    


                <tr>
                    <th>Description:</th>
                    <td>
                        <textarea name="description" rows="4" cols="50" required><c:out value='${product.description}' /></textarea>
                    </td>
                </tr>
                
                <tr>
                    <th>Stock:</th>
                    <td>
                        <input type="number" name="stock" min="0" size="10" value="<c:out value='${product.stock}' />" required />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
