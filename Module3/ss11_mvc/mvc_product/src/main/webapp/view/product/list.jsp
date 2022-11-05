<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/5/2022
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<h1 style="text-align: center">Product List</h1>
<a href="/product?action=add">
    <button style="float: right" class="btn btn-primary">Thêm mới Sản Phẩm</button>
</a>
<table class="table table-success">
    <tr>
        <th>STT</th>
        <th hidden>ID</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Update</th>
        <th>Delete</th>
        <th>View</th>
    </tr>
    <c:forEach var="product" items="${productList}" varStatus="stt">
        <tr>
            <td>${stt.count}</td>
            <td hidden>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td><a href="/product?action=edit&id=${product.getId()}">
                <button class="btn btn-success">Edit</button>
            </a></td>
            <td><a href="/product?action=remove&id=${product.getId()}">
                <button class="btn btn-danger">Remove</button>
            </a></td>
            <td><a href="/product?action=detail&id=${product.getId()}">
                <button class="btn btn-secondary">Detail</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
