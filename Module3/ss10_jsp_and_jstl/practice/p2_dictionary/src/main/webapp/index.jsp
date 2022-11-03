<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/3/2022
  Time: 8:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>BossTran</title>
  </head>
  <body>
  <h2>Vietnamese Dictionary</h2>
  <form action="dictionary.jsp" method="post">
    <input type="text" name="search" placeholder="Enter your word: "/>
    <input type = "submit" id = "submit" value = "Search"/>
  </form>
  </body>
</html>
