<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/21/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Title</title>
</head>
<body>
<div class="row">
    <div class="col-3"></div>
    <div class="col-6"><h1>Product details</h1>
        <a href="/products">Back to product list</a>
        <table class="table table-primary">
            <tr>
                <td>Code:</td>
                <td>${product.getCode()}</td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>${product.getName()}</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${product.getPrice()}</td>
            </tr>
        </table>
    </div>
</div>


</body>
</html>
