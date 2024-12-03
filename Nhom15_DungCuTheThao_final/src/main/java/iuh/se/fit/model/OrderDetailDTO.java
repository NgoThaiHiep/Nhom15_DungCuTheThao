/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.model;


public class OrderDetailDTO {

    private long orderDetailId;

    private ProductDTO productDTO;

    private double unitPrice;

    private int orderDetailQuantity;

    private OrderDTO orderDTO;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(long orderDetailId, ProductDTO productDTO, double unitPrice, int orderDetailQuantity, OrderDTO orderDTO) {
        this.orderDetailId = orderDetailId;
        this.productDTO = productDTO;
        this.unitPrice = unitPrice;
        this.orderDetailQuantity = orderDetailQuantity;
        this.orderDTO = orderDTO;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public ProductDTO getProductDTO() {
        return productDTO;
    }

    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderDetailQuantity() {
        return orderDetailQuantity;
    }

    public void setOrderDetailQuantity(int orderDetailQuantity) {
        this.orderDetailQuantity = orderDetailQuantity;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }

    public void setOrderDTO(OrderDTO orderDTO) {
        this.orderDTO = orderDTO;
    }

    
}
