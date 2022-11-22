<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/21/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
            crossorigin="anonymous">

    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6"><h1>Products</h1>
        <p><a href="/new">Add new product</a></p>
        <p>There are ${products.size()} products in this list.</p>
        <table border="1" class="table table-primary table-hover text-center">
            <tr>
                <td>Code</td>
                <td>Name</td>
                <td>Price</td>
            </tr>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.getId()}</td>
                    <td><a href="/view?id=${product.getId()}"> ${product.getName()}</a></td>
                    <td>${product.getPrice()}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>


</body>
</html>
