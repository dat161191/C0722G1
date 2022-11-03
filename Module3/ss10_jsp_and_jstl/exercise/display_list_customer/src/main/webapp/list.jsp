<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/3/2022
  Time: 11:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>BossTran</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="container" style="border: 1px solid navy;">
    <h1 style="text-align: center;color: gold;">Top 5 người mẫu Victoria Sceret's</h1>
    <div class="row">
        <div class="col-xl-2"></div>
        <div class="col-xl-8">
            <table class="table table-hover table-success table-striped" style="text-align: center;">
                <tr>
                    <th>STT</th>
                    <th>NAME</th>
                    <th>BIRTHDAY</th>
                    <th>ADDRESS</th>
                    <th>SUNFACE</th>
                </tr>
                <c:forEach var="victoria" items="${victoriaList}" varStatus="status">
                    <tr>
                        <td>${status.count}</td>
                        <td>${victoria.getName()}</td>
                        <td>${victoria.getBirth()}</td>
                        <td>${victoria.getAddress()}</td>
                        <td><img style="width: 100%" src="${victoria.getFace()}" alt=""></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-xl-2"></div>
    </div>
</div>
</body>
</html>
