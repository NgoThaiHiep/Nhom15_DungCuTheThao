/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.controller.client;


import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import iuh.se.fit.model.RoleDTO;
import iuh.se.fit.model.UserDTO;
import iuh.se.fit.model.UserPrincipal;
import iuh.se.fit.service.UserService;

/**
 *
 * @author Minh Tan
 */
@Controller
@RequestMapping(value = "/client")
public class ProfileClientController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/profile")
    public String profile() {
        return "client/profile";
    }

    @GetMapping(value = "/profile-from-cart")
    public String profileFromCart(HttpServletRequest request) {
        request.setAttribute("messageError", "Vui lòng cập nhật thông tin giao hàng.");
        return "client/profile";
    }

    @PostMapping(value = "/profile-update")
    public String profileUpdate(HttpServletRequest request,
            @RequestParam(name = "fullname", required = false) String fullname,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "address") String address,
            @RequestParam(name = "avatarfile") MultipartFile avatarFile) throws IOException {
        UserPrincipal userPrincipal = (UserPrincipal) request.getSession().getAttribute("user");
        userPrincipal.setFullname(fullname);
        userPrincipal.setPhone(phone);
        userPrincipal.setAddress(address);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(userPrincipal.getRole().getRoleId());
        roleDTO.setRoleName(userPrincipal.getRole().getRoleName());

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userPrincipal.getUserId());
        userDTO.setEmail(userPrincipal.getEmail());
        userDTO.setPhone(userPrincipal.getPhone());
        userDTO.setAddress(userPrincipal.getAddress());
        userDTO.setAvatar(userPrincipal.getAvatar());
        userDTO.setUserName(userPrincipal.getFullname());
        userDTO.setVerify(userPrincipal.isVerify());
        userDTO.setSex(userPrincipal.isGender());
        userDTO.setPassword(userPrincipal.getPassword());
        userDTO.setRoleDTO(roleDTO);

        InputStream avatar = avatarFile.getInputStream();

        userService.update(userDTO, avatar);
        request.setAttribute("messageSuccess", "Cập nhật thông tin thành công.");
        return "client/profile";
    }

    @PostMapping(value = "/change-password")
    public String changePassword(HttpServletRequest request, @RequestParam(name = "avatarfile") MultipartFile avatarFile) throws IOException {
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String repassword = request.getParameter("repassword");

        UserPrincipal userPrincipal = (UserPrincipal) request.getSession().getAttribute("user");
        String passwordEncoder = new BCryptPasswordEncoder().encode(oldpassword);
        request.setAttribute("oldpassword", userPrincipal.getPassword());
        request.setAttribute("passwordEncoder", passwordEncoder);
        request.setAttribute("newpassword", newpassword);
        request.setAttribute("repassword", repassword);

        if (passwordEncoder.equals(userPrincipal.getPassword()) && newpassword.equals(repassword)) {
            userPrincipal.setPassword(new BCryptPasswordEncoder().encode(oldpassword));
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(userPrincipal.getRole().getRoleId());
            roleDTO.setRoleName(userPrincipal.getRole().getRoleName());

            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(userPrincipal.getUserId());
            userDTO.setEmail(userPrincipal.getEmail());
            userDTO.setPhone(userPrincipal.getPhone());
            userDTO.setAddress(userPrincipal.getAddress());
            userDTO.setAvatar(userPrincipal.getAvatar());
            userDTO.setUserName(userPrincipal.getFullname());
            userDTO.setVerify(userPrincipal.isVerify());
            userDTO.setSex(userPrincipal.isGender());
            userDTO.setPassword(userPrincipal.getPassword());
            userDTO.setRoleDTO(roleDTO);

            InputStream avatar = avatarFile.getInputStream();

            userService.update(userDTO, avatar);
            request.getSession().setAttribute("user", userPrincipal);
            request.setAttribute("messageSuccess", "Change password successfully!");
        } else {
            request.setAttribute("messageError", "Fail! Check that you have entered the correct password.");
        }
        return "client/profile";
    }
}
