<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/7/2022
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
            crossorigin="anonymous"></script>

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
                           href="http://localhost:63342/Module3/castudy_module3/task_1.1/castudy_furama_web.html?_ijt=14lb68g1bona255ovippf0bl8n&_ij_reload=RELOAD_ON_SAVE"><i
                                class="fa fa-home"></i></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:63342/castudy_module3/task_1.5/list_contract.html?_ijt=ickg1dpcvc3c2c5hs6q7430acu&_ij_reload=RELOAD_ON_SAVE">Nhân
                            Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="/customer">Khách Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:63342/castudy_module3/task_1.5/list_contract.html?_ijt=ickg1dpcvc3c2c5hs6q7430acu&_ij_reload=RELOAD_ON_SAVE">Dịch
                            Vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page"
                           href="http://localhost:63342/castudy_module3/task_1.5/list_contract.html?_ijt=ickg1dpcvc3c2c5hs6q7430acu&_ij_reload=RELOAD_ON_SAVE">Hợp
                            Đồng</a>
                    </li>
                </ul>
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="TrầnGiaGia" aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <div class="row content text-center"
         style="background-image: url(https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg)">
        <p style="font-size: 70px;color: rgb(245,5,5)">List Customer</p>
        <h2 style="text-align: center;color: red"><c:if test="${mess!=null}">
            <span>${mess}</span>
        </c:if></h2>
        <div class="row table-content">
            <div class="col col-lg-1 col-xl-1"></div>
            <div class="col col-lg-10 col-xl-10">
                <table class="table table-hover table-success table-striped">

                    <tr>
                        <th>STT</th>
                        <th hidden>ID</th>
                        <th>Tên</th>
                        <th>Ngày sinh</th>
                        <th>Giới tính</th>
                        <th >Số CMND</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <th >Địa chỉ</th>
                        <th>Loại khách</th>
                        <th>Cập nhật</th>
                        <th>Xóa</th>
                    </tr>

                    <c:forEach var="customer" items="${customerList}" varStatus="stt">
                        <tr>
                            <th scope="row">${stt.count}</th>
                            <td hidden>${customer.getId()}</td>
                            <td>${customer.getName()}</td>
                            <td>${customer.getBirthday()}</td>
                            <td>${customer.isGender() == true ? "Nam" : "Nữ"}</td>
                            <td>${customer.getIdCard()}</td>
                            <td>${customer.getPhoneNumber()}</td>
                            <td>${customer.getEmail()}</td>
                            <td>${customer.getAddress()}</td>
                            <td>${customer.getCustomerTypeId()}</td>
                            <td>
                                <a href="/customer?action=edit&id=${customer.id}" class="btn btn-primary btn-lg ms-2 text-light">Cập nhật</a>

<%--                                <button class="btn btn-primary" type="button" data-bs-toggle="modal"--%>
<%--                                        data-bs-target="#exampleModalEdit"> Cập Nhật--%>
<%--                                </button>--%>
                            </td>
                            <td>
                                <button type="button" onclick="idRemove('${customer.getId()}','${customer.getName()}')" class="btn btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#exampleRemove">
                                    Xóa
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col col-xl-1">
                <a href="/customer?action=add"><button class="btn btn-primary" type="button"> Thêm mới khách hàng
                </button></a>
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
<div class="modal fade" id="exampleRemove" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">DELETE</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Bạn có chắc muốn xóa khách hàng này???
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel
                </button>
                <form action="/customer?action=remove" method="post">
                    <input type="hidden" name="id" id="idInput">
                    <button class="btn btn-primary">Xóa</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    function idRemove(id,name) {
        document.getElementById("idInput").value=id;
    }
</script>
</body>
</html>
