package iuh.se.fit.service;

import java.util.List;

import iuh.se.fit.model.OrderDetailDTO;



public interface OrderDetailService {

	public void insert(OrderDetailDTO orderDetailDTO);
	
	public void update(OrderDetailDTO orderDetailDTO);
	
	public void delete(long orderDetailId);
	
	public List<OrderDetailDTO> findAll(int pageIndex, int pageSize);
	
	public List<OrderDetailDTO> findByOrderId(long orderId);
}
