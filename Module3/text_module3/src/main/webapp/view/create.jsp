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
<div class="container-fluid">
    <div class="row headers-region"
         style="display: flex;flex-wrap: nowrap;text-align: center;background-color: #c71212">
        <a href="/phongtro" style="text-decoration: none"><i class="fa fa-home" style="font-size:40px;color:white"></i>
            <span style="font-size: 40px;color: white">Trần Quốc Đạt - C0722G1</span>
        </a>
    </div>
    <div class="row content">
        <section>
            <div class="container py-5 h-100 bg-primary">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="row">
                        <h2 style="text-align: center;color: white"><c:if test="${mess!=null}">
                            <span>${mess}</span>
                        </c:if></h2>
                    </div>
                    <div class="row">
                        <form action="/phongtro?action=add" method="post">
                            <div class="card card-registration my-4">
                                <div class="row g-0">
                                    <div class="col-xl-12">
                                        <div class="card-body p-md-5 text-primary" style="font-size: 20px">
                                            <h3 class="mb-2 text-uppercase"
                                                style="text-align: center;color: blue;font-size: 40px">
                                                <b>THÊM MỚI</b></h3>
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label" for="form3Example1m">Tên</label>
                                                    <input type="text" id="form3Example1m" required
                                                           pattern="([A-Z][a-z]+ )+([A-Z][a-z]+)$"
                                                           title="Không chứa kí tự đặc biệt,chữ cái đầu viết hoa,có ít nhất 2 từ và cách nhau bởi khoảng trắng"
                                                           class="form-control form-control-lg"
                                                           placeholder="VD:Trần Gia Gia"
                                                           name="ten"/>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <div class="form-outline">
                                                        <label class="form-label" for="form3Example1n">Ngày Thuê</label>
                                                        <input type="date" id="form3Example1n" required name="ngayThue"
                                                               class="form-control form-control-lg text-primary"/>
                                                    </div>
                                                </div>
                                            </div>


                                            <%--                                            <div class="d-md-flex justify-content-start align-items-center mb-4 py-2">--%>
                                            <%--                                                <h6 class="mb-0 me-4">Giới Tính: </h6>--%>
                                            <%--                                                <div class="form-check form-check-inline mb-0 me-4">--%>
                                            <%--                                                    <input class="form-check-input" type="radio" value="true"--%>
                                            <%--                                                           name="gender"--%>
                                            <%--                                                           id="maleGender"/>--%>
                                            <%--                                                    <label class="form-check-label" for="maleGender">Nam</label>--%>
                                            <%--                                                </div>--%>
                                            <%--                                                <div class="form-check form-check-inline mb-0 me-4">--%>
                                            <%--                                                    <input class="form-check-input" type="radio" value="false"--%>
                                            <%--                                                           name="gender"--%>
                                            <%--                                                           id="femaleGender"/>--%>
                                            <%--                                                    <label class="form-check-label" for="femaleGender">Nữ</label>--%>
                                            <%--                                                </div>--%>

                                            <%--                                            </div>--%>
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <div class="form-outline">
                                                        <label class="form-label" for="form3Example1m1">Số ĐT</label>
                                                        <input type="text" id="form3Example1m1" required
                                                               pattern="0[0-9]{9,10}"
                                                               title="SDT bắt đầu từ số 0,không chứa chữ và ký tự đặc biệt.Từ 10 đến 11 số"
                                                               placeholder="0385425443" name="sdt"
                                                               class="form-control form-control-lg"/>

                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <div class="form-outline">
                                                        <label class="form-label" for="form3Example1n1">Ghi Chú</label>
                                                        <input type="text" id="form3Example1n1" required
                                                               placeholder="Có điều hòa" name="ghiChu"
                                                               class="form-control form-control-lg"/>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6 mb-3">
                                                    <div class="form-outline">
                                                        <label class="form-label" for="form3Example1nm1">Enail</label>
                                                        <input type="text" id="form3Example1nm1" required
                                                               pattern="^\w+\w*@\w+(\.\w*)$"
                                                               title="Email không chứa ký tự đặc biệt"
                                                               placeholder="trangiagia1611@gmail.com" name="email"
                                                               class="form-control form-control-lg"/>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-3">
                                                    <label class="form-label col-xl-3" for="form3Example9">Kiểu
                                                        thuê </label>
                                                    <select name="maThanhToan" id="form3Example9" required
                                                            style="width: 100%"
                                                            class="form-select-lg col-xl-8 text-primary">
                                                        <option value="1" selected>
                                                            -†----------------------------------Năm---------------------------------†-
                                                        </option>
                                                        <option value="2">
                                                            -†----------------------------------Quý
                                                            ---------------------------------†-
                                                        </option>
                                                        <option value="3">
                                                            -†---------------------------------
                                                            Tháng--------------------------------†-
                                                        </option>
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="d-flex justify-content-center pt-3">
                                                <button type="submit" class="btn btn-primary btn-lg ms-2 text-light">
                                                    Thêm mới
                                                </button>
                                                <a href="/phongtro" class="btn btn-primary btn-lg ms-2 text-light">
                                                    Quay về </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <div class="row text-center" style="color: white; background-color: #c71212">
        <h4>Email: <i>quocdat.tran453@gmail.com</i></h4>
        <h5>SDT: <u>038-542.5443</u></h5>
    </div>
</div>
</body>
</html>
