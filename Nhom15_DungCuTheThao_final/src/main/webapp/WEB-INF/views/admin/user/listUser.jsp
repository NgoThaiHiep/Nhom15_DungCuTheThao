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

        <%@include file="../common/category.jsp"%>

        <div id="right-panel" class="right-panel">

            <jsp:include page="../common/header.jsp" />


            <div class="content">
                <div class="animated fadeIn">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <form action="user-delete" method="get">
                                    <div class="card-header">
                                        <div class="row">
                                            <div class="col-lg-9">
                                                <strong class="card-title">Danh sách tài khoản</strong>
                                            </div>
                                            <div class="col-lg-3">
                                                <button class="btn btn-danger btn-sm" type="submit">Xóa</button>
                                                <a href="user-create"><span
                                                        class="btn btn-success btn-sm">Thêm tài khoản mới</span></a>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="table-stats order-table ov-h">
                                        <table class="table ">
                                            <thead>
                                                <tr>
                                                    <th><input type="checkbox" name="all" id="checkAll"
                                                               style="cursor: pointer;" /></th>
                                                    <th>Mã</th>
                                                    <th style="width: 8%;">Ảnh đại diện</th>
                                                    <th style="padding-left: 15px;">Email</th>
                                                    <th>Họ tên</th>
                                                    <th>Số điện thoại</th>
                                                    <th style="width: 15%;">Địa chỉ</th>
                                                    <th>Giới tính</th>
                                                    <th style="width: 5%;">Vai trò</th>
                                                    <th>Chỉnh sửa</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${users}" var="user" varStatus="loop">
                                                    <tr>
                                                        <td style="vertical-align: middle;"><input
                                                                class="checkbox" type="checkbox" name="userId"
                                                                value="${user.userId}" id="${loop.count}"
                                                                style="cursor: pointer;" /></td>
                                                        <td style="vertical-align: middle;">${user.userId}</td>
                                                        <td style="vertical-align: middle;"><img
                                                                src="data:image/jpg;base64,${user.avatar}" alt="Avatar"
                                                                class="user-avatar rounded-circle" style="width: 100%;"></td>
                                                        <td style="vertical-align: middle; padding-left: 25px;">${user.email}</td>
                                                        <td style="vertical-align: middle;">${user.userName}</td>
                                                        <td style="vertical-align: middle;">${user.phone}</td>
                                                        <td style="vertical-align: middle;">${user.address}</td>
                                                        <td style="vertical-align: middle;"><c:choose>
                                                                <c:when test="${user.sex}">Nam</c:when>
                                                                <c:otherwise>Nữ</c:otherwise>
                                                            </c:choose></td>
                                                        <td style="vertical-align: middle;">${user.roleDTO.roleName}</td>
                                                        <td style="vertical-align: middle;"><a
                                                                href="user-update?userId=${user.userId}">
                                                                <button type="button" class="btn btn-warning btn-sm">
                                                                    <i class="fa fa-magic"></i>&nbsp; Thay đổi
                                                                </button> <!-- <span class="label label-warning" style="font-size: 15px;">Update</span> -->
                                                            </a></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </form>
                                <!-- /.table-stats -->
                                <div class="card-footer">

                                    <ul class="pagination">
                                        <c:forEach begin="0" end="${totalPage - 1}" var="i">
                                            <li class="page-item"><a class="page-link"
                                                                     <c:if test="${i == pageIndex}">
                                                                         style="background-color: #F0AD4E; color: white;"
                                                                     </c:if>
                                                                     href="user-list?pageIndex=${i}">${i + 1}</a></li>
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