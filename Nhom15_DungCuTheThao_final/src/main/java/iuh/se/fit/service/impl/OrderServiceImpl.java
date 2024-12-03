package iuh.se.fit.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.OrderDao;
import iuh.se.fit.entity.Order;
import iuh.se.fit.entity.User;
import iuh.se.fit.model.OrderDTO;
import iuh.se.fit.model.UserDTO;
import iuh.se.fit.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    public void insert(OrderDTO orderDTO) {
        User user = new User();
        user.setUserId(orderDTO.getUserDTO().getUserId());

        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setPurchaseDate(orderDTO.getPurchaseDate());
        order.setStatus(orderDTO.getStatus());
        order.setTotalPrice(order.getTotalPrice());
        order.setUser(user);

        orderDao.insert(order);

    }

    public void update(OrderDTO orderDTO) {
        User user = new User();
        user.setUserId(orderDTO.getUserDTO().getUserId());
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setPurchaseDate(orderDTO.getPurchaseDate());
        order.setStatus(orderDTO.getStatus());
        order.setTotalPrice(orderDTO.getTotalPrice());
        order.setUser(user);
        orderDao.update(order);

    }

    public void delete(long maHD) {

    }

    public List<OrderDTO> findAll(int pageIndex, int pageSize) {
        List<Order> orders = orderDao.findAll(pageIndex, pageSize);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        

        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        for (Order order : orders) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(order.getUser().getUserId());
            userDTO.setEmail(order.getUser().getEmail());
            userDTO.setAddress(order.getUser().getAddress());
            userDTO.setPhone(order.getUser().getPhone());
            userDTO.setUserName(order.getUser().getUserName());

            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());

            String strPurchaseDate = sdf.format(order.getPurchaseDate());
//            Date.valueOf(strPurchaseDate)
            orderDTO.setPurchaseDate(order.getPurchaseDate());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setTotalPrice(order.getTotalPrice());
            orderDTO.setUserDTO(userDTO);
            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    public List<OrderDTO> findByBuyer(long user_id) {
        List<Order> orders = orderDao.findByBuyer(user_id);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(order.getOrderId());

//            String strPurchaseDate = sdf.format(order.getPurchaseDate());
            orderDTO.setPurchaseDate(order.getPurchaseDate());
            orderDTO.setStatus(order.getStatus());
            orderDTO.setTotalPrice(order.getTotalPrice());
            orderDTOs.add(orderDTO);
        }

        return orderDTOs;
    }

    public int count() {
        return orderDao.count();
    }

    @Override
    public double sumRevenue() {
        return orderDao.sumRevenue();
    }
    
    public OrderDTO findById(long order_id) {
        Order order = orderDao.findById(order_id);
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(order.getUser().getUserId());
        userDTO.setEmail(order.getUser().getEmail());
        userDTO.setAddress(order.getUser().getAddress());
        userDTO.setPhone(order.getUser().getPhone());
        userDTO.setUserName(order.getUser().getUserName());

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setPurchaseDate(order.getPurchaseDate());
        orderDTO.setStatus(order.getStatus());
        orderDTO.setTotalPrice(order.getTotalPrice());
        orderDTO.setUserDTO(userDTO);

        return orderDTO;
    }
}