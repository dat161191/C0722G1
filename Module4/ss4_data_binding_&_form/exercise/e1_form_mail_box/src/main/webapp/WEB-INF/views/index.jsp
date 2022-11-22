<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/22/2022
  Time: 1:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <title>$Title$</title>
</head>
<body>
<h1>${mess}</h1>
<table class="table table-primary table-hover">
    <tr>
        <td>Languages</td>
        <td>Edit</td>
    </tr>
    <c:forEach var="mailBox" items="${mailboxList}" varStatus="stt">
        <tr>
            <td>${mailBox.getLanguages()}</td>
            <td><a href="/formEdit?id=${mailBox.getId()}">
                <button class="btn btn-primary"><i class="bi bi-person-check-fill"></i>Form MailBox</button>
            </a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
