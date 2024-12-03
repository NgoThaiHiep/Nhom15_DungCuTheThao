/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.dao;

import java.util.List;

import iuh.se.fit.entity.Order;

public interface OrderDao {

    public void insert(Order order);

    public void update(Order order);

    public void delete(long orderId);

    public List<Order> findAll(int pageIndex, int pageSize);

    public List<Order> findByBuyer(long userId);

    public int count();
    
    public double sumRevenue();

    public Order findById(long orderId);
}
