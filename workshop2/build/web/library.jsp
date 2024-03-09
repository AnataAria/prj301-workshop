<%-- 
    Document   : library
    Created on : Jun 30, 2023, 12:38:15 PM
    Author     : AnataArisa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Library Page</title>
    </head>
    <body>
        <h1>Book Management</h1>
        <form action="addbook" method="post">
        <label>Book Name</label>
        <input name="name" type="text"><!-- comment --><br>
        <label>Book Description</label>
        <input name="des" type="text"><!-- comment --><br>
        <label>Book Author</label>
        <input name="author" type="text"><br>
        <label>Publish Date</label>
        <input name="date" type="date"><!-- comment --><br>
        <input name ="action" type="submit" value="AddBook"><!-- comment -->
    </form>
    <body>
        <h1>Book Manage</h1>
        <table border="2">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Author</td>
                    <td>Public Date</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${bookList}" var="o">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.des}</td><!-- comment -->
                        <td>${o.author}</td>
                        <td>${o.publicDate}</td>
                        <td><a href="deletebook?id=${o.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
