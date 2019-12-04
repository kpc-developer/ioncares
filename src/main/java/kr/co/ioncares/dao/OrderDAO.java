package kr.co.ioncares.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import kr.co.ioncares.model.Order;
import kr.co.ioncares.model.OrderDetail;

@Component
public interface OrderDAO {
	/**
	 * 데이터 리스트 조회
	 * @return
	 */
	public List<Order> getOrderList();
	
	public List<OrderDetail> getOrderDetail(OrderDetail data);
	
}
