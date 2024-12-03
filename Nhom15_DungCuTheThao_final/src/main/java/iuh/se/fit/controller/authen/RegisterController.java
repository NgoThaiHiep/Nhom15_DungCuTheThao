package iuh.se.fit.controller.authen;

import java.io.FileNotFoundException;
import java.security.SecureRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.model.RoleDTO;
import iuh.se.fit.model.UserDTO;



@Controller
public class RegisterController {

    @Autowired
    private iuh.se.fit.service.UserService userService;

    @Autowired
    private MailSender mailSender;

    @GetMapping(value = "/register")
    public String register() {
        return "authen/register";
    }

    @PostMapping(value = "/register")
    public String register(HttpServletRequest request, @RequestParam(name = "email") String email,
            @RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword) throws FileNotFoundException {
        String code = randomString(8);
        if (userService.findByEmail(email) != null) {
            UserDTO userDTO = userService.findByEmail(email);
            if (userDTO.isVerify() == true) {
                request.setAttribute("error", "Email này đã tồn tại!");
                return "authen/register";
            } else {
                if (!password.equals(repassword)) {
                    request.setAttribute("error", "Mật khẩu không khớp!");
                    request.setAttribute("email", email);
                    userDTO.setPassword(repassword);

                    userService.update(userDTO, null);
                    return "authen/register";
                } else {
//                    File initialFile = new File("../WEB-INF/resource/client/img/default-avatar.png");
//                    InputStream targetStream = new FileInputStream(initialFile);
                    userDTO.setPassword(new BCryptPasswordEncoder().encode(password));
                    userService.update(userDTO, null);
                    sendEmail("ngohiep1750@gmail.com", email, "Chao mung ban den voi N15-SPORT-EQUIPMENTS!",
                            "Xin chao, " + email.split("@")[0] + "! Vui long xac nhan rang ban la nguoi da tao tai khoan nay!" + " Ma xac nhan cua ban la: " + code);
                }
            }
        } else {
            if (!password.equals(repassword)) {
                request.setAttribute("error", "Mật khẩu không khớp!");
                request.setAttribute("email", email);
                return "authen/register";
            } else {
                UserDTO userDTO = new UserDTO();
                userDTO.setEmail(email);
                userDTO.setPassword(new BCryptPasswordEncoder().encode(password));
//                
//                File initialFile = new File("../WEB-INF/resource/client/img/default-avatar.png");
//                InputStream targetStream = new FileInputStream(initialFile);

                RoleDTO roleDTO = new RoleDTO();
                roleDTO.setRoleId(3);
                userDTO.setRoleDTO(roleDTO);
                userService.insert(userDTO, null);
                sendEmail("ngohiep1750@gmail.com", email, "Chao mung ban den voi N15-SPORT-EQUIPMENTS!",
                        "Xin chao, " + email.split("@")[0] + "! Vui long xac nhan rang ban la nguoi da tao tai khoan nay!" + " Ma xac nhan cua ban la: " + code);
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("emailRegister", email);
        session.setAttribute("codeVerify", code);
        return "authen/verify";
    }

    @GetMapping(value = "/resend-code")
    public String resendCode(HttpSession session, HttpServletRequest request) {
        String code = randomString(8);
        String email = (String) session.getAttribute("emailRegister");
        sendEmail("ngohiep1750@gmail.com", email, "Chao mung ban den voi N15-SPORT-EQUIPMENTS!",
                "Xin chao, " + email.split("@")[0] + "! Vui long xac nhan rang ban la nguoi da tao tai khoan nay!" + " Ma xac nhan cua ban la: " + code);
        request.setAttribute("resend", "resend");
        session.setAttribute("codeVerify", code);
        return "authen/verify";
    }

    @PostMapping(value = "/verify")
    public String verify(HttpServletRequest request, HttpSession session) {
        String code = request.getParameter("code");
        String codeVerify = (String) session.getAttribute("codeVerify");
        if (!code.equals(codeVerify)) {
            request.setAttribute("verifyFail", "Code không đúng, Vui lòng thử lại!");
        } else {
            String email = (String) session.getAttribute("emailRegister");
            UserDTO userDTO = userService.findByEmail(email);
            userDTO.setVerify(true);
            request.setAttribute("verifySuccess", "Xác thực thành công!");
            request.setAttribute("active", "active");
            userService.update(userDTO, null);
        }
        return "authen/verify";
    }

    public void sendEmail(String from, String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);

        mailSender.send(mailMessage);
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }

}
