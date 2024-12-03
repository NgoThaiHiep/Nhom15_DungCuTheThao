package iuh.se.fit.controller.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import iuh.se.fit.service.OrderService;
import iuh.se.fit.service.ProductService;
import iuh.se.fit.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class HomeAdminController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;
    
    //Hiện trang chủ admin
    @GetMapping(value = "/home")
    public String home(HttpServletRequest request, HttpSession session) {
        
        int countUser = userService.count();
        int countOrder = orderService.count();
        int countProduct = productService.count();
        double sumRevenue = orderService.sumRevenue();
        session.setAttribute("countUser", countUser);
        session.setAttribute("revenue", sumRevenue);
        session.setAttribute("countOrder", countOrder);
        session.setAttribute("countProduct", countProduct);
        request.setAttribute("orders", orderService.findAll(0, 5));
        return "admin/home";
    }
}
