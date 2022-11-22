<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/21/2022
  Time: 11:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="https://www.24h.com.vn/"><button>Click Me!</button></a>
<a href="/showForm"><button>Thêm Mới</button></a>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${contactNumber}</td>
    </tr>
</table>
</body>
</html>
