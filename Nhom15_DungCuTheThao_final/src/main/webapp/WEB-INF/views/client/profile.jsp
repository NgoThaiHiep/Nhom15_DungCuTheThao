
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

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="../resource/client/css/style1.css">

        <link rel="stylesheet" href="../resource/client/css/templatemo.css">

        <!-- Load fonts style after rendering the layout styles -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="../resource/client/css/fontawesome.min.css">

        <!-- Slick -->
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick.min.css">
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick-theme.css">
        <link rel="stylesheet" type="text/css" href="../resource/client/css/slick-theme.min.css">
        <style>
            #s{
                color: red;
                font-style: italic;
            }
        </style>
    </head>
    <body>
        <!--header-->
        <%@include file="common/header.jsp"%>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px; margin: auto;">
                    <a href="my-order" class="dropdown-toggle nav-link">Đơn hàng của tôi</a>
                </div>
            </div>
            <br>
            <div class="row dropup">
                <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px; margin: auto;">
                    <a href="my-order" class="dropdown-toggle nav-link">Thông tin nhận hàng</a>
                </div>
            </div>
            <div class="row">
                <div class="col-10" style="border: 1px solid rgb(231, 230, 230); border-radius: 10px 10px; margin: auto;">
                    <div class="row" style="margin-top: 10px;">
                        <div class="col-5" style="margin-left: 10px;">
                            <h5><b>Thông tin cá nhân</b></h5>
                            <c:if test="${messageError != null}">
                                <span style="width: 90%; margin-top: 15px; font-size: 15px; color: red; font-weight: bold;">${messageError}</span>
                            </c:if>
                            <c:if test="${messageSuccess != null}">
                                <span style="width: 100%; margin-top: 15px; font-size: 15px; color: green; font-weight: bold;">${messageSuccess}</span>
                            </c:if>
                            <input type="hidden" name="userId" value="${sessionScope.user.userId}" />
                            <form action="profile-update" enctype="multipart/form-data" method="post">
                                <div>
                                    <label for="">Email <span id="s">(*)</span></label>
                                    <input type="text" class="form-control" name="email" readonly="readonly" required="required" 
                                           value="${sessionScope.user.email}">
                                </div>
                                <div>
                                    <label for="">Họ và tên <span id="s">(*)</span></label>
                                    <input type="text" class="form-control" name="fullname" value="${sessionScope.user.fullname}">
                                </div>
                                <div>
                                    <label for="">Số điện thoại <span id="s">(*)</span></label>
                                    <input type="text" class="form-control" name="phone"
                                           required="required" value="${sessionScope.user.phone}">
                                </div>
                                <div>
                                    <label for="">Địa chỉ <span id="s">(*)</span></label>
                                    <input type="text" class="form-control" name="address"
                                           required="required" value="${sessionScope.user.address}">
                                </div>
                                <div>
                                    <label for="">Ảnh đại diện <span id="s">(*)</span></label>
                                    <c:if test="${user.avatar != null}">
                                        <img src="data:image/jpg;base64,${user.avatar}" alt="Avatar"
                                             class="rounded-circle" style="width: 15%;">
                                    </c:if> 
                                    <input type="file" name="avatarfile"/>
                                </div>
                                <button type="submit" class="btn btn-info" style="margin-top: 15px; margin-bottom: 20px;">Cập nhật</button>
                            </form>
                        </div>
                        <div class="col-5" style="margin-left: 130px;">
                            <h5><b>Thay đổi mật khẩu</b></h5>
                            <form action="change-password" method="post">
                                <div>
                                    <label for="">Mật khẩu cũ <span id="s">(*)</span></label>
                                    <input type="password" class="form-control" name="oldpassword" required="required">
                                </div>
                                <div>
                                    <label for="">Mật khẩu mới <span id="s">(*)</span></label>
                                    <input type="password" class="form-control" name="newpassword" required="required">
                                </div>
                                <div>
                                    <label for="">Xác nhận mật khẩu <span id="s">(*)</span></label>
                                    <input type="password" class="form-control" name="repassword" required="required">
                                </div>
                                <div>
                                    <p> <i>  Mật khẩu phải dài hơn 8 ký tự <br> để bảo vệ tài khoản của bạn</i></p>
                                </div>
                                <button type="submit" class="btn btn-info" style="margin-top: 85px; margin-bottom: 20px;">Xác nhận thay đổi</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <!--footer-->
        <%@include file="common/footer.jsp"%>
    </body>
</html>
