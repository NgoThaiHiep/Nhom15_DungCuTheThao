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
                        <div class="col-md-1"></div>
                        <div class="col-md-10">
                            <div class="card border border-secondary">
                                <div class="card-header">
                                    <strong class="card-title">Chỉnh sửa tài khoản</strong>
                                    <span style="color: red; font-weight: bold; font-size: 18px;">${message}</span>
                                </div>
                                <div class="card-body card-block">

                                    <form action="user-update" method="post"
                                          enctype="multipart/form-data" class="form-horizontal">

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="select" class=" form-control-label">Email:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="email" class="form-control"
                                                       placeholder="Nhập email của bạn..." name="email"
                                                       value="${user.email}" readonly="readonly" /> <input
                                                       type="hidden" name="userId" value="${user.userId}" />
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="text-input" class=" form-control-label">Họ
                                                    và tên:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="text" class="form-control" style="height: 30px;"
                                                       placeholder="Nhập họ và tên..." name="fullName"
                                                       value="${user.userName}" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="email-input" class=" form-control-label">Giới
                                                    tính:</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="radio" name="gender" value="true"
                                                       style="cursor: pointer;"
                                                       <c:if test="${user.sex eq 'true'}">
                                                           checked="checked"
                                                       </c:if> />
                                                <span style="margin-right: 100px;">Nam</span> <input
                                                    type="radio" name="gender" value="false"
                                                    style="cursor: pointer;"
                                                    <c:if test="${user.sex eq 'false'}">
                                                        checked="checked"
                                                    </c:if> />
                                                Nữ
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="password-input" class=" form-control-label">Số
                                                    điện thoại</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input required="required" type="text" class="form-control"
                                                       placeholder="Nhập số điện thoại của bạn..." name="phone" value="${user.phone}"/>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="disabled-input" class=" form-control-label">Địa
                                                    chỉ</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <textarea required="required" class="form-control"
                                                          placeholder="Nhập địa chỉ của bạn..." rows="4"
                                                          name="address">${user.address}</textarea>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="disabled-input" class=" form-control-label">Vai
                                                    trò</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <select name="roleId">
                                                    <c:forEach items="${roles}" var="role">
                                                        <option value="${role.roleId}"
                                                                <c:if test="${user.roleDTO.roleId == role.roleId}">
                                                                    selected="selected"
                                                                </c:if>>${role.roleName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="file-input" class=" form-control-label">Hình
                                                    ảnh</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <c:if test="${user.avatar != null}">
                                                    <img src="data:image/jpg;base64,${user.avatar}" alt="Avatar"
                                                         class="rounded-circle" style="width: 15%;">
                                                </c:if> <input type="file" name="avatarFile" style="margin-left: 5px; margin-top: 30px;"/>
                                                <input type="hidden" name="avatar" value="${user.avatar}"/>
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Mật khẩu</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="password" required="required"
                                                       class="form-control"
                                                       placeholder="Mật khẩu của bạn..." name="password" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label class=" form-control-label">Nhập lại mật khẩu</label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <input type="password"
                                                       class="form-control" required="required"
                                                       placeholder="Nhập lại mật khẩu..." name="repassword" />
                                            </div>
                                        </div>
                                        <div class="row form-group">
                                            <div class="col col-md-3">
                                                <label for="file-input" class=" form-control-label"></label>
                                            </div>
                                            <div class="col-12 col-md-9">
                                                <button type="submit" class="btn btn-success">Chỉnh sửa</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                </div>
            </div>
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