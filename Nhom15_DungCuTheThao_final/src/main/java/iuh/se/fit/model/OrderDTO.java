/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;

import java.util.Date;
import java.util.List;


public class OrderDTO {

    private long orderId;
    
    private Date purchaseDate;
    
    private String status;
    
    private double totalPrice;
    
    private UserDTO userDTO;
    
    private List<OrderDetailDTO> orderDetailDTOs;

    public OrderDTO() {
    }

    public OrderDTO(long orderId, Date purchaseDate, String status, double totalPrice, UserDTO userDTO, List<OrderDetailDTO> orderDetailDTOs) {
        this.orderId = orderId;
        this.purchaseDate = purchaseDate;
        this.status = status;
        this.totalPrice = totalPrice;
        this.userDTO = userDTO;
        this.orderDetailDTOs = orderDetailDTOs;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public List<OrderDetailDTO> getOrderDetailDTOs() {
        return orderDetailDTOs;
    }

    public void setOrderDetailDTOs(List<OrderDetailDTO> orderDetailDTOs) {
        this.orderDetailDTOs = orderDetailDTOs;
    }

    
}
