<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/7/2022
  Time: 3:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <title>Title</title>
</head>
<body>
<a href="/user"><button>Quay lại trang List</button></a>
<c:if test="${mess!=null}">
    <span>${mess}</span>
</c:if>
<form action="/user?action=edit" method="post">
    <table>
        <tr>
            <td hidden>ID</td>
            <td>Name</td>
            <td>Email</td>
            <td>Country</td>
        </tr>
        <tr>
            <td hidden><input type="text" name="id" value="${user.getId()}"></td>
            <td><input type="text" name="name" value="${user.getName()}"></td>
            <td><input type="text" name="email" value="${user.getEmail()}"></td>
            <td><input type="text" name="country" value="${user.getCountry()}"></td>
        </tr>
        <tr>
            <td><button>Confirm</button></td>
        </tr>
    </table>
</form>
</body>
</html>
