package iuh.se.fit.controller.client;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iuh.se.fit.model.OrderDetailDTO;
import iuh.se.fit.model.ProductDTO;
import iuh.se.fit.service.ProductService;

@Controller
@RequestMapping(value = "/client")
public class CartClientController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/cart")
    public String cart(HttpServletRequest request, HttpSession session) {
        Object object = session.getAttribute("cart");
        int totalQuantity = 0;
        float subTotal = 0;
        float grandTotal = 0;
        if (object != null) {
            HashMap<Long, OrderDetailDTO> mapOD = (HashMap<Long, OrderDetailDTO>) object;
            for (Map.Entry<Long, OrderDetailDTO> entry : mapOD.entrySet()) {
                Long key = entry.getKey();
                OrderDetailDTO value = entry.getValue();
                totalQuantity += value.getOrderDetailQuantity();
                subTotal += (value.getUnitPrice() * value.getOrderDetailQuantity());
            }
            grandTotal = subTotal + 30000;
        }
        session.setAttribute("totalQuantity", totalQuantity);
        session.setAttribute("subTotal", subTotal);
        session.setAttribute("grandTotal", grandTotal);//Vẫn còn tồn tại khi sang web khác
        return "client/cart";
    }

    // Add product to cart
    @GetMapping(value = "/add-to-cart")
    public String addToCart(HttpServletRequest request, HttpSession session,
            @RequestParam(name = "productId") long productId) {

        ProductDTO productDTO = productService.findById(productId); // lay thong tin cua san pham khi nguoi dung chon mua
        double unitPrice = productDTO.getPrice() - Math.round((productDTO.getPrice() * productDTO.getSaleDTO().getPercent() / 100));

        Object object = session.getAttribute("cart"); // lay danh sach san pham trong gio hang tren session

        if (object == null) { // neu gio hang trong => them san pham vao gio hang va tao session moi chua gio hang
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setProductDTO(productDTO);
            orderDetailDTO.setUnitPrice(unitPrice);
            orderDetailDTO.setOrderDetailQuantity(1);
            Map<Long, OrderDetailDTO> mapItem = new HashMap<Long, OrderDetailDTO>();
            mapItem.put(productId, orderDetailDTO); // luu san pham vao map(gio hang) voi key = id cua san pham
            session.setAttribute("cart", mapItem); // luu gio hang vao session
        } else {  // neu gio hang da co san pham
            Map<Long, OrderDetailDTO> mapOD = (Map<Long, OrderDetailDTO>) object;
            if (mapOD.get(productId) == null) { // neu san pham chua co trong gio hang => them san pham vao gio hang
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                orderDetailDTO.setProductDTO(productDTO);
                orderDetailDTO.setUnitPrice(unitPrice);
                orderDetailDTO.setOrderDetailQuantity(1);
                mapOD.put(productId, orderDetailDTO); // luu san pham vao gio hang
            } else { // neu san pham da co trong gio hang => tang so luong san pham do trong gio hang len
                OrderDetailDTO orderDetailDTO = mapOD.get(productId);
                int quantity = orderDetailDTO.getOrderDetailQuantity();
                if (quantity < 5) {
                    orderDetailDTO.setOrderDetailQuantity(quantity + 1);
                }
            }
            session.setAttribute("cart", mapOD);
        }
        return "redirect:../client/cart";
    }

    @PostMapping(value = "/add-to-cart")
    public String addToCart(HttpSession session, @RequestParam(name = "productId") long productId,
            @RequestParam(name = "quantity") int quantity) {
        ProductDTO productDTO = productService.findById(productId);
        double unitPrice = productDTO.getPrice() - Math.round((productDTO.getPrice() * productDTO.getSaleDTO().getPercent()/ 100));

        Object object = session.getAttribute("cart");
        if (object == null) {
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setProductDTO(productDTO);
            orderDetailDTO.setOrderDetailQuantity(quantity);
            orderDetailDTO.setUnitPrice(unitPrice);
            Map<Long, OrderDetailDTO> mapOD = new HashMap<Long, OrderDetailDTO>();
            mapOD.put(productId, orderDetailDTO);
            session.setAttribute("cart", mapOD);
        } else {
            Map<Long, OrderDetailDTO> mapOD = (Map<Long, OrderDetailDTO>) object;
            if (mapOD.get(productId) == null) {
                OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
                orderDetailDTO.setProductDTO(productDTO);
                orderDetailDTO.setOrderDetailQuantity(quantity);
                orderDetailDTO.setUnitPrice(unitPrice);
                mapOD.put(productId, orderDetailDTO);
            } else {
                OrderDetailDTO orderDetailDTO = mapOD.get(productId);
                orderDetailDTO.setOrderDetailQuantity(quantity);
            }
            session.setAttribute("cart", mapOD);
        }

        return "redirect:../client/cart";
    }

    // Detele product from cart
    @GetMapping(value = "/delete-from-cart")
    public String deleteFromCart(HttpServletRequest request, HttpSession session,
            @RequestParam(name = "productId") long productId) {

        Object object = session.getAttribute("cart");
        Map<Long, OrderDetailDTO> mapItem = (Map<Long, OrderDetailDTO>) object;
        mapItem.remove(productId);
        session.setAttribute("cart", mapItem);
        return "redirect:../client/cart";
    }
}
