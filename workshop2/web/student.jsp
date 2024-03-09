<%-- 
    Document   : student
    Created on : Jun 28, 2023, 6:22:27 PM
    Author     : AnataArisa
--%>

<%@page import="java.util.List"%>
<%@page import="model.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
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
                <%
                    List<Student> studentList = (List<Student>) request.getAttribute("studentList");
                    for (Student s : studentList) {
                    
                %>
                <tr>
                    <th><%%></th>
                </tr>
                <%}%>
            </tbody>
        </table>
    </body>
</html>
