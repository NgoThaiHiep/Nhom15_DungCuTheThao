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
              href="<c:url value='../resource/admin/assets/css/cs-skin-elastic.css'/>">
        <link rel="stylesheet"
              href="<c:url value='../resource/admin/assets/css/style.css'/>">
        <!-- <script type="text/javascript" src="https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js"></script> -->
        <link
            href="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.css"
            rel="stylesheet">
        <link
            href="https://cdn.jsdelivr.net/npm/jqvmap@1.5.1/dist/jqvmap.min.css"
            rel="stylesheet">

        <link
            href="https://cdn.jsdelivr.net/npm/weathericons@2.1.0/css/weather-icons.css"
            rel="stylesheet" />
        <link
            href="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.css"
            rel="stylesheet" />
        <style>
            #weatherWidget .currentDesc {
                color: #ffffff !important;
            }

            .traffic-chart {
                min-height: 335px;
            }

            #flotPie1 {
                height: 150px;
            }

            #flotPie1 td {
                padding: 3px;
            }

            #flotPie1 table {
                top: 20px !important;
                right: -10px !important;
            }

            .chart-container {
                display: table;
                min-width: 270px;
                text-align: left;
                padding-top: 10px;
                padding-bottom: 10px;
            }

            #flotLine5 {
                height: 105px;
            }

            #flotBarChart {
                height: 150px;
            }

            #cellPaiChart {
                height: 160px;
            }
        </style>
    </head>
    <body>
        <!-- WRAPPER -->
        <%@include file="common/category.jsp"%>

        <div id="right-panel" class="right-panel">

            <jsp:include page="common/header.jsp"></jsp:include>

                <!-- MAIN -->
                <!-- MAIN CONTENT -->
                <!-- Content -->
                <div class="content">
                    <!-- Animated -->
                    <div class="animated fadeIn">
                        <!-- Widgets  -->
                        <div class="row">
                            <div class="col-lg-3 col-md-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="stat-widget-five">
                                            <div class="stat-icon dib flat-color-1">
                                                <i class="pe-7s-cash"></i>
                                            </div>
                                            <div class="stat-content">
                                                <div class="text-left dib">
                                                    <div class="stat-text"><span class="count">${sessionScope.revenue}</span> VNĐ</div>
                                                    <div class="stat-heading">Doanh thu</div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="stat-widget-five">
                                            <div class="stat-icon dib flat-color-2">
                                                <i class="pe-7s-cart"></i>
                                            </div>
                                            <div class="stat-content">
                                                <div class="text-left dib">
                                                    <div class="stat-text"><span class="count">${sessionScope.countOrder}</span></div>

                                                    <a href="../admin/order-list"><div class="stat-heading">Đơn hàng</div></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="stat-widget-five">
                                            <div class="stat-icon dib flat-color-3">
                                                <i class="pe-7s-browser"></i>
                                            </div>
                                            <div class="stat-content">
                                                <div class="text-left dib">
                                                    <div class="stat-text"><span class="count">${sessionScope.countProduct}</span></div>
                                                    <a href="../admin/product-list"><div class="stat-heading">Sản phẩm</div></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="col-lg-3 col-md-6">
                                <div class="card">
                                    <div class="card-body">
                                        <div class="stat-widget-five">
                                            <div class="stat-icon dib flat-color-4">
                                                <i class="pe-7s-users"></i>
                                            </div>
                                            <div class="stat-content">
                                                <div class="text-left dib">
                                                    <div class="stat-text"><span class="count">${sessionScope.countUser}</span></div>
                                                    <a href="../admin/user-list"><div class="stat-heading">Người dùng</div></a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /Widgets -->

                        <div class="clearfix"></div>
                        <!-- Orders -->
                        <div class="orders">
                            <div class="row">
                                <div class="col-xl-8">
                                    <div class="card">
                                        <div class="card-body">
                                            <h4 class="box-title">Đơn hàng </h4>
                                        </div>
                                        <div class="card-body--">
                                            <div class="table-stats order-table ov-h">
                                                <table class="table ">
                                                    <thead>
                                                        <tr>
                                                            <!--  <th class="serial">STT</th>   -->                                    
                                                            <th>Mã</th>
                                                            <th>Họ tên</th>
                                                            <th>Tổng tiền</th>
                                                            <th>Ngày và giờ</th>
                                                            <th>Trạng thái</th>
                                                            <th>Chi tiết</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                        <c:forEach items="${orders}" var="order">
                                                        <tr>
                                                            <td><a href="#">No. ${order.orderId}</a></td>
                                                            <td>${order.userDTO.email.split("@")[0]}</td>
                                                            <td>${order.totalPrice} VNĐ</td>
                                                            <td>${order.purchaseDate}</td>
                                                            <c:if test="${order.status eq 'Chưa duyệt'}">
                                                                <td><a href="order-updateHome?orderId=${order.orderId}"><span class="badge badge-warning">Chưa duyệt</span></a></td>
                                                            </c:if>
                                                            <c:if test="${order.status eq 'Đã duyệt'}">
                                                                <td><span class="badge badge-complete">Đã duyệt</span></td>
                                                            </c:if>
                                                            <td><a href="order-details?orderId=${order.orderId}" style="text-decoration: underline;">Xem</a></td>
                                                        </tr>
                                                    </c:forEach>



                                                </tbody>
                                            </table>

                                        </div>
                                    </div> <!-- /.table-stats -->
                                    <div class="card-footer">
                                        <div class="row">
                                            <div class="col-md-6">
                                                <span class="panel-note"><i class="fa fa-clock-o"></i>
                                                    24 giờ qua</span>
                                            </div>
                                            <div class="col-md-6 text-right">
                                                <a href="../admin/order-list" class="btn btn-primary">Danh sách các hóa đơn</a>
                                            </div>
                                        </div>
                                    </div>
                                </div> <!-- /.card -->
                            </div>  <!-- /.col-lg-8 -->

                            <div class="col-xl-4">
                                <div class="row">
                                    <div class="col-lg-6 col-xl-12">
                                        <div class="card br-0">
                                            <div class="card-body">
                                                <div class="chart-container ov-h">
                                                    <div id="flotPie1" class="float-chart"></div>
                                                </div>
                                            </div>
                                        </div><!-- /.card -->

                                    </div>
                                </div> <!-- /.col-md-4 -->
                            </div>
                        </div>
                        <!-- /.orders -->
                        <!-- Calender Chart Weather  -->
                        <div class="row">
                            <div class="col-md-12 col-lg-4">
                                <div class="card">
                                    <div class="card-body">
                                        <!-- <h4 class="box-title">Chandler</h4> -->
                                        <div class="calender-cont widget-calender">
                                            <div id="calendar"></div>
                                        </div>
                                    </div>
                                </div><!-- /.card -->
                            </div>


                            <div class="col-lg-4 col-md-6">
                                <div class="card weather-box">
                                    <h4 class="weather-title box-title">Thời tiết</h4>
                                    <div class="card-body">
                                        <div class="weather-widget">
                                            <div id="weather-one" class="weather-one"></div>
                                        </div>
                                    </div>
                                </div><!-- /.card -->
                            </div>
                        </div>
                        <!-- /Calender Chart Weather -->
                        <!-- Modal - Calendar - Add New Event -->
                        <div class="modal fade none-border" id="event-modal">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title"><strong>Add New Event</strong></h4>
                                    </div>
                                    <div class="modal-body"></div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-success save-event waves-effect waves-light">Create event</button>
                                        <button type="button" class="btn btn-danger delete-event waves-effect waves-light" data-dismiss="modal">Delete</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /#event-modal -->
                        <!-- Modal - Calendar - Add Category -->
                        <div class="modal fade none-border" id="add-category">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                        <h4 class="modal-title"><strong>Add a category </strong></h4>
                                    </div>
                                    <div class="modal-body">
                                        <form>
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <label class="control-label">Category Name</label>
                                                    <input class="form-control form-white" placeholder="Enter name" type="text" name="category-name"/>
                                                </div>
                                                <div class="col-md-6">
                                                    <label class="control-label">Choose Category Color</label>
                                                    <select class="form-control form-white" data-placeholder="Choose a color..." name="category-color">
                                                        <option value="success">Success</option>
                                                        <option value="danger">Danger</option>
                                                        <option value="info">Info</option>
                                                        <option value="pink">Pink</option>
                                                        <option value="primary">Primary</option>
                                                        <option value="warning">Warning</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                        <button type="button" class="btn btn-danger waves-effect waves-light save-category" data-dismiss="modal">Save</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- /#add-category -->
                    </div>
                    <!-- .animated -->
                </div>
            </div>

            <!-- END MAIN -->
            <div class="clearfix"></div>
            <jsp:include page="common/footer.jsp"></jsp:include>
        </div>
        <!-- END WRAPPER -->
        <!-- Javascript -->
        <!-- Scripts -->
        <script src="https://cdn.jsdelivr.net/npm/jquery@2.2.4/dist/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.4/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/jquery-match-height@0.7.2/dist/jquery.matchHeight.min.js"></script>
        <script src="../resource/admin/assets/js/main.js"></script>
        <!--  Chart js -->
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.7.3/dist/Chart.bundle.min.js"></script>

        <!--Chartist Chart-->
        <script src="https://cdn.jsdelivr.net/npm/chartist@0.11.0/dist/chartist.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chartist-plugin-legend@0.6.2/chartist-plugin-legend.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/jquery.flot@0.8.3/jquery.flot.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/flot-pie@1.0.0/src/jquery.flot.pie.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/flot-spline@0.0.1/js/jquery.flot.spline.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/simpleweather@3.1.0/jquery.simpleWeather.min.js"></script>
        <script src="../resource/admin/assets/js/init/weather-init.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/moment@2.22.2/moment.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/fullcalendar@3.9.0/dist/fullcalendar.min.js"></script>
        <script src="../resource/admin/assets/js/init/fullcalendar-init.js"></script>

        <!--Local Stuff-->
        <script>
            jQuery(document).ready(function ($) {
                "use strict";

                // Pie chart flotPie1
                var piedata = [
                    {label: "Desktop visits", data: [[1, 32]], color: '#5c6bc0'},
                    {label: "Tab visits", data: [[1, 33]], color: '#ef5350'},
                    {label: "Mobile visits", data: [[1, 35]], color: '#66bb6a'}
                ];

                $.plot('#flotPie1', piedata, {
                    series: {
                        pie: {
                            show: true,
                            radius: 1,
                            innerRadius: 0.65,
                            label: {
                                show: true,
                                radius: 2 / 3,
                                threshold: 1
                            },
                            stroke: {
                                width: 0
                            }
                        }
                    },
                    grid: {
                        hoverable: true,
                        clickable: true
                    }
                });
                // Pie chart flotPie1  End



            });
        </script>
    </body>
</html>