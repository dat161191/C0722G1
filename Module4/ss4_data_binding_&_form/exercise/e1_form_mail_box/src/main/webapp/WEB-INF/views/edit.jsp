<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/22/2022
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
</head>
<body>
<h3>FORM ADD MAILBOX</h3>
<form:form action="/update" method="post" modelAttribute="mailbox">
    <table>
        <tr hidden>
            <td></td>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td>
                <form:select path="languages" items="${languagesList}">
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td><span>Show</span><span><form:select path="pageSize" items="${pageSizeList}">
            </form:select></span><span>Email per page</span>
            </td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams filter: </form:label></td>
            <td><span><form:checkbox path="spamsFilter"/></span><span>Enable spams filter</span></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:textarea path="signature"/></td>
        </tr>
    </table>
    <button class="btn btn-primary">Update</button>
</form:form>

</body>
</html>
