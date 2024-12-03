package iuh.se.fit.controller.client;


import java.sql.Date;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import iuh.se.fit.dao.OrderDao;
import iuh.se.fit.dao.OrderDetailDao;
import iuh.se.fit.entity.Order;
import iuh.se.fit.entity.OrderDetail;
import iuh.se.fit.entity.Product;
import iuh.se.fit.entity.User;
import iuh.se.fit.model.OrderDetailDTO;
import iuh.se.fit.model.UserPrincipal;

@Controller
@RequestMapping(value = "/client")
public class CheckoutController {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @PostMapping(value = "/checkout")
    public String checkout(HttpSession session) {

        float subTotal = 0; // tong tien hang
        float fee = 5; // phi ship = 5$

        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // lay thong tin nguoi mua hang
        User user = new User();
        user.setUserId(userPrincipal.getUserId());

        Date date = new Date(new java.util.Date().getTime()); // lay ngay hien tai

        Object object = session.getAttribute("cart"); // lay danh sach gio hang tu session
        Map<Long, OrderDetailDTO> mapItem = (Map<Long, OrderDetailDTO>) object;

        for (Map.Entry<Long, OrderDetailDTO> entry : mapItem.entrySet()) {
            Long key = entry.getKey();
            OrderDetailDTO value = entry.getValue();

            subTotal += (value.getUnitPrice() * value.getOrderDetailQuantity()); // tinh tong tien hang
        }

        Order order = new Order();
        order.setPurchaseDate(date);
        order.setUser(user);
        order.setStatus("Chưa duyệt");
        order.setTotalPrice(subTotal + fee);

        orderDao.insert(order);

        // insert danh sach san pham trong don hang vao bang item
        for (Map.Entry<Long, OrderDetailDTO> entry : mapItem.entrySet()) {
            Long key = entry.getKey();
            OrderDetailDTO value = entry.getValue();

            Product product = new Product();
            product.setProductId(entry.getValue().getProductDTO().getProductId());

            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderDetailId(entry.getValue().getOrderDetailId());
            orderDetail.setProduct(product);
            orderDetail.setOrderDetailQuantity(entry.getValue().getOrderDetailQuantity());
            orderDetail.setUnitPrice(entry.getValue().getUnitPrice());
            orderDetail.setOrders(order);

            // insert vao bang item
            orderDetailDao.insert(orderDetail);
        }

        mapItem.clear();
        session.setAttribute("cart", mapItem);

        return "redirect:/client/my-order";
    }
}
