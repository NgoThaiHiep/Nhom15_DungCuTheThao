
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
    </head>
    <body>
        <!--header-->
        <%@include file="common/header.jsp"%>

        <div class="container py-5">
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
                                <h3 class="title" style="margin-right: 10px">Rất tiếc không tìm thấy sản phẩm nào phù hợp</h3>
                            </div>
                            <c:if test="${checkSearch == false}">
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
                            </c:if>                            
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--footer-->
        <%@include file="common/footer.jsp"%>
    </body>
</html>
