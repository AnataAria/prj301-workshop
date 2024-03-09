<%-- 
    Document   : inventory
    Created on : Jun 28, 2023, 7:21:34 PM
    Author     : AnataArisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Page</title>
    </head>
    <body>
        <h1>Inventory Management</h1>
        <form action="addproduct" method="post">
        <label>Product Name</label>
        <input name="productname" type="text"><!-- comment --><br>
        <label>Product Description</label>
        <input name="productdes" type="text"><!-- comment --><br>
        <label>Product Unit</label>
        <input name="productunit" type="text"><br>
        <label>Quantity</label>
        <input name="quantity" type="text"><br>
        <label>Price</label>
        <input name="productprice" type="text"><!-- comment --><br>
        <input name ="action" type="submit" value="AddProduct"><!-- comment -->
    </form>
    <body>
        <table border="2">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Unit</td>
                    <td>Quantity</td>
                    <td>Price</td>
                    <td>Is Low Product</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${productList}" var="o">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.description}</td><!-- comment -->
                        <td>${o.unit}</td>
                        <td>${o.quantity}</td>
                        <td>${o.price}</td>
                        <td>${o.isLowProduct()}</td>
                        <td><a href="deleteproduct?id=${o.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
