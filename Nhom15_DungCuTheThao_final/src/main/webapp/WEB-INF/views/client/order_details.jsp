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
            #btnThanhToan{
                width: 50%;
                margin: 0 25%;
                border-radius: 30px;
                background-color: white;
                color: black;
                height: 40px;
                font-size: 25px;
            }
            #btnThanhToan:hover{
                background-color: red;
                color: white;
                -webkit-transition: all 250ms ease;
                -moz-transition: all 250ms ease;
                -ms-transition: all 250ms ease;
                -o-transition: all 250ms ease;
                transition: all 250ms ease;
            }
            .shippingbox {
                margin: 15px 0;
                border-radius: 10px;
                -webkit-border-radius: 10px;
                border: 1px solid #E1E1E1;
                padding: 30px;
                float: left;
                width: 100%;
            }

            .shippingbox h5 {
                margin-bottom: 20px;
            }

            .shippingbox label {
                position: relative;
                margin-bottom: 8px;
                width: 100%;
            }

            .shippingbox select, .shippingbox input {
                margin-bottom: 20px;
                margin-left: 0;
                width: 100%;
            }
            .subtotal, .grandtotal {
                float: left;
                position: relative;
                width: 100%;
            }

            .subtotal h5 {
                float: left;
                width: 45%;
                text-align: right;
                font-weight: 400;
                padding-top: 3px;
            }

            .subtotal span {
                float: right;
                width: 45%;
                font-weight: 500;
                font-size: 20px;
            }

            .grandtotal h5 {
                float: left;
                width: 45%;
                text-align: right;
                font-weight: 400;
                font-size: 20px;
                padding-top: 3px;
            }

            .grandtotal span {
                float: right;
                width: 45%;
                font-weight: 500;
                font-size: 20px;
                color: #fe5252;
            }

            .shopping-cart button:hover {
                background: #f7544a;
                color: #fff;
            }
        </style>
    </head>
    <!--header-->
    <%@include file="common/header.jsp"%>
    <div style = "padding: 0px 100px;">
        <h3 class="title" style="padding-top: 20px;">Chi tiết đơn hàng</h3>
        <a href="home" class="btn btn-warning" style="margin-bottom: 20px;"><i class="fa fa-angle-left"></i> Tiếp tục mua sắm </a>
        <div class="row">
            <table class="table table-hover table-condensed"> 
                <thead> 
                    <tr> 
                        <th>Hình ảnh</th>
                        <th>Sản phẩm</th> 
                        <th>Giá</th> 
                        <th>Số lượng</th> 
                        <th class="text-center">Thành tiền</th> 
                    </tr> 
                </thead>

                <c:forEach items="${ods}" var="od">
                    <tr>
                        <td>
                            <div class="row">
                                <div class="col-sm-2 hidden-xs">
                                    <a href="product-details?productId=${od.productDTO.productId}"><img
                                            style="width: 150px; height: 150px;" src= "data:image/jpg;base64,${od.productDTO.image}"
                                            alt=""></a>
                                </div> 
                            </div>
                        </td>
                        <td> 
                            <div class="row"> 
                                <div class="col-sm-10"> 
                                    <h4>${od.productDTO.productName}</h4> 
                                    <p>${od.productDTO.description}</p> 
                                    <p>Giảm giá: -${od.productDTO.saleDTO.percent}%</p>
                                    <p>Mã sản phẩm: ${od.productDTO.productId}</p>
                                </div> 
                            </div> 
                        </td> 
                        <td>
                            <span>${od.unitPrice} VNĐ</span>
                            <c:if
                                test="${od.productDTO.saleDTO.percent > 0}">
                                <p style="font-size: 16px; padding-top: 7px; text-decoration: line-through;">${od.productDTO.price} VNĐ</p>
                            </c:if>
                        </td>
                        <td>
                            <form action="add-to-cart" method="post">
                                <input name="quantity" size="2" value="${od.orderDetailQuantity}" onchange="this.form.submit()" readonly=""/>
                                <input type="hidden"
                                       value="${od.productDTO.productId}"
                                       name="productId" />
                            </form>
                        </td> 
                        <td class = "text-center">
                            <span id = "thanhtien1">${Math.round(od.unitPrice) *
                                                      od.orderDetailQuantity} VNĐ</span>
                        </td>
                    </tr> 
                </c:forEach>

                <tfoot>
                    <tr>
                        <td colspan="9">
                            <p class="pull-right" style="display: flex; border: none;">
                                <i class="title"
                                   style="font-size: 17px; color: #00ACC1; font-weight: bold;">
                                    ${sessionScope.user.fullname} *
                                    ${sessionScope.user.address} * ${sessionScope.user.phone}</i>
                            </p>
                        </td>
                    </tr>
                </tfoot>
            </table>
            <div id="purchased" class="col-md-4 col-sm-6">
                <div class="shippingbox">
                    <div class="subtotal">
                        <h5>TỔNG TIỀN</h5>
                        <span>${requestScope.subTotal} VNĐ</span>
                    </div>
                    <div class="subtotal">
                        <h5>PHÍ GIAO HÀNG</h5>
                        <span> 30,000 VNĐ</span>
                    </div>
                    <div class="grandtotal">
                        <h5>TỔNG CỘNG</h5>
                        <span>${requestScope.grandTotal} VNĐ</span>
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