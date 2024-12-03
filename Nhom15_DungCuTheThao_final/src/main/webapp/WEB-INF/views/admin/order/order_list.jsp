<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>N15 SPORT EQUIPMENTS - Admin</title>
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
                                    <strong class="card-title">Danh sách hóa đơn</strong>

                                </div>

                                <div class="table-stats order-table ov-h">
                                    <table class="table ">
                                        <thead>
                                            <tr>
                                                <th><input type="checkbox" name="all" id="checkAll"
                                                           style="cursor: pointer;" /></th>
                                                <th>Mã</th>
                                                <th>Họ tên</th>
                                                <th>Tổng tiền</th>
                                                <th>Ngày và giờ</th>
                                                <th>Trạng thái</th>
                                                <th>Chi tiết</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${orders}" var="order" varStatus="loop">
                                                <tr>
                                                    <td style="vertical-align: middle;"><input
                                                            class="checkbox" type="checkbox" name="orderId"
                                                            value="${order.orderId}" id="${loop.count}"
                                                            style="cursor: pointer;" /></td>
                                                    <td style="vertical-align: middle;">No.
                                                        ${order.orderId}</td>
                                                    <td>${order.userDTO.email.split("@")[0]}</td>
                                                    <td>${order.totalPrice} VNĐ</td>
                                                    <td>${order.purchaseDate}</td>
                                                    <c:if test="${order.status eq 'Chưa duyệt'}">
                                                        <td><a
                                                                href="order-update?orderId=${order.orderId}&pageIndex=${pageIndex}
                                                                "><span
                                                                    class="badge badge-warning">Chưa duyệt</span></a></td>
                                                            </c:if>
                                                            <c:if test="${order.status eq 'Đã duyệt'}">
                                                        <td><span class="badge badge-complete">Đã duyệt</span></td>
                                                    </c:if>
                                                    <td><a href="order-details?orderId=${order.orderId}"
                                                           style="text-decoration: underline;">Xem</a></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- /.table-stats -->
                                <div class="card-footer">
                                    <ul class="pagination">
                                        <c:forEach begin="0" end="${totalPage - 1}" var="i">
                                            <li class="page-item"><a class="page-link"
                                                                     <c:if test="${i == pageIndex}">
                                                                         style="background-color: #F0AD4E; color: white;"
                                                                     </c:if>
                                                                     href="order-list?pageIndex=${i}">${i + 1}</a></li>
                                            </c:forEach>
                                    </ul>
                                </div>
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


        <script>
            let userSelection = document.getElementsByClassName('checkbox');
            let checkAll = document.getElementById('checkAll')


            checkAll.addEventListener('click', () => {
                if (checkAll.checked == true) {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = true
                    }
                } else {
                    for (let i = 1; i <= userSelection.length; i++) {
                        document.getElementById(i).checked = false
                    }
                }

            })
        </script>
    </body>

</html>