
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
        <!-- Start Article -->
        <section class="bg-light">
            <div class="container py-5">
                <div class="row text-center py-3">
                    <div class="col-lg-6 m-auto">
                        <h1>SALE MẠNH</h1>
                    </div>         
                </div>

                <!--Start Carousel Wrapper-->
                <div id="carousel-related-product">
                    <c:forEach items="${hotOne}" var="product">
                        <div class="p-2 pb-3">
                            <div class="product-wap card rounded-0" id="sanpham">
                                <div class="card rounded-0">
                                    <a href="product-details?productId=${product.productId}"><img
                                            style="display: block;
                                            max-width:230px;
                                            max-height:150px;
                                            width: auto;
                                            height: auto;
                                            margin: auto;
                                            "    src= "data:image/jpg;base64,${product.image}"
                                            alt="Product Image"></a>
                                </div>
                                <div class="card-body" style="height: 51px;">
                                    <a href="product-details?productId=${product.productId}" class="h3 text-decoration-none">${product.productName}</a>
                                </div>
                                <div class="card-body">
                                    <ul class="w-100 list-unstyled d-flex justify-content-between mb-0">
                                        <li style="color: red;">-${product.saleDTO.percent}%</li>
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
                                        <p class="text-center mb-0 font-weight-bold">${product.price - (product.price *
                                                                                       product.saleDTO.percent / 100)}0 VNĐ</p>
                                        </c:if>

                                    <c:if test="${product.saleDTO.percent != 0}">
                                        <ul class="list-unstyled d-flex justify-content-center mb-1">
                                            <li style="text-decoration: line-through">${product.price}0 VNĐ</li>
                                        </ul>
                                        <p class="text-center mb-0 font-weight-bold">${product.price - (product.price *
                                                                                       product.saleDTO.percent / 100)}0 VNĐ</p>
                                        </c:if>    
                                </div>
                                <div class="button_group">
                                    <a class="button" id="btnAddToCart" type="button" href="add-to-cart?productId=${product.productId}">+ Thêm vào giỏ hàng</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- End Article -->
    </body>
</html>
