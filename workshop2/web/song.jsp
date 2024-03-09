<%-- 
    Document   : song
    Created on : Jun 28, 2023, 4:20:06 PM
    Author     : AnataArisa
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Song Page</title>
    </head>
    <form action="addsong" method="post">
        <label>Song Name</label>
        <input name="songname" type="text"><!-- comment --><br>
        <label>Song Description</label>
        <input name="songdes" type="text"><!-- comment --><br>
        <label>Song Author</label>
        <input name="songauthor" type="text"><br>
        <label>Song Link</label>
        <input name="songlink" type="text"><!-- comment --><br>
        <input name ="action" type="submit" value="AddSong"><!-- comment -->
    </form>
    <body>
        <h1>Song Manage</h1>
        <table border="2">
            <thead>
                <tr>
                    <td>Link</td>
                    <td>ID</td>
                    <td>Name</td>
                    <td>Description</td>
                    <td>Author</td>
                    <td>Create Date</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${songList}" var="o">
                    <tr>
                        <td><iframe src="https://www.youtube.com/embed/${o.link}?autoplay=1"></iframe></td>
                        <td>${o.id}</td>
                        <td>${o.name}</td>
                        <td>${o.des}</td><!-- comment -->
                        <td>${o.author}</td>
                        <td>${o.createDate}</td>
                        <td><a href="deletesong?id=${o.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
