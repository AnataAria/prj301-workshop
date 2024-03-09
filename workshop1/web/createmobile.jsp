<%-- 
    Document   : createmobile
    Created on : May 23, 2023, 10:24:24 AM
    Author     : AnataArisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="loginstyle.css" rel="stylesheet"/>
        <title>Create Device</title>
    </head>
    <body>
        <div class="container" id="container">
            <div>
                <form action="createmobile" method="post">
                    <h1>Create Device</h1>
                    <input type="text" placeholder="Mobile ID" name="deviceid"/>
                    <input type="text" placeholder="Description" name="description"/>
                    <input type="tel" placeholder="Price" name="price"/>
                    <input type="text" placeholder="Mobile Name" name="mobilename"/>
                    <input type="number" placeholder="Year of production" name="yearproduction"/>
                    <input type="number" placeholder="Quantity" name="quantity"/>
                    <input type="checkbox" name="sale" value="true"/> Is Sale
                    <button>CREATE</button>
                </form>
            </div>
        </div>
    </body>
</html>
