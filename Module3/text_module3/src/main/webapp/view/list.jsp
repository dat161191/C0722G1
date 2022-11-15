<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/13/2022
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Title</title>
    <style>
        * {
            font-family: "Palatino Linotype"
        }
    </style>
</head>
<body>
<div class="container">
    <%--    <div class="row text-center"><h2>Danh sách phòng trọ</h2></div>--%>
    <div class="row headers-region" style="background: #0cab0c">
        <div class="row" style="padding-top: 5px">
<%--            <div class="col-3">--%>
<%--                <form class="d-flex" action="/phongtro?action=search" method="post">--%>
<%--                    <input class="form-control me-2" type="search" name="ten" placeholder="Trần Gia Gia"--%>
<%--                           value="${ten}" aria-label="Search">--%>
<%--                    <button class="btn btn-primary" type="submit">Search</button>--%>
<%--                </form>--%>
<%--            </div>--%>
<%--            <div class="col-7">--%>
            <div class="row" style="margin-top: 10px">
                <h2 style="text-align: center;color: white;font-size: 30px">DANH SÁCH PHÒNG TRỌ</h2>
                <h2 style="text-align: center;color: white;font-size: 25px">
                    <c:if test="${mess!=null}">
                        <span>${mess}</span>
                    </c:if></h2>
            </div>
<%--            <div class="col-2">--%>
<%--                <a href="/phongtro?action=add">--%>
<%--                    <button class="btn btn-primary" type="button"> Thêm mới khách hàng</button>--%>
<%--                </a>--%>
<%--            </div>--%>
        </div>
    </div>
    <div class="row content" style="align-items: center;justify-content: center">
        <div class="row" style="padding-top: 10px">
            <div class="col-7">
                <form class="d-flex" action="/phongtro?action=search" method="post">
                    <input class="form-control me-2" type="search" name="ten" placeholder="Trần Gia Gia"
                           value="${ten}" aria-label="Search">
                    <input class="form-control me-2" type="search" name="sdt" placeholder="0385425443"
                           value="${sdt}" aria-label="Search">
                    <input class="form-control me-2" type="search" name="tenHinhThuc" placeholder="Năm / Tháng / Ngày "
                           value="${tenHinhThuc}" aria-label="Search">
                    <button class="btn btn-primary" type="submit">Search</button>
                </form>
            </div>
            <div class="col-3"></div>
            <div class="col-2">
                <a href="/phongtro?action=add">
                    <button class="btn btn-primary" type="button"> Thêm mới khách hàng</button>
                </a>
            </div>
        </div>
        <table id="tableCustomer" class="table table-striped table-hover table-primary"
               style="width:100%;margin-top: 10px">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên người thuê trọ</th>
                <th>Số điện thoại</th>
                <th>Ngày bắt đàu thuê</th>
                <th>Ghi chú</th>
                <th>Hình thức thuê</th>
                <th>Cập nhật</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="phongTro" items="${phongTroList}" varStatus="stt">
                <tr>
                    <th scope="row">${stt.count}</th>
                    <td>${phongTro.getTen()}</td>
                    <td>${phongTro.getSdt()}</td>
                    <td>${phongTro.getNgayThue()}</td>
                    <td>${phongTro.getGhiChu()}</td>
                    <td>${phongTro.getTenHinhThuc()}</td>
                    <td>
                        <a href="/phongtro?action=edit&maPhongTro=${phongTro.getMaPhongTro()}"
                           class="btn btn-primary ms-2 text-light">Cập nhật</a>
                    </td>
                    <td>
                        <button type="button" onclick="idRemove('${phongTro.getMaPhongTro()}','${phongTro.getTen()}')"
                                class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#exampleRemove"> Xóa
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="row footer" style="background-color:#0cab0c ">
        <div class="col-3" style="color: white">
            <h4>Trần Quốc Đạt</h4>
            <h5>C0722G1</h5>
        </div>
        <div class="col-5"></div>
        <div class="col-4" style="color: white">
            <h4>Email: <i>quocdat.tran453@gmail.com</i></h4>
            <h5>SDT: <u>038-542.5443</u></h5>
        </div>
    </div>

</div>

<%------------------MODAL REMOVE--------------------%>
<div class="modal fade" id="exampleRemove" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <p style="font-size: 15px;color: blue;text-align: center">Bạn có chắc muốn xóa người thuê này???</p>
                <P id="name" style="font-size: 25px;color: red;text-align: center"></P>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                </button>
                <form action="/phongtro?action=remove" method="post">
                    <input type="hidden" name="id" id="idInput">
                    <button class="btn btn-primary">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%---------------FUNCTION REMOVE------------------%>
<script>
    function idRemove(id, name) {
        document.getElementById("idInput").value = id;
        document.getElementById("name").innerText = name;
    }
</script>
</body>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
</html>
