    package iuh.se.fit.controller.client;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.service.ProductCategoryService;
import iuh.se.fit.service.ProductService;



@Controller
@RequestMapping(value = "/client")
public class HomeClientController {

	 @Autowired
	    private JavaMailSender javaMailSender;  
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private ProductCategoryService categoryService;

    /*
	* @RequestMapping(value = "/home", method = RequestMethod.GET) public
	* ModelAndView homePage() { ModelAndView mav = new ModelAndView("client/home");
	* return mav; }
     */
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String hotProducts(HttpServletRequest request, HttpSession session) {
        request.setAttribute("hotOne", productService.hotProducts(0, 11));
//        request.setAttribute("featuredOne", productService.featuredProducts(0, 4));
        session.setAttribute("categories", categoryService.findAll());
        return "/client/home";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String showInfo(){
        return "/client/info";
    }
    
    @PostMapping(value = "/send-contact")
    public String sendContact(
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("subject") String subject,
            @RequestParam("message") String message) {

        // Tạo nội dung email
        String emailContent =
                "Thông tin liên hệ từ khách hàng: \n\n" +
                "Họ và tên: " + name + "\n" +
                "Email: " + email + "\n" +
                "Tiêu đề: " + subject + "\n" +
                "Nội dung:\n" + message;

        // Tạo đối tượng SimpleMailMessage
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("ngohiep1750@gmail.com"); // Địa chỉ nhận cố định
        mailMessage.setSubject(subject); // Tiêu đề email
        mailMessage.setText(emailContent); // Nội dung email
        mailMessage.setFrom(email); // Địa chỉ email gửi là email của khách hàng nhập

        // Gửi email
        javaMailSender.send(mailMessage);

        // Chuyển hướng về trang xác nhận
        return "redirect:/client/info";
    }
    
}
