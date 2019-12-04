package kr.co.ioncares.service;

import java.util.List;

import kr.co.ioncares.model.Order;
import kr.co.ioncares.model.OrderDetail;


public interface OrderService {

	public List<Order> getOrderList();
	
	public List<OrderDetail> getOrderDetail(OrderDetail data);

}
