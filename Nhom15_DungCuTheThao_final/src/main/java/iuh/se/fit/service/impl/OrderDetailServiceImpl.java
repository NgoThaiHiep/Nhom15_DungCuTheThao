/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.service.impl;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.OrderDetailDao;
import iuh.se.fit.entity.Order;
import iuh.se.fit.entity.OrderDetail;
import iuh.se.fit.entity.Product;
import iuh.se.fit.model.OrderDTO;
import iuh.se.fit.model.OrderDetailDTO;
import iuh.se.fit.model.ProductDTO;
import iuh.se.fit.model.SaleDTO;
import iuh.se.fit.service.OrderDetailService;


@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public void insert(OrderDetailDTO orderDetailDTO) {
        Product product = new Product();
        product.setProductId(orderDetailDTO.getProductDTO().getProductId());
        Order order = new Order();
        order.setOrderId(orderDetailDTO.getOrderDTO().getOrderId());

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailId(orderDetailDTO.getOrderDetailId());
        orderDetail.setProduct(product);
        orderDetail.setUnitPrice(orderDetailDTO.getUnitPrice());
        orderDetail.setOrderDetailQuantity(orderDetailDTO.getOrderDetailQuantity());
        orderDetail.setOrders(order);

        orderDetailDao.insert(orderDetail);
    }

    @Override
    public void update(OrderDetailDTO orderDetailDTO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long orderDetail_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetailDTO> findAll(int pageIndex, int pageSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<OrderDetailDTO> findByOrderId(long order_id) {
        List<OrderDetail> orderDetails = orderDetailDao.findByOrderId(order_id);
        List<OrderDetailDTO> itemDTOs = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetails) {

            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setOrderId(orderDetail.getOrders().getOrderId());

            SaleDTO saleDTO = new SaleDTO();
            saleDTO.setSaleId(orderDetail.getProduct().getSale().getSaleId());
            saleDTO.setPercent(orderDetail.getProduct().getSale().getPercent());

            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductId(orderDetail.getProduct().getProductId());

            
            Blob blob = orderDetail.getProduct().getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
           
            productDTO.setProductName(orderDetail.getProduct().getProductName());
            productDTO.setPrice(orderDetail.getProduct().getPrice());
            productDTO.setSaleDTO(saleDTO);

            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.setOrderDetailId(orderDetail.getOrderDetailId());

            orderDetailDTO.setOrderDetailQuantity(orderDetail.getOrderDetailQuantity());
            orderDetailDTO.setUnitPrice(orderDetail.getUnitPrice());

            orderDetailDTO.setOrderDTO(orderDTO);
            orderDetailDTO.setProductDTO(productDTO);

            itemDTOs.add(orderDetailDTO);
        }
        return itemDTOs;
    }

}
