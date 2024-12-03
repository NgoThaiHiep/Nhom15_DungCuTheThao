<%-- 
    Document   : header
    Created on : May 22, 2021, 4:24:51 PM
    Author     : Minh Tan
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <!--style-->
        <style>
            .custom_nav-container .nav_search-btn:hover {
                background-image: url(../resource/client/img/search-icon.png);
            }

            .custom_nav-container .nav_search-btn {
                background-image: url(../resource/client/img/search-icon-black.png);
                background-size: 18px;
                background-repeat: no-repeat;
                width: 35px;
                height: 28px;
                padding: 0;
                border: none;
                margin: 0 40px 0 15px;
                background-position: center;
            }

            .custom_nav-container .nav_cart-btn {
                background-image: url(../resource/client/img/shopping-cart.png);
                background-size: 18px;
                background-repeat: no-repeat;
                width: 20px;
                height: 28px;
                padding: 0;
                border: none;
                margin: 0 0 0 15px;
                background-position: center;
            }

            .custom_nav-container .nav_cart-btn:hover {
                background-image: url(../resource/client/img/shopping-cart1.png);
            }

            .dropdown .dropdown-item:hover{
                background-color: #f7bd00;
                transition: 0.75s;
                width: 100%;
            }
        </style>
    </head>
    <body>
        <!-- Start Top Nav -->
        <nav
            class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block"
            id="templatemo_nav_top">
            <div class="container text-light">
                <div class="w-100 d-flex justify-content-between">
                    <div>
                        <a class="navbar-brand" href="home"> <img
                                src="../resource/client/img/runningman.png" alt="" />
                        </a> <a class="navbar-sm-brand text-light text-decoration-none"
                                href="home">N15 SPORT EQUIPMENTS</a> <i class="fa fa-envelope mx-2"></i>
                        <a class="navbar-sm-brand text-light text-decoration-none"
                           href="mailto:ngohiep1750@gmail.com">N15sportequipments@gmail.com</a>
                        <i class="fa fa-phone mx-2"></i> <a
                            class="navbar-sm-brand text-light text-decoration-none"
                            href="tel:0387776610">038-777-6610</a>
                    </div>
                    <div style="padding-top: 10px; padding-left: 110px">
                        <c:if test="${sessionScope.user != null}">
                            <a>
                                <img class="user-avatar rounded-circle"
                                     src="data:image/jpg;base64,${sessionScope.user.avatar}"
                                     style="width: 30px; height: 30px; margin-left: -10px; margin-top: -5px;">
                            </a>
                            <div class="dropdown">
                                <a class="nav-link" data-toggle="dropdown" style="cursor: pointer; margin-top: -28px;">
                                    <span style="color: white; margin-left: 20px;"><b style="font-size: 20px;">${sessionScope.username}</b></span>
                                </a>
                                <div class="dropdown-menu">
	                                <c:if test="${sessionScope.user.role.roleName == 'ROLE_ADMIN'}">
										<a class="dropdown-item" href="../admin/home">Admin</a>
									</c:if>
                                    <a class="dropdown-item" href="my-order">Xem đơn hàng</a>
                                    <a class="dropdown-item" href="profile">Thông tin cá nhân</a>
                                    <a class="dropdown-item" href="../logout">Đăng xuất</a>
								
							</div>
                                
                            </div>
                            <style>
                                #login{
                                    display: none;
                                }
                                #textSearch{
                                    margin-left: 275px;
                                }
                                #lienHe{
                                    padding-right: 48px;
                                }
                            </style>
                        </c:if>
                    </div>
                    <div id="lienHe" style="padding-top: 10px;">
                        <a class="text-light" href="https://www.facebook.com/"
                           target="_blank" rel="sponsored"><i
                                class="fab fa-facebook-f fa-sm fa-fw me-2"></i>
                        </a> 
                        <a class="text-light" href="https://www.instagram.com/"
                           target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i>
                        </a>
                        <a class="text-light" href="https://twitter.com/" target="_blank"><i
                                class="fab fa-twitter fa-sm fa-fw me-2"></i>
                        </a> 
                        <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i
                                class="fab fa-linkedin fa-sm fa-fw"></i>
                        </a>

                    </div>
                    <!-- test xong xoa -->
                </div>
            </div>
        </nav>
        <!-- Close Top Nav -->


        <!-- Header -->
        <div id="menu_area" class="menu-area">
            <div class="container">
                <div class="row">
                    <nav class="navbar navbar-light navbar-expand-lg mainmenu">
                        <button class="navbar-toggler" type="button" data-toggle="collapse"
                                data-target="#navbarSupportedContent"
                                aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li><a class="nav-link" href="home">TRANG CHỦ<span
                                            class="sr-only">(current)</span></a></li>
                                <li class="dropdown"><a class="dropdown-toggle nav-link"
                                                        href="service.html" id="navbarDropdown" role="button"
                                                        data-toggle="dropdown">DANH MỤC SẢN PHẨM</a>
                                    <ul class="dropdown-menu">
                                        <c:forEach items="${sessionScope.categories}" var="category">
                                            <li style="border-bottom: 1px solid #000"><a
                                                    class="nav-link"
                                                    href="search?categoryId=${category.categoryId}"
                                                    id="navbarDropdown" role="button">${category.categoryName}</a>
                                            </li>
                                    </c:forEach></li>
                            </ul>
                            </li>
                            <li>
                                <a class="nav-link" href="info">LIÊN HỆ</a>
                            </li>
                            <li id="login">
                                <a class="nav-link" style="margin-left: 100px;"
                                   href="../login">Đăng nhập</a>
                            </li>
                            <li id="login">
                                <a class="nav-link" href="../register"
                                   style="margin-right: 10px;">Đăng ký</a>
                            </li>
                            <form id="textSearch" action="textSearch" method="GET" class="form-horizontal"
                                  style="margin-top: 13px;">
                                <li><input style="border-radius: 15px; padding-left: 10px"
                                           type="text" name="pcName"
                                           placeholder="Nhập tên sản phầm cần tìm..." size="30"></li>
                            </form>

                            <div class="custom_nav-container" style="padding-left: 40px">
                                <li>
                                    <c:if test="${empty sessionScope.totalQuantity}">
                                        <span class="position-absolute top-10 translate-middle badge rounded-pill bg-light text-dark">0</span>
                                    </c:if> 
                                    <span class="position-absolute top-10 translate-middle badge rounded-pill bg-light text-dark">${sessionScope.totalQuantity}</span>
                                    <!--<a class="btn  my-2 my-sm-0 nav_cart-btn" id="Cart" href="cart" style="margin-left: -30px;"></a>-->
                                    <button class="btn  my-2 my-sm-0 nav_cart-btn"
                                            onclick="window.location.href = ('cart')"
                                            style="margin-left: -30px;"></button>
                                </li>
                            </div>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Close Header -->
    </body>
</html>