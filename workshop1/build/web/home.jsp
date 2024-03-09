<%-- 
    Document   : home.jsp
    Created on : May 21, 2023, 10:25:39 AM
    Author     : AnataArisa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <title>${title}</title>
        <link rel="stylesheet" href="homestyle.css"/>
    </head>
    <body>
        <div class="container-fluid user-container" style="display: ${userui}">
            <div class="container-fluid">
                <form action="searchprice" method="post" style="display: flex">
                    <input name="minprice" type="number" placeholder="Enter min price" size="70"/>
                    <input name="maxprice" type="number" placeholder="Enter max price" size="70"/>
                    <button type="submit">Search</button>
                </form>
                <form action="logout" method="post">
                    <button>Logout</button>
                </form>
            </div>
            <div class="container-fluid table-mobile">
                <label> Mobile Device List</label>
                <div class="table-header row">
                    <div class="col-md-2">
                        <p>Mobile ID</p>
                    </div>
                    <div class="col-md-2">
                        <p>Mobile Name</p>
                    </div>
                    <div class="col-md-2">
                        <p>Description</p>
                    </div>
                    <div class="col-md-2">
                        <p>Price</p>
                    </div>
                    <div class="col-md-2">
                        <p>Year Of Production</p>
                    </div>
                    <div class="col-md-1">
                        <p>Quantity</p>
                    </div>
                    <div class="col-md-1">
                        <p>Add to cart</p>
                    </div>
                </div>
                <div class="table-row">
                    <c:forEach items="${deviceList}" var="o">
                        <form action="addcartservlet" method="POST">
                            <div class="row">
                                <div class="col-md-2 cover">
                                    <input name="deviceid" type="text" class="row-value-input" value="${o.mobileId}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="mobilename" type="text" class="row-value-input" value="${o.mobileName}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="description" type="text" class="row-value-input" value="${o.description}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="price" type="text" class="row-value-input" value="${o.price}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="yearproduction" type="text" class="row-value-input" value="${o.yearOfProduction}" readonly>
                                </div>
                                <div class="col-md-1 cover">
                                    <input name="quantity" type="text" class="row-value-input" value="${o.quantity}" readonly>
                                </div>
                                <div class="col-md-1 cover">
                                    <button type="submit">Add to cart</button>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
            <div class="container-fluid table-mobile" id="addcart">
                <div class="table-header row">
                    <div class="col-md-2">
                        <p>Mobile ID</p>
                    </div>
                    <div class="col-md-2">
                        <p>Mobile Name</p>
                    </div>
                    <div class="col-md-2">
                        <p>Description</p>
                    </div>
                    <div class="col-md-2">
                        <p>Price</p>
                    </div>
                    <div class="col-md-2">
                        <p>Year Of Production</p>
                    </div>
                    <div class="col-md-2">
                        <p>Remove Cart</p>
                    </div>
                </div>
                <div class="table-row">
                    <c:forEach items="${deviceListcad}" var="o">
                        <form action="removecart" method="post">
                            <div class="row">
                                <div class="col-md-2 cover">
                                    <input name="deviceid" type="text" class="row-value-input" value="${o.mobileId}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="mobilename" type="text" class="row-value-input" value="${o.mobileName}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="description" type="text" class="row-value-input" value="${o.description}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="price" type="text" class="row-value-input" value="${o.price}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="yearproduction" type="text" class="row-value-input" value="${o.yearOfProduction}" readonly>
                                </div>
                                <div class="col-md-2 cover">
                                    <button type="submit">Remove cart</button>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
                <form action="order" method="post">
                    <button type="submit">Order</button><!-- comment -->
                </form>
            </div>
        </div>
        <div class="container-fluid am-container" style="display: ${adminui}">
            <div class="container-fluid">
                <form action="searchidname" method="post" style="display: flex">
                    <input name="searchinput" type="search" placeholder="Enter mobile ID or name here" size="70"/>
                    <button type="submit">Search</button>
                </form>
                <form action="logout" method="post">
                    <button>Logout</button>
                </form>
            </div>
            <div class="container-fluid">
                <form method="GET" action="createmobile">
                    <button>CREATE NEW DEVICE</button>
                </form>
            </div>
            <div class="container-fluid table-acc" background="black">
                <div class="row table-header">
                    <div class="col-md-1">
                        <p>Mobile ID</p>
                    </div>
                    <div class="col-md-1">
                        <p>Description</p>
                    </div>
                    <div class="col-md-2">
                        <p>Price</p>
                    </div>
                    <div class="col-md-1">
                        <p>Mobile Name</p>
                    </div>
                    <div class="col-md-2">
                        <p>Year Of Production</p>
                    </div>
                    <div class="col-md-1">
                        <p>Quantity</p>
                    </div>
                    <div class="col-md-1">
                        <p>Not Sale</p>
                    </div>
                    <div class="col-md-3">
                        <p>Action</p>
                    </div>
                </div>
                <div class="table-row">
                    <c:forEach items="${deviceList}" var="o">
                        <form action="updatedevice" method="post">
                            <div class="row">
                                <div class="col-md-1 cover">
                                    <input name="deviceid" type="text" class="row-value-input" value="${o.mobileId}">
                                </div>
                                <div class="col-md-1 cover">
                                    <input name="description" type="text" class="row-value-input" value="${o.description}">
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="price" type="tel" class="row-value-input" value="${o.price}">
                                </div>
                                <div class="col-md-1 cover">
                                    <input name="mobilename" type="text" class="row-value-input" value="${o.mobileName}">
                                </div>
                                <div class="col-md-2 cover">
                                    <input name="yearproduction" type="text" class="row-value-input" value="${o.yearOfProduction}">
                                </div>
                                <div class="col-md-1 cover">
                                    <input name="quantity" type="text" class="row-value-input" value="${o.quantity}">
                                </div>
                                <div class="col-md-1 cover">
                                    <input name="sale" type="text" class="row-value-input" value="${o.sale}">
                                </div>
                                <div class="col-md-3 cover">
                                    <a class="deletebtn" href="removedevice?deviceid=${o.mobileId}">Delete</a>
                                    <button type="submit">Update</button>
                                </div>
                            </div>
                        </form>
                    </c:forEach>
                </div>
            </div>
        </div> 
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </body>
</html>
