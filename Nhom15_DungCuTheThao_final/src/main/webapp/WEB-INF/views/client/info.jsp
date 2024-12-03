
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
    </head>
    <body>
        <!--header-->
        <%@include file="common/header.jsp"%>

        <!-- Start Content Page -->
        <div class="container-fluid bg-light py-5">
            <div class="col-md-6 m-auto text-center">
                <h1 class="h1">Liên hệ với chúng tôi</h1>
                <p>
                    Nếu cần hỗ trợ dịch vụ hoặc có gặp vấn đề gì về sản phẩm, <br>
                    xin hãy điền vào thông tin dưới đây và gửi ngay cho chúng tôi.
                </p>
            </div>
        </div>

        <!-- Start Map -->
        <div class="col-md-12">
            <div class="map_container">
                <div class="map-responsive">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3918.856438834871!2d106.68526211462296!3d10.822296492290397!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3174deb3ef536f31%3A0x8b7bb8b7c956157b!2zVHLGsOG7nW5nIMSQ4bqhaSBo4buNYyBDw7RuZyBuZ2hp4buHcCBUUC5IQ00!5e0!3m2!1svi!2s!4v1621759782211!5m2!1svi!2s" style="border:0; width: 100%; height: 400px" allowfullscreen="" loading="lazy"></iframe>
                </div>
            </div>
        </div>
        <!-- Ena Map -->

        <!-- Start Contact -->
        <div class="container py-5">
            <div class="row py-5">
               <form class="col-md-9 m-auto" action="send-contact" method="post">
				    <div class="row">
				        <div class="form-group col-md-6 mb-3">
				            <label for="inputname">Họ và tên</label>
				            <input type="text" class="form-control mt-1" id="name" name="name" placeholder="Điền tên vào đây..." required>
				        </div>
				        <div class="form-group col-md-6 mb-3">
				            <label for="inputemail">Email</label>
				            <input type="email" class="form-control mt-1" id="email" name="email" placeholder="Email" required>
				        </div>
				    </div>
				    <div class="mb-3">
				        <label for="inputsubject">Tiêu đề</label>
				        <input type="text" class="form-control mt-1" id="subject" name="subject" placeholder="Tiêu đề" required>
				    </div>
				    <div class="mb-3">
				        <label for="inputmessage">Message</label>
				        <textarea class="form-control mt-1" id="message" name="message" placeholder="Message" rows="8" required></textarea>
				    </div>
				    <div class="row">
				        <div class="col text-end mt-2">
				            <button type="submit" class="btn btn-success btn-lg px-3">Gửi</button>
				        </div>
				    </div>
				</form>
            </div>
        </div>
        <!-- End Contact -->

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
