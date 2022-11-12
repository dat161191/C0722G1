<%--
  Created by IntelliJ IDEA.
  User: Laptop T&T
  Date: 11/7/2022
  Time: 9:43 PM
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

    <title>Home</title>
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
                <form class="d-flex">
                    <input class="form-control me-2" type="search" placeholder="TrầnGiaGia" aria-label="Search">
                    <button class="btn btn-outline-light" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <div class="row content">
        <div class="col col-xl-3" style="color: red ;padding-top: 20px;">
            <p style="font-size: 25px;">KHU NGHỈ DƯỠNG ĐẲNG CẤP THẾ GIỚI, FURAMA ĐÀ NẴNG, NỔI TIẾNG LÀ KHU NGHỈ DƯỠNG ẨM
                THỰC TẠI VIỆT NAM.</p>
            <p style="font-size: 20px;">Hướng ra bãi biển Đà Nẵng trải dài cát trắng, Furama Resort Đà Nẵng là cửa ngõ
                đến với 3 di sản văn hoá
                thế giới: Hội An (20 phút), Mỹ Sơn (90 phút) và Huế (2 tiếng. 196 phòng hạng sang cùng với 70 căn biệt
                thự từ hai đến bốn phòng ngủ có hồ bơi riêng đều được trang trí trang nhã, theo phong cách thiết kế
                truyền thống của Việt Nam và kiến trúc thuộc địa của Pháp, biến Furama thành khu nghỉ dưỡng danh giá
                nhất tại Việt Nam – vinh dự được đón tiếp nhiều người nổi tiếng, giới hoàng gia, chính khách, ngôi sao
                điện ảnh và các nhà lãnh đạo kinh doanh quốc tế.</p>
            <p style="font-size: 20px;">Khu nghỉ dưỡng có 196 phòng được thiết kế theo phong cách truyền thống Việt Nam
                kết hợp với phong cách
                Pháp, 2 tòa nhà 4 tầng có hướng nhìn ra biển, nhìn ra hồ bơi trong xanh và những khu vườn nhiệt đới xanh
                tươi mát. Ngoài ra, khu nghỉ dưỡng Furama còn cung cấp các liệu pháp spa, phòng xông hơi ướt, phòng
                xông hơi khô, dịch vụ mát-xa cạnh hồ bơi, các dịch vụ thể thao dưới nước và các lớp tập yoga và
                Thái Cực Quyền trên bãi biển.</p>
        </div>
        <div class="col col-xl-9">
            <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"
                            aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://furamavietnam.com/wp-content/uploads/2019/07/Vietnam_Danang_Furama_Resort_Exterior_Ocean-Pool-6.jpg"
                             class="d-block w-100" style="height: 800px" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <p style="color: gold;font-size: 50px;"><b>KHU NGHĨ DƯỠNG ẨM THỰC</b></p>
                            <p style="color: gold;font-size: 50px;"><b>TỌA LẠC TẠI BỜ BIỂN ĐÀ NẴNG</b></p>
                            <p style="color: gold;font-size: 50px;"><b>MỘT TRONG 6 BỜ BIỂN ĐẸP NHẤT THẾ GIỚI</b></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior-Furama-girl-with-pink-hat.jpg"
                             class="d-block w-100" style="height: 800px" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <p style="color: gold;font-size: 50px;"><b>KHU NGHĨ DƯỠNG ẨM THỰC</b></p>
                            <p style="color: gold;font-size: 50px;"><b>TỌA LẠC TẠI BỜ BIỂN ĐÀ NẴNG</b></p>
                            <p style="color: gold;font-size: 50px;"><b>MỘT TRONG 6 BỜ BIỂN ĐẸP NHẤT THẾ GIỚI</b></p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img src="https://furamavietnam.com/wp-content/uploads/2018/07/Vietnam_Danang_Furama_Resort_Exterior_Courtyard.jpg"
                             class="d-block w-100" style="height: 800px;" alt="...">
                        <div class="carousel-caption d-none d-md-block">
                            <p style="color: gold;font-size: 50px;"><b>KHU NGHĨ DƯỠNG ẨM THỰC</b></p>
                            <p style="color: gold;font-size: 50px;"><b>TỌA LẠC TẠI BỜ BIỂN ĐÀ NẴNG</b></p>
                            <p style="color: gold;font-size: 50px;"><b>MỘT TRONG 6 BỜ BIỂN ĐẸP NHẤT THẾ GIỚI</b></p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
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
    </div></div>
</body>
</html>
