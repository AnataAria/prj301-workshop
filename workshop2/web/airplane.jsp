<%-- 
    Document   : airplane
    Created on : Jun 30, 2023, 1:16:44 PM
    Author     : AnataArisa
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Airplane Page</title>
    </head>
    <body>
        <h1>Airplane Management</h1>
        <form action="addplane" method="post">
            <label>Number</label>
            <input name="name" type="text"><!-- comment --><br>
            <label>Destination</label>
            <input name="des" type="text"><!-- comment --><br>
            <label>Depart Time</label>
            <input name="time" type="date"><br>
            <label>Status</label>
            <input name="status" type="number"><!-- comment --><br>
            <input name ="action" type="submit" value="AddPlane"><!-- comment -->
        </form>
    <body>
        <h1>Airplane Manage</h1>
        <table border="2">
            <thead>
                <tr>
                    <td>ID</td>
                    <td>Flight Number</td>
                    <td>Destination</td>
                    <td>Depart Date</td>
                    <td>Status</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${planeList}" var="o">
                    <tr>
                        <td>${o.getID()}</td>
                        <td>${o.flightNumber}</td>
                        <td>${o.destination}</td><!-- comment -->
                        <td>${o.depart}</td>
                        <td><c:if test="${o.status == 1}">
                                <c:out value="ON BOARD"></c:out>
                            </c:if>
                            <c:if test="${o.status == 2}">
                                <c:out value="DEPARTURE"></c:out>
                            </c:if>
                            <c:if test="${o.status == 3}">
                                <c:out value="DELAYED"></c:out>
                            </c:if></td>
                        <td><a href="deleteplane?id=${o.ID}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
