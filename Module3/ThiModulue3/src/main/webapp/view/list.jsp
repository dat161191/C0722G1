<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/14/2022
  Time: 5:02 PM
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
    <link rel="stylesheet" href="/bootstrap-5.2.2-dist/css/bootstrap.css">
    <link rel="stylesheet" href="/bootstrap-5.2.2-dist/js/bootstrap.js">
    <title>List</title>
    <style>
        * {
            font-family: "Palatino Linotype"
        }
    </style></head>
<body>

<div class="container-fluid">
    <div class="row headers-region" style="background: #0cab0c">
        <div class="row" style="padding-top: 5px">
            <div class="row" style="margin-top: 5px">
                <h2 style="text-align: center;color: white;font-size: 30px">DANH SÁCH BỆNH ÁN</h2>
                <h2 style="text-align: center;color: white;font-size: 25px">
                    <c:if test="${mess!=null}">
                        <span>${mess}</span>
                    </c:if></h2>
            </div>
        </div>
    </div>
    <div class="row content" style="align-items: center;justify-content: center">
        <table id="tableText" class="table table-striped table-hover table-primary"
               style="width:100%;margin-top: 10px">
            <thead>
            <tr>
                <th>STT</th>
                <th>Mã Bệnh Án</th>
                <th>Mã Bệnh Nhân</th>
                <th>Tên Bệnh Nhân</th>
                <th>Ngày Nhập Viện</th>
                <th>Ngày Xuất Viện</th>
                <th>Lý Do Nhập Viện</th>
                <th>Cập nhật</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="benhNhan" items="${benhNhanList}" varStatus="stt">
                <tr>
                    <th scope="row">${stt.count}</th>
                    <td>${benhNhan.getMaHoSo()}</td>
                    <td>${benhNhan.getMaBenhNhan()}</td>
                    <td>${benhNhan.getTenBenhNhan()}</td>
                    <td>${benhNhan.getNgayNhapVien()}</td>
                    <td>${benhNhan.getNgayRaVien()}</td>
                    <td>${benhNhan.getLyDoNhapVien()}</td>
                    <td>
                        <a href="/benhNhan?action=edit&maBenhNhan=${benhNhan.getMaBenhNhan()}"
                           class="btn btn-primary ms-2 text-light">Cập nhật</a>
                    </td>
                    <td>
                        <button type="button" onclick="idRemove('${benhNhan.getMaBenhAn()}','${benhNhan.getTenBenhNhan()}')"
                                class="btn btn-danger" data-bs-toggle="modal"
                                data-bs-target="#modalRemove"> Xóa
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

</body>
<script>
    function idRemove(maBenhAn, tenBenhNhan) {
        document.getElementById("idInput").value = maBenhAn;
        document.getElementById("name").innerText = maBenhAn;
    }
</script>

<div class="modal fade" id="modalRemove" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <p style="font-size: 15px;color: blue;text-align: center">Bạn có chắc muốn xóa thông tin bệnh án này không???</p>
                <div style="text-align: center">
                    <span> MÃ BỆNH ÁN: </span><span id="name" style="font-size: 25px;color: red;"></span>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                </button>
                <form action="/benhNhan?action=remove" method="post">
                    <input type="hidden" name="id" id="idInput">
                    <button class="btn btn-primary">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="jquery/jquery-3.5.1.min.js"></script>

<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableText').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 4
        });
    });
</script>
</html>
