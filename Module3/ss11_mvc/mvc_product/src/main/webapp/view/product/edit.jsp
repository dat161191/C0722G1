<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/5/2022
  Time: 5:41 PM
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
<h1 style="text-align: center">Sửa Thông Tin sản phẩm</h1>
<p>
    <a href="/product"><button>Quay lại trang List</button></a>
    <c:if test="${message!=null}">
        <span>${message}</span>
    </c:if>
</p>

<form action="/product?action=edit" method="post">
    <table>
        <tr>
            <td hidden>ID</td>
            <td>Tên</td>
            <td>Giá</td>
        </tr>
        <tr>
            <td hidden><input type="text" name="id" value="${product.getId()}"></td>
            <td><input type="text" name="name" value="${product.getName()}"></td>
            <td><input type="text" name="price" value="${product.getPrice()}" ></td>
        </tr>
    </table>
    <button>Sửa</button>
</form>
</body>
</html>
