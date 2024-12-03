<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>N15 SPORT EQUIPMENTS - Admin </title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="apple-touch-icon" href="../resource/client/img/runningman.png">
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">

        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/normalize.css@8.0.0/normalize.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/gh/lykmapipo/themify-icons@0.1.2/css/themify-icons.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/pixeden-stroke-7-icon@1.2.3/pe-icon-7-stroke/dist/pe-icon-7-stroke.min.css">
        <link rel="stylesheet"
              href="https://cdnjs.cloudflare.com/ajax/libs/flag-icon-css/3.2.0/css/flag-icon.min.css">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/cs-skin-elastic.cs'/>">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/lib/datatable/dataTables.bootstrap.min.css'/>">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/style.css'/>">
        <link
            href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800'
            rel='stylesheet' type='text/css'>
        <!-- Icon -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons"
              rel="stylesheet">
    </head>
    <body>
        <jsp:include page="../common/category.jsp" />

        <div id="right-panel" class="right-panel">

            <jsp:include page="../common/header.jsp" />


            <div class="content">
                <div class="animated fadeIn">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-header">
                                    <div class="row">
                                        <div class="col-lg-10">
                                            <strong class="card-title">Chi tiết hóa đơn</strong>
                                        </div>
                                        <div class="col-lg-2" style="margin-right: -20px">
                                            <a href="order-list"> <span class="btn btn-danger btn-sm">Trở về</span>
                                            </a>
                                            <c:if test="${order.status eq 'Chưa duyệt'}">
                                                <a href="order-update?orderId=${order.orderId}"><span
                                                        class="btn btn-warning btn-sm">Chấp nhận</span></a>
                                                </c:if>
                                                <c:if test="${order.status eq 'Đã duyệt'}">
                                                <span class="btn btn-success btn-sm"
                                                      style="font-size: 15px; margin-right: 15px;">Đã duyệt</span>
                                            </c:if>
                                        </div>
                                    </div>
                                </div>

                                <div class="card-body">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th>Hình ảnh</th>
                                                <th>Chi tiết</th>
                                                <th>Giá</th>
                                                <th>Số lượng</th>
                                                <th>Tổng cộng</th>
                                                <th>Vote</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${orderDetails}" var="item">
                                                <tr>
                                                    <td><a
                                                            href="product-details?productId=${item.productDTO.productId}"><img
                                                                style="display: block; max-width: 230px; max-height: 170px; width: auto; height: auto; margin: auto;"
                                                                src="data:image/jpg;base64,${item.productDTO.image}"
                                                                alt=""></a></td>
                                                    <td>
                                                        <div class="shop-details">
                                                            <div class="productname">${item.productDTO.productName}</div>
                                                            <p>
                                                                <img alt="" src="../resource/client/img/star.png">
                                                                <a style="color: #FF9900; margin-right: 15px;" href="#">
                                                                    02 Đánh giá </a>
                                                            </p>

<!--                                                            <p>${item.productDTO.description}</p>-->
                                                            <p>
                                                                Giảm giá : <strong style="color: red;">-${item.productDTO.saleDTO.percent}%</strong>
                                                            </p>
                                                            <p>
                                                                Mã sản phẩm : <strong style="color: red;">${item.productDTO.productId}</strong>
                                                            </p>
                                                        </div>
                                                    </td>
                                                    <td>
                                                        <h5 style="color: #41B314; font-weight: bold;">${item.unitPrice} VND</h5>
                                                        <c:if test="${item.productDTO.saleDTO.percent > 0}">
                                                            <p
                                                                style="font-size: 16px; padding-top: 7px; text-decoration: line-through;">${item.productDTO.price} VND</p>
                                                        </c:if>
                                                    </td>
                                                    <td><select name="quantity" style="color: red;">
                                                            <option value="${item.orderDetailQuantity}">${item.orderDetailQuantity}</option>
                                                            <input type="hidden" value="${item.productDTO.productId}"
                                                                   name="productId" />
                                                        </select></td>
                                                    <td>
                                                        <h5>
                                                            <strong class="red" style="color: red;">
                                                                ${item.unitPrice * item.orderDetailQuantity} VND</strong>
                                                        </h5>
                                                    </td>
                                                    <td><select>
                                                            <c:forEach begin="1" end="5" var="i">
                                                                <option
                                                                    <c:if test="${i == 5}">
                                                                        selected="selected"
                                                                    </c:if>>${i}
                                                                    Star</option>
                                                                </c:forEach>
                                                        </select></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <td colspan="6"><span class="pull-left">Thành tiền: <span style="color: red;">$${order.totalPrice
                                                                                                                                 - 5}0</span>
                                                    </span><br /> <span class="pull-left">Phụ thu: <span
                                                            style="color: red;">5.00 VND</span></span><br /> <span
                                                        class="pull-left" style="font-size: 22px;">Tổng cộng: <span style="color: red;">${order.totalPrice} VND</span>
                                                    </span>
                                                    <p class="pull-right" style="display: flex; border: none;">
                                                        <i class="material-icons"
                                                           style="margin-top: -35px; color: #00ACC1; margin-right: 1px;">&#xe0c8;</i>
                                                        <i class="title"
                                                           style="font-size: 17px; color: #00ACC1; font-weight: bold; margin-top: -30px;">
                                                            ${order.userDTO.userName} * ${order.userDTO.address} *
                                                            ${order.userDTO.phone}</i><br />
                                                    </p></td>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                                <!-- /.table-stats -->

                            </div>

                        </div>
                    </div>
                </div>
                <!-- .animated -->
            </div>
            <!-- .content -->
            <!-- END MAIN -->
            <div class="clearfix"></div>
            <!-- Footer -->
            <footer class="site-footer">
                <div class="footer-inner bg-white">
                    <div class="row">
                        <div class="col-sm-6">&copy; 2024</div>
                        <div class="col-sm-6 text-right">
                            Website được thực hiện bởi <a href="https://colorlib.com">N15 SPORT EQUIPMENTS</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- /.site-footer -->
        <!-- Javascript -->
        <!-- Scripts -->
        <script
        src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script
        src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="../resource/admin/assets/js/main.js"></script>

    </body>

</html>