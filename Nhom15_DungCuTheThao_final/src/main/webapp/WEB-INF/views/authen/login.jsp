<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>N15 SPORT EQUIPMENTS</title>
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">
        <link rel="stylesheet" type="text/css" href="resource/common/authen.css">
        <link rel="shortcut icon" type="image/x-icon" href="../resource/client/img/runningman.png">
        <!--        <script src='https://kit.fontawesome.com/a076d05399.js'></script>-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" />
        <script>
            $(document).on('click', '.toggle-password', function () {
                $(this).toggleClass("fa-eye fa-eye-slash");
                var input = $("#pass_log_id");
                input.attr('type') === 'password' ? input.attr('type', 'text') : input.attr('type', 'password')
            });
        </script>
    </head>
    <body style="background: url(resource/client/img/background_sport.jpg); background-size: 100% 230%; background-repeat: no-repeat">
        <!-- Authen form -->
        <form action="login" method="post">
            <div class="auth-form" style="background-color: white;">
                <div class="auth-form-container">
                    <div class="auth-form-header">
                        <h3 class="auth-form-title">Đăng nhập</h3>
                    </div>
                    <p style="color: red; margin-top: -15px; margin-left: 3x; margin-bottom: 5px;">${er}</p>
                    <div class="auth-form-form" style="margin-top: 15px;">
                        <div class="auth-form-group">
                            <input class="auth-form-input" type="text" name="account"
                                   placeholder="Email hoặc số điện thoại" required="required" />
                        </div>
                        <div class="auth-form-group">
                            <input class="auth-form-input" type="password" name="password" id="pass_log_id" 
                                   placeholder="Mật khẩu" required="required"/>
                            <span toggle="#password-field" class="fa fa-fw fa-eye field-icon toggle-password" style="cursor: pointer"></span>
                        </div>
                        <div class="auth-form-group" style="display: flex; justify-content: space-between; margin-top: -10px; margin-bottom: 15px;">
                            <div><input type="checkbox" name="remember" style="cursor: pointer;"/> Nhớ mật khẩu</div>
                            <div><a href="" style="text-decoration: none">Quên mật khẩu?</a></div>
                        </div>
                    </div>

                    <div class="auth-form-controls">
                        <button type="submit" class="btn" style="cursor: pointer;">Đăng nhập</button>
                        <a href="register" class="btn">Đăng ký</a>
                    </div>
                </div>
                <div class="auth-form-social">
                    <a href="#" class="btn-social-gg"><i class='fa' style='font-size:20px; color: tomato'>&#xf2b3;</i> Đăng nhập với Google </a>
                    <a href="#" class="btn-social-fb"><i class='fa' style="font-size: 20px;">&#xf09a;</i> Đăng nhập với Facebook </a>
                </div>
            </div>
        </form>


    </body>
</html>