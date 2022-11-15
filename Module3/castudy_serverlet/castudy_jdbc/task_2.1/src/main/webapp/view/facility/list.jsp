<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/9/2022
  Time: 10:44 AM
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
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css"/>
    <title>List</title>
    <style>
        * {
            font-family: "Palatino Linotype";
            box-sizing: border-box;
        }

        .header-3-icon, .header-4-icon {
            min-width: 40px;
        }

        p {
            margin: 0;
            text-indent: 20px;
        }

        .header-1 {
            justify-content: center;
        }

        .place-table {
            width: 100%;
            font-size: 15px;
            line-height: 22px;
        }

        .place-table tr {
            border-bottom: 1px solid #0d6efd
        }

        a {
            text-decoration: none;
        }

        table {
            border-collapse: collapse;
            text-indent: initial;
        }

        .row2 {
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .footer-2 {
            background-color: rgba(224, 199, 204, 0.5);
            padding: 20px;
        }

        li {
            list-style: none;
        }

        .head {
            background-color: rgba(137, 243, 114, 0.2);
            padding-top: 10px;
        }
    </style>
    <title>Facility</title>
</head>
<body>
<div class="container-fluid vh-100">
    <div class="row head" style="font-size: 25px;">
        <div class="col col-sm-6 col-md-6 col-lg-6 col-xl-3 d-flex align-items-center header-1">
            <a href="https://furamavietnam.com/vi/" class="header-1-logo"><img
                    src="https://furamavietnam.com/wp-content/uploads/2018/08/logo@2x.png" alt="logo" width="63"
                    height="100"></a>
        </div>
        <div class="col col-sm-6 col-md-6 col-lg-6 col-xl-3 d-flex align-items-center header-2">
            <a href="https://www.tripadvisor.com/Hotel_Review-g298085-d302750-Reviews-Furama_Resort_Danang-Da_Nang.html"
               target="_blank"><img
                    src="https://smartdata.tonytemplates.com/bestel/wp-content/uploads/2018/05/widget-tripadvisor-logo.png"
                    alt="logo"></a>
        </div>
        <div class="col col-sm-6 col-md-6 col-lg-6 col-xl-3 header-3 d-flex">
            <div class="header-3-icon">
                <i class='fas fa-car' style="font-size:30px;color:#055d05"></i>
            </div>
            <div class="header-3-text">
                <p style="color:red;">ĐC: 103 – 105 Đường Võ Nguyên Giáp, Phường Khuê Mỹ, Quận Ngũ hành Sơn, Tp. Đà
                    Nẵng, Việt Nam </p>
                <p style="color: red">7km từ sân bay quốc tế đà nẵng</p>
            </div>
        </div>
        <div class="col col-sm-6 col-md-6 col-lg-6 col-xl-3 header-4">
            <div class="d-flex">
                <div class="header-4-icon">
                    <i class='fas fa-phone-volume' style="font-size:30px;color:#055d05"></i>
                </div>
                <div class="header-4-text">
                    <p style="color:red;">038-542-5443</p>
                </div>
            </div>
            <div class="d-flex">
                <div class="header-4-icon">
                    <i class="fa fa-envelope" style="font-size:30px;color:#055d05"></i>
                </div>
                <div class="header-4-text">
                    <p style="color:red;">quocdat.tran453@gmail.com</p>
                </div>
            </div>
            <div class="d-flex">
                <div class="header-4-icon">
                    <i class="fas fa-user-check" style="font-size:30px;color:#055d05"></i>
                </div>
                <div class="header-4-text">
                    <p style="color:red; font-size: larger"><b>Trần Quốc Đạt-C0722G1</b></p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-dark bg-success" style="font-size: 25px;">
            <div class="container-fluid">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/view/home.jsp"><i
                                class="fa fa-home"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/employee">Nhân
                            Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/customer">Khách Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/facility">Dịch
                            Vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/contract">Hợp
                            Đồng</a>
                    </li>
                </ul>
                <form class="d-flex" action="/facility?action=search" method="post">
                    <input class="form-control me-2" type="search" name="search" placeholder="TrầnGiaGia"
                           aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Tìm Kiếm</button>
                </form>
            </div>
        </nav>
    </div>
    <div class="row content text-center"
         style="background-image: url(https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg);">
        <p style="font-size: 70px;color: rgb(245,5,5)">List Facility</p>
        <div class="dropdown">
            <button class="btn btn-primary dropdown-toggle" type="button" data-bs-toggle="dropdown"
                    aria-expanded="false">
                Thêm Mới Dịch Vụ
            </button>
            <ul class="dropdown-menu dropdown-menu-primary" style="padding: 0">
                <li style="margin-bottom: 3px">
                    <button type="button" class="btn btn-primary col-12"
                            data-bs-toggle="modal"
                            data-bs-target="#addVilla">Villa
                    </button>
                </li>
                <li style="margin-bottom: 3px">
                    <button type="button" class="btn btn-primary col-12"
                            data-bs-toggle="modal"
                            data-bs-target="#addHouse">House
                    </button>
                </li>
                <li>
                    <button type="button" class="btn btn-primary col-12"
                            data-bs-toggle="modal"
                            data-bs-target="#addRoom">Room
                    </button>
                </li>
            </ul>
        </div>
        <h2 style="text-align: center;color: red"><c:if test="${mess!=null}">
            <span>${mess}</span>
        </c:if></h2>
        <div class="row table-content">
            <div class="col col-lg-1 col-xl-1"></div>
            <div class="col col-lg-10 col-xl-10">
                <div class="row">
                    <table id="tableCustomer" class="table table-striped table-bordered table-primary text-center"
                           style="width:100%">
                        <thead>
                        <tr>
                            <th>STT</th>
                            <th scope="col" hidden>id</th>
                            <th scope="col">Tên dịch vụ</th>
                            <th scope="col">Diện tích sử dụng</th>
                            <th scope="col">Chi phí thuê</th>
                            <th scope="col">Số lượng người tối đa</th>
                            <th scope="col">Tiêu chuẩn phòng</th>
                            <th scope="col">Mô tả tiện nghi khác</th>
                            <th scope="col">Diện tích hồ bơi</th>
                            <th scope="col">Số tầng</th>
                            <th scope="col">Dịch vụ miễn phí đi kèm</th>
                            <th scope="col">Tên kiểu thuê</th>
                            <th scope="col">Loại dịch vụ</th>
                            <th scope="col">Cập nhật</th>
                            <th scope="col">Xóa</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="facility" items="${facilityList}" varStatus="stt">
                            <tr>
                                <th>${stt.count}</th>
                                <td hidden>${facility.getId()}</td>
                                <td>${facility.getName()}</td>
                                <td>${facility.getArea()}</td>
                                <td>${facility.getCost()}</td>
                                <td>${facility.getMaxPeople()}</td>
                                <td>${facility.getStandardRoom()}</td>
                                <td>${facility.getDescriptionOtherConvenience()}</td>
                                <td>${facility.getPoolArea()}</td>
                                <td>${facility.getNumberOfFloors()}</td>
                                <td>${facility.getFacilityFree()}</td>
                                <td>${facility.getRentTypeName()}</td>
                                <td>${facility.getFacilityTyeName()}</td>

                                <td>
                                    <button type="button"
                                            onclick="idEdit('${facility.getId()}','${facility.getName()}','${facility.getArea()}','${facility.getCost()}','${facility.getMaxPeople()}','${facility.getStandardRoom()}','${facility.getDescriptionOtherConvenience()}','${facility.getPoolArea()}','${facility.getNumberOfFloors()}','${facility.getFacilityFree()}','${facility.getRentTypeId()}','${facility.getFacilityTypeId()}')"
                                            class="btn btn-lg btn-primary" data-bs-toggle="modal"
                                            data-bs-target="#edit"> Cập Nhật
                                    </button>
                                </td>
                                <td>
                                    <button type="button"
                                            onclick="idRemove('${facility.getId()}','${facility.getName()}')"
                                            class="btn btn-lg btn-danger" data-bs-toggle="modal"
                                            data-bs-target="#exampleRemove"> Xóa
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col col-xl-1">

            </div>
        </div>
    </div>
    <div class="row footer bg-success">
        <div class="container" style="padding-top: 15px">
            <div class="row row1">
                <div class="col col-xl-1"></div>
                <div class="col col-sm-12 col-md-12 col-lg-12 col-xl-4 footer-2">
                    <p style="font-size: 30px;padding-bottom: 5px;color: gold"><b>Hướng dẫn chuyến đi</b></p>
                    <p style="font-size: 20px;padding-bottom: 5px;">"Khu nghỉ dưỡng Furama là cơ sở hàng đầu để khám
                        phá một
                        trong những điểm đến hấp dẫn nhất Châu
                        Á. Chỉ cách Đà Nẵng một quãng lái xe ngắn là bốn Di sản Văn hóa Thế giới được UNESCO công
                        nhận:"
                    </p>
                    <p style="font-size: 30px;padding-bottom: 5px;color: gold"><b>Địa điểm</b></p>
                    <table class="place-table">
                        <tbody>
                        <tr>
                            <td>1.</td>
                            <td>Cố Đô Huế</td>
                            <td style="text-align: right"><span>2 tiếng</span></td>
                        </tr>
                        <tr>
                            <td>2.</td>
                            <td>Phố Cổ Hội An</td>
                            <td style="text-align: right"><span>30 phút</span></td>
                        </tr>
                        <tr>
                            <td>3.</td>
                            <td>Thánh Địa Mỹ Sơn</td>
                            <td style="text-align: right"><span>90 phút</span></td>
                        </tr>
                        <tr>
                            <td>4.</td>
                            <td>Động Phong Nha</td>
                            <td style="text-align: right"><span>3 tiếng</span></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col col-xl-1"></div>
                <div class="col col-sm-12 col-md-12 col-lg-12 col-xl-6">
                    <div class="row">
                        <div class="col col-xl-5" style="color: gold">
                            <ul>
                                <li><a style="color: gold;font-size: 20px;"
                                       href="https://furamavietnam.com/vi/furama-resort-danang-rack-rate/">1.Giá
                                    Công bố</a>
                                </li>
                                <li><a style="color: gold;font-size: 20px;"
                                       href="https://furamavietnam.com/vi/lifestyle-blog/">2.Lifestyle
                                    Blog</a></li>
                                <li><a style="color: gold;font-size: 20px"
                                       href="https://furamavietnam.com/vi/work-with-us/">3.Tuyển
                                    Dụng</a></li>
                                <li><a style="color: gold;font-size: 20px"
                                       href="https://furamavietnam.com/vi/contact/">4.Liên
                                    Hệ</a></li>
                            </ul>
                        </div>
                        <div class="col col-xl-7">
                            <img style="width: 80%; "
                                 src="https://phulong.com/UploadFiles/Images/FURAMA%2020%20NAM.jpg"
                                 alt="">
                        </div>
                    </div>
                </div>
            </div>
            <div class="row row2">
                <div class="col col-sm-12 col-md-12 col-lg-12 col-xl-8 ">
                    <img style="width: 80%"
                         src="https://furamavietnam.com/wp-content/uploads/2019/02/Ariyana-Tourism-Complex-02-2.png"
                         alt="">
                </div>
                <div class="col col-xl-4"><p> © 2018 Furama Resort Danang. </p></div>
            </div>
        </div>
    </div>
</div>


<%---------------MODAL ADD--------------%>
<%--ADD VILLA--%>
<div class="modal fade" id="addVilla" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header-xl">
                <h1 style="text-align: center;color: blue; padding-top: 5px" class="modal-title fs-5">THÊM MỚI
                    VILLA</h1>
            </div>
            <form action="/facility?action=add" method="post">
                <div class="modal-body-xl">
                    <div class="container">
                        <table class="table table-primary" style="width: 100%;">
                            <tr>
                                <td><label for="tdv">Tên Dịch vụ</label></td>
                                <td><input required name="name" type="text" style="width: 100%" id="tdv"></td>
                            </tr>
                            <tr>
                                <td><label for="dtsd">Diện tích sử dụng</label></td>
                                <td><input required name="area" type="text" style="width: 100%" id="dtsd"></td>
                            </tr>
                            <tr>
                                <td><label for="cpt">Chi Phí Thuê</label></td>
                                <td><input required name="cost" type="text" style="width: 100%" id="cpt"></td>
                            </tr>
                            <tr>
                                <td><label for="slntd">Số lượng người tối đa</label></td>
                                <td><input required name="maxPeople" type="text" style="width: 100%" id="slntd"></td>
                            </tr>
                            <tr>
                                <td><label for="tcp">Tiêu chuẩn phòng</label></td>
                                <td><input required name="standardRoom" type="text" style="width: 100%" id="tcp"></td>
                            </tr>
                            <tr>
                                <td><label for="tnk">Tiện nghi khác</label></td>
                                <td><input required name="descriptionOtherConvenience" type="text" style="width: 100%" id="tnk">
                                </td>
                            </tr>
                            <tr>
                                <td><label for="dthb">Diện tích hồ bơi</label></td>
                                <td><input required name="poolArea" type="text" style="width: 100%" id="dthb"></td>
                            </tr>
                            <tr>
                                <td><label for="st">Số tầng</label></td>
                                <td><input required name="numberOfFloors" type="text" style="width: 100%" id="st"></td>
                            </tr>
                            <tr>
                                <td hidden><label for="dvmpdk">Dịch vụ miễn phí đi kèm</label></td>
                                <td hidden><input name="facilityFree" type="text" style="width: 100%" id="dvmpdk"></td>
                            </tr>

                            <tr>
                                <td><label for="kt">Kiểu thuê</label></td>
                                <td><select required name="rentTypeId" id="kt">
                                    <option value="1" selected>-----†------ Năm -----†----</option>
                                    <option value="2">-----†------ Tháng -----†----</option>
                                    <option value="3">-----†------ Ngày -----†----</option>
                                    <option value="4">-----†------ Giờ -----†----</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td><label for="ldv">Loại dịch vụ</label></td>
                                <td><select required name="facilityTypeId" id="ldv">
                                    <option value="1" selected>-----†------ Villa -----†----</option>
                                </select></td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="/facility" class="btn btn-primary btn-lg ms-2 text-light">
                            Quay về </a>
                        </button>
                        <button type="submit" class="btn btn-primary btn-lg ms-2 text-light">Thêm mới</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--ADDHOUSE--%>
<div class="modal fade" id="addHouse" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header-xl">
                <h1 style="text-align: center;color: blue; padding-top: 5px" class="modal-title fs-5">THÊM MỚI
                    HOUSE</h1>
            </div>
            <form action="/facility?action=add" method="post">
                <div class="modal-body-xl">
                    <div class="container">
                        <table class="table table-primary" style="width: 100%;">
                            <tr>
                                <td><label for="tdv1">Tên Dịch vụ</label></td>
                                <td><input required name="name" type="text" style="width: 100%" id="tdv1"></td>
                            </tr>
                            <tr>
                                <td><label  for="dtsd1">Diện tích sử dụng</label></td>
                                <td><input required name="area" type="text" style="width: 100%" id="dtsd1"></td>
                            </tr>
                            <tr>
                                <td><label for="cpt1">Chi Phí Thuê</label></td>
                                <td><input required name="cost" type="text" style="width: 100%" id="cpt1"></td>
                            </tr>
                            <tr>
                                <td><label for="slntd1">Số lượng người tối đa</label></td>
                                <td><input required name="maxPeople" type="text" style="width: 100%" id="slntd1"></td>
                            </tr>
                            <tr>
                                <td><label for="tcp1">Tiêu chuẩn phòng</label></td>
                                <td><input required name="standardRoom" type="text" style="width: 100%" id="tcp1"></td>
                            </tr>
                            <tr>
                                <td><label for="tnk1">Tiện nghi khác</label></td>
                                <td><input required name="descriptionOtherConvenience" type="text" style="width: 100%" id="tnk1">
                                </td>
                            </tr>
                            <tr>
                                <td hidden><label for="dthb1">Diện tích hồ bơi</label></td>
                                <td hidden><input name="poolArea" type="text" style="width: 100%" id="dthb1"
                                                  value="${0}"></td>
                            </tr>
                            <tr>
                                <td><label for="st1">Số tầng</label></td>
                                <td><input required name="numberOfFloors" type="text" style="width: 100%" id="st1"></td>
                            </tr>
                            <tr>
                                <td hidden><label for="dvmpdk1">Dịch vụ miễn phí đi kèm</label></td>
                                <td hidden><input name="facilityFree" type="text" style="width: 100%" id="dvmpdk1"></td>
                            </tr>

                            <tr>
                                <td><label for="kt1">Kiểu thuê</label></td>
                                <td><select required name="rentTypeId" id="kt1">
                                    <option value="1" selected>-----†------ Năm -----†----</option>
                                    <option value="2">-----†------ Tháng -----†----</option>
                                    <option value="3">-----†------ Ngày -----†----</option>
                                    <option value="4">-----†------ Giờ -----†----</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td><label for="ldv1">Loại dịch vụ</label></td>
                                <td><select required name="facilityTypeId" id="ldv1">
                                    <option value="2" selected>-----†------ House -----†----</option>
                                </select></td>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="/facility" class="btn btn-primary btn-lg ms-2 text-light">
                            Quay về </a>
                        </button>
                        <button type="submit" class="btn btn-primary btn-lg ms-2 text-light">Thêm mới</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--ADDROOM--%>
<div class="modal fade" id="addRoom" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header-xl">
                <h1 style="text-align: center;color: blue; padding-top: 5px" class="modal-title fs-5">THÊM MỚI
                    ROOM</h1>
            </div>
            <form action="/facility?action=add" method="post">
                <div class="modal-body-xl">
                    <div class="container">
                        <table class="table table-primary" style="width: 100%;">
                            <tr>
                                <td><label for="tdv2">Tên Dịch vụ</label></td>
                                <td><input required name="name" type="text" style="width: 100%" id="tdv2"></td>
                            </tr>
                            <tr>
                                <td><label for="dtsd2">Diện tích sử dụng</label></td>
                                <td><input required name="area" type="text" style="width: 100%" id="dtsd2"></td>
                            </tr>
                            <tr>
                                <td><label for="cpt2">Chi Phí Thuê</label></td>
                                <td><input name="cost" required type="text" style="width: 100%" id="cpt2"></td>
                            </tr>
                            <tr>
                                <td><label for="slntd2">Số lượng người tối đa</label></td>
                                <td><input name="maxPeople" required type="text" style="width: 100%" id="slntd2"></td>
                            </tr>
                            <tr>
                                <td hidden><label for="tcp2">Tiêu chuẩn phòng</label></td>
                                <td hidden><input name="standardRoom" type="text" style="width: 100%" id="tcp2"></td>
                            </tr>
                            <tr>
                                <td hidden><label for="tnk2">Tiện nghi khác</label></td>
                                <td hidden><input name="descriptionOtherConvenience" type="text" style="width: 100%"
                                                  id="tnk2">
                                </td>
                            </tr>
                            <tr>
                                <td hidden><label for="dthb2">Diện tích hồ bơi</label></td>
                                <td hidden><input name="poolArea" type="text" style="width: 100%" id="dthb2"
                                                  value="${0}"></td>
                            </tr>
                            <tr>
                                <td hidden><label for="st2">Số tầng</label></td>
                                <td hidden><input name="numberOfFloors" type="text" style="width: 100%" id="st2"
                                                  value="${0}"></td>
                            </tr>
                            <tr>
                                <td><label for="dvmpdk2">Dịch vụ miễn phí đi kèm</label></td>
                                <td><input required name="facilityFree" type="text" style="width: 100%" id="dvmpdk2"></td>
                            </tr>

                            <tr>
                                <td><label for="kt2">Kiểu thuê</label></td>
                                <td><select required name="rentTypeId" id="kt2">
                                    <option value="1" selected>-----†------ Năm -----†----</option>
                                    <option value="2">-----†------ Tháng -----†----</option>
                                    <option value="3">-----†------ Ngày -----†----</option>
                                    <option value="4">-----†------ Giờ -----†----</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td><label for="ldv2">Loại dịch vụ</label></td>
                                <td>
                                    <select required name="facilityTypeId" id="ldv2">
                                        <option value="3" selected>-----†------ Room -----†----</option>
                                    </select>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="/facility" class="btn btn-primary btn-lg ms-2 text-light">
                            Quay về </a>
                        </button>
                        <button type="submit" class="btn btn-primary btn-lg ms-2 text-light">Thêm mới</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--Function DELETE--%>
<script>
    function idRemove(id, name) {
        document.getElementById("idInput").value = id;
        document.getElementById("name").innerText = name;
    }
</script>

<%----------------MODAL EDIT-----------%>

<div class="modal fade" id="edit" tabindex="-1"
     aria-labelledby="exampleModalLabel" aria-hidden="true"
     data-bs-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header-xl">
                <h1 style="text-align: center;color: blue; padding-top: 5px" class="modal-title fs-5">CẬP NHẬT
                    FACILITY</h1>
            </div>
            <form action="/facility?action=edit" method="post">
                <div class="modal-body-xl">
                    <div class="container">
                        <table class="table table-primary" style="width: 100%;">
                            <tr>
                                <td hidden><label for="update_id">ID</label></td>
                                <td hidden><input name="id" type="text" style="width: 100%" id="update_id" value="">
                                </td>
                            </tr>
                            <tr>
                                <td><label for="update_tdv">Tên Dịch vụ</label></td>
                                <td><input name="name" type="text" style="width: 100%" id="update_tdv" value=""></td>
                            </tr>
                            <tr>
                                <td><label for="update_dtsd">Diện tích sử dụng</label></td>
                                <td><input name="area" type="text" style="width: 100%" id="update_dtsd" value=""></td>
                            </tr>
                            <tr>
                                <td><label for="update_cpt">Chi Phí Thuê</label></td>
                                <td><input name="cost" type="text" style="width: 100%" id="update_cpt" value=""></td>
                            </tr>
                            <tr>
                                <td><label for="update_slntd">Số lượng người tối đa</label></td>
                                <td><input name="maxPeople" type="text" style="width: 100%" id="update_slntd" value="">
                                </td>
                            </tr>
                            <tr id="standardRoom">
                                <td><label for="update_tcp">Tiêu chuẩn phòng</label></td>
                                <td><input name="standardRoom" type="text" style="width: 100%" id="update_tcp"
                                           value="">
                                </td>
                            </tr>
                            <tr id="descriptionOtherConvenience">
                                <td><label for="update_tnk">Tiện nghi khác</label></td>
                                <td><input name="descriptionOtherConvenience" type="text" style="width: 100%"
                                           id="update_tnk" value="">
                                </td>
                            </tr>
                            <tr id="poolArea">
                                <td><label for="update_dthb">Diện tích hồ bơi</label></td>
                                <td>
                                    <input name="poolArea" type="text" style="width: 100%" id="update_dthb"
                                           value="">
                                </td>
                            </tr>
                            <tr id="numberOfFloors">
                                <td><label for="update_st">Số tầng</label></td>
                                <td><input name="numberOfFloors" type="text" style="width: 100%" id="update_st"
                                           value=""></td>
                            </tr>
                            <tr id="facilityFree">
                                <td><label for="update_dvmpdk">Dịch vụ miễn phí đi kèm</label></td>
                                <td><input name="facilityFree" type="text" style="width: 100%" id="update_dvmpdk"
                                           value=""></td>
                            </tr>
                            <tr>
                                <td><label for="update_kt">Kiểu thuê</label></td>
                                <td><select name="rentTypeId" id="update_kt">
                                    <option value="1">-----†------ Năm -----†----</option>
                                    <option value="2">-----†------ Tháng -----†----</option>
                                    <option value="3">-----†------ Ngày -----†----</option>
                                    <option value="4">-----†------ Giờ -----†----</option>
                                </select></td>
                            </tr>
                            <tr>
                                <td><label for="update_ldv">Loại dịch vụ</label></td>
                                <td><input type="text" name="facilityTypeId" id="update_ldv" readonly>
<%--                                    <select name="facilityTypeId" id="update_ldv">--%>
<%--                                    <option value="1">-----†------ Villa -----†----</option>--%>
<%--                                    <option value="2">-----†------ House -----†----</option>--%>
<%--                                    <option value="3">-----†------ Room -----†----</option>--%>
<%--                                </select>--%>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="modal-footer">
                        <a href="/facility" class="btn btn-primary btn-lg ms-2 text-light">
                            Quay về </a>
                        </button>
                        <button type="submit" class="btn btn-primary btn-lg ms-2 text-light">Cập nhật</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%----------------MODAL EDIT (SỬA)--------------%>
>
<script>
    function idEdit(id, name, area, cost, maxPeople, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree, rentTypeId, facilityTypeId) {
        document.getElementById("update_id").value = id;
        document.getElementById("update_tdv").value = name;
        document.getElementById("update_dtsd").value = area;
        document.getElementById("update_cpt").value = cost;
        document.getElementById("update_slntd").value = maxPeople;
        document.getElementById("update_tcp").value = standardRoom;
        document.getElementById("update_tnk").value = descriptionOtherConvenience;
        document.getElementById("update_dthb").value = poolArea;
        document.getElementById("update_st").value = numberOfFloors;
        document.getElementById("update_dvmpdk").value = facilityFree;
        document.getElementById("update_kt").value = rentTypeId;
        document.getElementById("update_ldv").value = facilityTypeId;
        if(facilityTypeId==1){
            document.getElementById("update_ldv").value ="Villa"
        }
        if(facilityTypeId==2){
            document.getElementById("update_ldv").value ="House"
        }
        if(facilityTypeId==3){
            document.getElementById("update_ldv").value ="Room"
        }
        // facilityTypeId = document.getElementById("update_ldv")
        if (facilityTypeId == 2 || facilityTypeId == 1) {
            document.getElementById("facilityFree").style.display = "none";
        }
        if (facilityTypeId == 2 || facilityTypeId == 3) {
            document.getElementById("poolArea").style.display = "none";
        }
        if (facilityTypeId == 3) {
            document.getElementById("numberOfFloors").style.display = "none";
        }
        if (facilityTypeId == 3) {
            document.getElementById("descriptionOtherConvenience").style.display = "none";
        }if (facilityTypeId == 3) {
            document.getElementById("standardRoom").style.display = "none";
        }
    }

</script>


<%--MODAL DELETE--%>
<div class="modal fade" id="exampleRemove" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body">
                <p style="font-size: 15px;color: blue;text-align: center">Bạn có chắc muốn xóa DỊCH VỤ này???</p>
                <P id="name" style="font-size: 25px;color: red;text-align: center"></P>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                </button>
                <form action="/facility?action=remove" method="post">
                    <input type="hidden" name="id" id="idInput">
                    <button class="btn btn-primary">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
</html>
