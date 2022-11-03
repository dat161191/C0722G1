<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/3/2022
  Time: 1:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>

</head>
<body>
<div class="row text-center" style="align-items: center;justify-content: center">
    <h1><b>Simple Calculator</b></h1>
    <form action="/calulator" method="post" style="width: 40%;">
        <div class="row bg-light">
            <table>
                <tr>
                    <th>First operand</th>
                    <td><input type="text" name="num1"></td>
                </tr>
                <tr>
                    <th>Operator</th>
                    <td><select name="Operator">
                        <option value="+">Addition</option>
                        <option value="-">Subtraction</option>
                        <option value="*">Multiplication</option>
                        <option value="/">Division</option>
                    </select></td>
                </tr>
                <tr>
                    <th>Second operand</th>
                    <td><input type="text" name="num2"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input style="width: 30%;" type="submit" name="calculator" value="Calculator"></td>
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>
