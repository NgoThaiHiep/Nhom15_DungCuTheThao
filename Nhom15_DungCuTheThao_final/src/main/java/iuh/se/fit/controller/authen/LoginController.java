package iuh.se.fit.controller.authen;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.model.UserDTO;
import iuh.se.fit.model.UserPrincipal;
import iuh.se.fit.service.UserService;



@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public String login(HttpServletRequest request, @RequestParam(name = "er", required = false) String er) {
        request.setAttribute("er", er);
        return "authen/login";
    }

    @GetMapping(value = "/home") // chuyen den home khi dang nhap thanh cong
    public String loginSuccess(HttpServletRequest request, HttpSession session) {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("user", userPrincipal);
        String username = userPrincipal.getEmail();
        session.setAttribute("username", username.split("@")[0]);
        if (request.isUserInRole("ADMIN")) { // neu role la admin thi chuyen den trang admin
            return "redirect:/admin/home";
        } else {
            return "redirect:/client/home"; // khong phai admin chuyen den trang client
        }
    }

    @GetMapping(value = "/logout")
    public String logout() {
        return "redirect:/login";
    }

    @PostMapping(value = "/login")
    public String login(HttpSession session, @RequestParam(name = "account") String account,
            @RequestParam(name = "password") String password, HttpServletRequest request) {
        try {
            UserDTO userDTO = userService.findByEmailOrPhoneAndPassword(account, password, true);
            String username = account.split("@")[0];
            session.setAttribute("username", username);
            session.setAttribute("user", userDTO);
            return "redirect:/client/home";
        } catch (Exception e) {
            request.setAttribute("er", "Thông tin tài khoản không hợp lệ. Muốn thử lại?");
            return "authen/login";
        }
    }
}