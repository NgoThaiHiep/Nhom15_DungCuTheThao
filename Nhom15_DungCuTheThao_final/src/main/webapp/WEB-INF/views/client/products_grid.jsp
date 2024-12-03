
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

        <style>
            #btnAddToCart:hover { 
                background-color: red; 
                color: white;
                border: 1px solid red;
                -webkit-transition: all 500ms ease;
                -moz-transition: all 500ms ease;
                -ms-transition: all 500ms ease;
                -o-transition: all 500ms ease;
                transition: all 500ms ease;
            }
            #btnAddToCart{
                width: 100%; 
                text-align: center; 
                text-decoration: none;                                       
                border: 1px solid #000; 
                border-radius: 15px; 
                width: 75%; 
                margin-bottom: 20px; 
                margin-left: 30px;                                         
                padding-top: 10px; 
                padding-bottom: 10px
            }
            #sanpham:hover{
                border: 1px solid red;
                -webkit-transition: all 500ms ease;
                -moz-transition: all 500ms ease;
                -ms-transition: all 500ms ease;
                -o-transition: all 500ms ease;
                transition: all 500ms ease;
            }
        </style>
    </head>
    <body>
        <!--header-->
        <%@include file="common/header.jsp"%>

        <!-- Start Content -->
        <div class="container py-5 bg-light">
            <div class="row">
                <div class="col-lg-3">
                    <h1 class="h2 pb-4">Loại sản phẩm</h1>
                    <h1>
                        <c:forEach items="${categories}" var="category">
                            <li class="pb-3" style="list-style-type: none; border-bottom: 1px solid #000; margin-top: 22px">
                                <a class="collapsed d-flex justify-content-between h3 text-decoration-none" href="search?categoryId=${category.categoryId}">${category.categoryName}</a>
                            </li>  
                        </c:forEach>
                    </h1>
                </div>

                <div class="col-lg-9">
                    <div class="row">
                        <div class="col-md-6 pb-4">
                            <div class="d-flex">
                                <h3 class="title" style="margin-right: 10px">Lọc theo giá</h3>
                                <form class="pricing" action="search" method="get">
                                    <select name="pricing" onchange="this.form.submit()" class="dropdown-toggle" style="border-radius: 5px; padding: 6px; cursor: pointer;">
                                        <option <c:if test="${pricing eq 'default'}">
                                                selected="selected"
                                            </c:if>
                                            value="default">
                                            Mặc định
                                        </option>
                                        <option
                                            <c:if test="${pricing eq 'under300'}">
                                                selected="selected"
                                            </c:if>
                                            value="under300">Dưới 300 nghìn
                                        </option>
                                        <option
                                            <c:if test="${pricing eq '300to500'}">
                                                selected="selected"
                                            </c:if>
                                            value="300to500">300 nghìn đến 500 nghìn
                                        </option>
                                        <option
                                            <c:if test="${pricing eq 'greaterthan500'}">
                                                selected="selected"
                                            </c:if>
                                            value="greaterthan500">Trên 500 nghìn
                                        </option>
                                        <input type="hidden" name="categoryId" value="${categoryId}"/>
                                    </select>
                                </form>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <c:forEach items="${products}" var="product">
                            <div class="col-md-4">
                                <div class="card mb-4 product-wap rounded-0" id="sanpham">
                                    <div class="card rounded-0">
                                        <a href="product-details?productId=${product.productId}"><img
                                                style="display: block;
                                                max-width:230px;
                                                max-height:170px;
                                                width: auto;
                                                height: auto;
                                                margin: auto;
                                                " 
                                                src= "data:image/jpg;base64,${product.image}" alt="Product Name"></a>
                                    </div>
                                    <div class="card-body" style="height: 51px; ">
                                        <a href="product-details?productId=${product.productId}" class="h3 text-decoration-none">${product.productName}</a>
                                    </div>
                                    <div class="card-body">
                                        <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                            <li style="color: red">-${product.saleDTO.percent}%</li>
                                            <li class="pt-2">
                                                <span class="product-color-dot color-dot-red float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-blue float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-black float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-light float-left rounded-circle ml-1"></span>
                                                <span class="product-color-dot color-dot-green float-left rounded-circle ml-1"></span>
                                            </li>
                                        </ul>
                                        <c:if test="${product.saleDTO.percent == 0}">
                                            <ul class="list-unstyled d-flex justify-content-center mb-1">
                                                <li>.</li>
                                            </ul>
                                            <p class="text-center mb-0 font-weight-bold">${product.price - (product.price * product.saleDTO.percent / 100)} VNĐ</p>
                                        </c:if>
                                        <c:if test="${product.saleDTO.percent != 0}">
                                            <ul class="list-unstyled d-flex justify-content-center mb-1">
                                                <li style="text-decoration: line-through; opacity: 0.4">${product.price} VNĐ</li>
                                            </ul>
                                            <p class="text-center mb-0 font-weight-bold">${product.price - (product.price * product.saleDTO.percent / 100)} VNĐ</p>
                                        </c:if>
                                    </div>
                                    <div class="button_group">
                                        <a class="button" id="btnAddToCart" type="button" href="add-to-cart?productId=${product.productId}">+ Thêm vào giỏ hàng</a>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!--Toolbar-->
                    <jsp:include page="common/toolbar.jsp" />
                </div>
            </div>
        </div>
        <!-- End Content -->

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
