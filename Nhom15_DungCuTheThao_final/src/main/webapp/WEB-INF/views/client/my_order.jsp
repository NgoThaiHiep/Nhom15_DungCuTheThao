
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Site Metas -->
        <meta name="keywords" content="" />
        <meta name="description" content="" />
        <meta name="author" content="" />

        <link rel="apple-touch-icon" href="../resource/client/img/runningman.png">
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">

        <link rel="stylesheet" href="../resource/client/css/bootstrap.min.css">
        <link rel="stylesheet" href="../resource/client/css/templatemo.css">
        <link rel="stylesheet" href="../resource/client/css/custom.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="../resource/client/css/fontawesome.min.css">

        <!-- slider stylesheet -->
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.1.3/assets/owl.carousel.min.css" />

        <!-- bootstrap core css -->
        <link rel="stylesheet" type="text/css" href="../resource/client/css/bootstrap.css" />

        <!-- fonts style -->
        <link href="https://fonts.googleapis.com/css?family=Baloo+Chettan|Dosis:400,600,700|Poppins:400,600,700&display=swap"
              rel="stylesheet" />
        <!-- Custom styles for this template -->
        <link href="../resource/client/css/style.css" rel="stylesheet" />
        <!-- responsive style -->
        <link href="../resource/client/css/responsive.css" rel="stylesheet" />
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="../resource/client/css/style1.css">

        <link rel="stylesheet" href="../resource/client/css/templatemo.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="../resource/client/css/fontawesome.min.css">

        <!-- Slick -->
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick-theme.min.css">

    </head>
    <body id="home">
        <div class="wrapper">
            <!--header-->
            <%@include file="common/header.jsp"%>

            <div class="container">
                <br>
                <div class="row dropup">
                    <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px; margin: auto;">
                        <a href="profile" class="dropdown-toggle nav-link">Đơn hàng của tôi</a>
                    </div>
                </div>          
                <div class="row">
                    <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px; margin: auto;">
                        <table class="table" style="margin: auto;">
                            <tr>
                                <th>Mã đơn hàng</th>
                                <th>Tổng tiền</th>
                                <th>Ngày</th>
                                <th>Trạng thái</th>
                                <th>Chi tiết đơn hàng</th>
                            </tr>
                            <tbody>
                                <c:forEach items="${orders}" var="order">
                                    <tr>
                                        <td>${order.orderId}</td>
                                        <td style="color: red; ">${order.totalPrice} VNĐ</td>
                                        <td>${order.purchaseDate}</td>
                                        <td><c:if test="${order.status == 'Chưa duyệt'}">
                                                <span style="color: red; font-weight: bold;">${order.status}</span>
                                            </c:if> <c:if test="${order.status eq 'Đã duyệt'}">
                                                <span style="color: #00cc00; font-weight: bold;">${order.status}</span>
                                            </c:if></td>
                                        <td><a href="order-details?orderId=${order.orderId}"
                                               style="margin-top: -8px" class="nav-link">Xem chi tiết</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div align="center">
                            <c:if test="${empty orders}">
                                Bạn chưa có đơn hàng nào
                            </c:if>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px; margin: auto;">
                        <a href="profile" class="dropdown-toggle nav-link">Thông tin nhận hàng</a>
                    </div>
                </div>
                <br>
            </div>

            <!--footer-->
            <%@include file="common/footer.jsp"%>
        </div>
    </body>
</html>
