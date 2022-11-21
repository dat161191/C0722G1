<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/21/2022
  Time: 11:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
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
</head>
<body>
<div class="row">
    <div class="col-2"></div>
    <div class="col-8 mt-5">
        <form action="/save" method="post">
            <h2>Bún và gia vị</h2>
            <input type="checkbox" id="gv1" name="giaVi" value="Mắm">
            <label for="gv1"> Mắm</label>
            <input type="checkbox" id="gv2" name="giaVi" value="Muối">
            <label for="gv2"> Muối</label>
            <input type="checkbox" id="gv3" name="giaVi" value="Đường">
            <label for="gv3"> Đường</label>
            <input type="checkbox" id="gv4" name="giaVi" value="Bột Ngọt">
            <label for="gv4"> Bột Ngọt</label>
            <button class="btn btn-primary">Save</button>
            <h2>Danh sách gia vị đi kèm:
                <c:if test="${list != null}">
                <c:forEach var="element" items="${list}">
                ${element},
                </c:forEach>
                </c:if></h2>
        </form>
    </div>
</div>

</body>
</html>
