package kr.co.ioncares.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ioncares.dao.OrderDAO;
import kr.co.ioncares.model.Order;
import kr.co.ioncares.model.OrderDetail;
import kr.co.ioncares.service.OrderService;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDAO orderDAO;
	
	@Override
	public List<Order> getOrderList() {
		return orderDAO.getOrderList();
	}
	
	@Override
	public List<OrderDetail> getOrderDetail(OrderDetail data) {
		return orderDAO.getOrderDetail(data);
	}


}
