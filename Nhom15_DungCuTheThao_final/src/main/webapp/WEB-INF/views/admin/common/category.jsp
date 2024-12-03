<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
    </head>
    <body>
        <!-- Left Panel -->
        <aside id="left-panel" class="left-panel">
            <nav class="navbar navbar-expand-sm navbar-default">
                <div id="main-menu" class="main-menu collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active">
                            <a href="home"><i class="menu-icon fa fa-laptop"></i>Trang chủ </a>
                        </li>
                        <li class="menu-title">Menu</li><!-- /.menu-title -->
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-archive"></i>Đơn hàng và sản phẩm</a>
                            <ul class="sub-menu children dropdown-menu">                           
                                <li><i class="fa fa-gift"></i><a href="../admin/order-list">Đơn hàng</a></li>
                                <li><i class="fa fa-tachometer"></i><a href="../admin/product-list">Sản phẩm</a></li>
                            </ul>
                        </li>
                        <li class="menu-item-has-children dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="menu-icon fa fa-cogs"></i>Quản lý tài khoản</a>
                            <ul class="sub-menu children dropdown-menu">                           
                                <li><i class="fa fa-user"></i><a href="user-list">Tất cả tài khoản</a></li>
                                <li><i class="fa fa-cog"></i><a href="user-list">Cài đặt</a></li>
                            </ul>
                        </li>
                    </ul>

                </div><!-- /.navbar-collapse -->
            </nav>
        </aside>
        <!-- /#left-panel -->
    </body>
</html>