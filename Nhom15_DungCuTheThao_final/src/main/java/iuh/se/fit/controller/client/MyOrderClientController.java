package iuh.se.fit.controller.client;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.model.OrderDetailDTO;
import iuh.se.fit.model.UserPrincipal;
import iuh.se.fit.service.OrderDetailService;
import iuh.se.fit.service.OrderService;

@Controller
@RequestMapping(value = "/client")
public class MyOrderClientController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping(value = "/my-order")
    public String myOrder(HttpServletRequest request) {
        UserPrincipal userPrincipal = (UserPrincipal) request.getSession().getAttribute("user");
        long userId = (long) userPrincipal.getUserId();
        request.setAttribute("orders", orderService.findByBuyer(userId));
        return "client/my_order";
    }

    @GetMapping(value = "order-details")
    public String orderDetails(HttpServletRequest request, @RequestParam(name = "orderId") long orderId) {
        List<OrderDetailDTO> orderDetailDTOs = orderDetailService.findByOrderId(orderId);
        float subTotal = 0;
        for (OrderDetailDTO orderDetailDTO : orderDetailDTOs) {
            subTotal += (orderDetailDTO.getUnitPrice() * orderDetailDTO.getOrderDetailQuantity());
        }
        float grandTotal = subTotal + 5;
        request.setAttribute("subTotal", subTotal);
        request.setAttribute("grandTotal", grandTotal);
        request.setAttribute("ods", orderDetailDTOs);
        return "client/order_details";
    }
}
