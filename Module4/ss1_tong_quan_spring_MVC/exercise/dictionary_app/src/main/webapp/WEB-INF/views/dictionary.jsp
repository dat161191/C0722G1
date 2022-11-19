<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/18/2022
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
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
<div class="container">
    <form method="post" action="find">
        <div class="mb-3">
            <label>Tiếng anh:
            <input type="text" class="form-control" placeholder="ex:Chicken" id="enWord" name="enWord" ></label>
        </div>
        <button type="submit" class="btn btn-primary">Dịch</button>
        <div class="mb-3">
            <p style="color: red">Kết Quả: ${viWord} </p>
        </div>
    </form>
</div>
</body>
</html>
