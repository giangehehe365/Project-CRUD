<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Create New Product</title>
</head>
<body>
    <h1>Create New Product</h1>
    <form action="products?action=create" method="post">
        <table border="1" cellpadding="5">
            <caption><h2>Enter Product Details</h2></caption>
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" required/></td>
            </tr>
            <tr>
                <th>Price:</th>
                <td><input type="number" name="price" required step="0.01" min="0"/></td>
            </tr>
           
            <tr>
                <th>Description:</th>
                <td><input type="text" name="description" required/></td>
            </tr>
            <tr>
                <th>Stock:</th>
                <td><input type="number" name="stock" required min="0"/></td>
            </tr>
        </table>
        <br/>
        <input type="submit" value="Add Product"/>
    </form>
    <br/>
    <a href="products?action=products">Back to Product List</a>
</body>
</html>
