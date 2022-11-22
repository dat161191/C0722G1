<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/21/2022
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create new Product</h1>
<a href="/products">Back to product list</a>
<p>
    <c:if test="${message != null}">
        <span class="message">${message}</span>
    </c:if>
</p>
<form:form action="new" method="post" modelAttribute="product">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td><form:label path="code">Code:</form:label></td>
                <td><form:input path="code"/></td>
            </tr>
            <tr>
                <td><form:label path="name">Name:</form:label></td>
                <td><form:input path="name"/></td>
            </tr>
            <tr>
                <td><form:label path="price">Price:</form:label></td>
                <td><form:input path="price"/></td>
            </tr>
            <tr>
                <td></td>
                <td><form:button>Create product</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
