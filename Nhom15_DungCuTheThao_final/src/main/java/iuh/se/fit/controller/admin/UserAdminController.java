package iuh.se.fit.controller.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import iuh.se.fit.service.RoleService;
import iuh.se.fit.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserAdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    //Hiện tất cả các tài khoản
    @GetMapping("/user-list")
    public String userList(HttpServletRequest request, HttpSession session) {
        int pageIndex = 0;
        int pageSize = 5;
        int totalPage = 0;
        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        int count = userService.count();
        if (count % 5 == 0) {
            totalPage = count / 5;
        } else {
            totalPage = count / 5 + 1;
        }
        session.setAttribute("countUser", count);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("users", userService.findAll(pageIndex, pageSize));
        return "admin/user/listUser";
    }

    // Create new account
    @GetMapping(value = "/user-create")
    public String userCreate(HttpServletRequest request) {
        request.setAttribute("roles", roleService.findAll());
        return "admin/user/createUser";
    }

    @PostMapping(value = "/user-create")
    public String userCreate(HttpServletRequest request, @RequestParam(name = "email") String email,
            @RequestParam(name = "fullName", required = false) String userName,
            @RequestParam(name = "gender") boolean sex, @RequestParam(name = "phone") String phone,
            @RequestParam(name = "address") String address, @RequestParam(name = "roleId") long roleId,
            @RequestParam(name = "password") String password, @RequestParam(name = "repassword") String repassword,
            @RequestParam(name = "avatarFile") MultipartFile avatarFile) throws IOException {

        if (userService.findByEmail(email) != null) {
            request.setAttribute("roles", roleService.findAll());
            request.setAttribute("message", "Email đã tồn tại!");
            return "admin/user/createUser";
        } else {

            UserDTO userDTO = new UserDTO();
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(roleId);

            userDTO.setEmail(email);
            userDTO.setUserName(userName);
            userDTO.setSex(sex);
            userDTO.setPhone(phone);
            userDTO.setAddress(address);
            userDTO.setRoleDTO(roleDTO);
            userDTO.setVerify(true);
            InputStream avatar = avatarFile.getInputStream();

            if (password.equals(repassword)) {
                userDTO.setPassword(new BCryptPasswordEncoder().encode(repassword));

                userService.insert(userDTO, avatar);
                return "redirect:../admin/user-list";
            } else {
                request.setAttribute("message", "Mật khẩu không khớp!");
                request.setAttribute("roles", roleService.findAll());
                return "admin/user/createUser";
            }
        }

    }
    // Update user

    @GetMapping(value = "user-update")
    public String userUpdate(HttpServletRequest request, @RequestParam(name = "userId") long userId) {
        request.setAttribute("roles", roleService.findAll());
        request.setAttribute("user", userService.findById(userId));
        return "admin/user/updateUser";
    }

    @PostMapping(value = "user-update")
    public String userUpdate(HttpServletRequest request, HttpSession session, @RequestParam(name = "userId") long userId,
            @RequestParam(name = "fullName", required = false) String userName,
            @RequestParam(name = "gender") boolean setSex, @RequestParam(name = "phone") String phone,
            @RequestParam(name = "address") String address, @RequestParam(name = "roleId") long roleId,
            @RequestParam(name = "password", required = false) String password, @RequestParam(name = "repassword", required = false) String repassword,
            @RequestParam(name = "avatarFile") MultipartFile avatarFile,
            @RequestParam(name = "avatar") String oldAvatar) throws IOException {

        UserDTO userDTO = userService.findById(userId);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleId(roleId);

        userDTO.setUserName(userName);
        userDTO.setSex(setSex);
        userDTO.setPhone(phone);
        userDTO.setAddress(address);
        userDTO.setRoleDTO(roleDTO);

        InputStream oldAvt = new ByteArrayInputStream(oldAvatar.getBytes());

        InputStream avatar = avatarFile.getInputStream();

        InputStream addAvatar = null;

        if (avatar != null) {
            addAvatar = avatar;
        } else {
            addAvatar = oldAvt;
        }

        if (password.equals(repassword) && password != null) {
            userDTO.setPassword(new BCryptPasswordEncoder().encode(repassword));
            userService.update(userDTO, addAvatar);
            return "redirect:../admin/user-list";
        } else {
            request.setAttribute("message", "Mật khẩu không khớp nhau!");
            request.setAttribute("roles", roleService.findAll());
            request.setAttribute("user", userService.findById(userId));
            return "admin/user/updateUser";
        }
    }

    // Xóa user
    @GetMapping(value = "/user-delete")
    public String userDelete(HttpServletRequest request) {
        String[] userIds = request.getParameterValues("userId");
        for (String userId : userIds) {
            userService.delete(Long.parseLong(userId));
        }
        return "redirect:/admin/user-list";
    }

}
