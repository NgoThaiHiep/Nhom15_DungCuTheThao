/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "orderdetail")
public class OrderDetail implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderdetail_id")
    private long orderDetailId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "unitprice")
    private double unitPrice;

    @Column(name = "quantity")
    private int orderDetailQuantity;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order orders;

    public OrderDetail() {
    }

    public OrderDetail(long orderDetailId, Product product, double unitPrice, int orderDetailQuantity, Order orders) {
        this.orderDetailId = orderDetailId;
        this.product = product;
        this.unitPrice = unitPrice;
        this.orderDetailQuantity = orderDetailQuantity;
        this.orders = orders;
    }

    public long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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

    public Order getOrders() {
        return orders;
    }

    public void setOrders(Order orders) {
        this.orders = orders;
    }

   
}
