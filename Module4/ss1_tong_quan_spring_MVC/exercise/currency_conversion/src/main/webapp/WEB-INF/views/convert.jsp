<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/18/2022
  Time: 2:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Convert</title>
</head>
<body>
<form method="post" action="/convert_to_usd">
    <p><span>VND</span><span> </span><span><input type="number" id="vnd" name="vnd"></span> <span><button type="submit">to USD</button></span></p>
</form>

<form method="post" action="/convert_to_vnd">
    <p><span>USD</span><span> </span><span><input type="number" id="usd" name="usd"></span> <span><button type="submit">to VND</button></span></p>
</form>
<p>Result: ${result}</p>
</body>
</html>
