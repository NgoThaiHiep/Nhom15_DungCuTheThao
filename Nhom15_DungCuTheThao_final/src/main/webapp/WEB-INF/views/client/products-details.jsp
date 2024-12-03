
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
    </head>
    <body>
        <!--header-->
        <%@include file="common/header.jsp"%>

        <!-- Open Content -->
        <section class="bg-light">
            <div class="container pb-5">
                <div class="row">
                    <div class="col-lg-5 mt-5">
                        <div class="card mb-3">
                            <img src= "data:image/jpg;base64,${product.image}" alt=""
                                 style="margin-left: 35px; width: 78%; margin-top: 2px;">
                        </div>              
                    </div>
                    <!-- col end -->
                    <div class="col-lg-7 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <h1 class="h2">${product.productName}</h1>
                                <p class="h3 py-2">${product.price - (product.price * product.saleDTO.percent / 100)} VNĐ</p>
                                <p class="h4 py-2" style="text-decoration: line-through">${product.price} VNĐ</p>
                                <p class="py-2">
                                    -${product.saleDTO.percent}%
                                </p>
                                <h6>Description:</h6>
                                <p>${product.description}</p>

                                <form action="add-to-cart" method="post">
                                    <input type="hidden" name="product-title" value="Activewear">
                                    <div class="row">
                                        <div class="col-auto">
                                            <ul class="list-inline pb-3">
                                                <li class="list-inline-item text-right">
                                                    Số lượng
                                                    <input name="quantity" size="2" value="1" onchange="this.form.submit()"/>
                                                    <input type="hidden" name="productId"
                                                                     value="${product.productId}"/>
                                                </li>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="row pb-3">
                                        <div class="col d-grid">
                                            <a class="btn btn-success" type="button" href="add-to-cart?productId=${product.productId}&quantity=${sessionScope.cart.value.orderDetailQuantity}">+ Thêm vào giỏ hàng</a>
                                        </div>
                                    </div>
                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Close Content -->

        <!--footer-->
        <%@include file="common/footer.jsp"%>

        <!-- Start Script -->
        <script src="../resource/client/js/jquery-1.11.0.min.js"></script>
        <script src="../resource/client/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="../resource/client/js/bootstrap.bundle.min.js"></script>
        <script src="../resource/client/js/templatemo.js"></script>
        <script src="../resource/client/js/custom.js"></script>

<!--        <script type="text/javascript" src="../resource/client/js/jquery-3.4.1.min.js"></script>
        <script type="text/javascript" src="../resource/client/js/bootstrap.js"></script>-->

        <script>
            function openNav() {
                document.getElementById("myNav").classList.toggle("menu_width");
                document
                        .querySelector(".custom_menu-btn")
                        .classList.toggle("menu_btn-style");
            }
        </script>
        <!-- End Script -->
    </body>
</html>
