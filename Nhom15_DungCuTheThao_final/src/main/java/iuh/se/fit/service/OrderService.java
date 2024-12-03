package iuh.se.fit.service;


import java.util.List;

import iuh.se.fit.model.OrderDTO;

public interface OrderService {

	public void insert(OrderDTO orderDTO);
	
	public void update(OrderDTO orderDTO);
	
	public void delete(long orderId);
	
	public List<OrderDTO> findAll(int pageIndex, int pageSize);
	
	public List<OrderDTO> findByBuyer(long userId);
	
	public int count();
	
        public double sumRevenue();
        
	public OrderDTO findById(long orderId);
	
}
