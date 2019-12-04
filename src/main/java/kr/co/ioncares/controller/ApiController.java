package kr.co.ioncares.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import kr.co.ioncares.model.ApiRequestResult;
import kr.co.ioncares.model.Order;
import kr.co.ioncares.model.OrderDetail;
import kr.co.ioncares.service.OrderService;


@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private OrderService orderService;
	
	
	@RequestMapping(value="/getOrderList", method = RequestMethod.POST )
    public ApiRequestResult getOrderList()
    {
		
	 try
		{
		 	

			List<Order> dataList = null;
			dataList = orderService.getOrderList();
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("dataList", dataList);
			
			return new ApiRequestResult(result);
		}
		catch(Exception ex)
		{
			return new ApiRequestResult(ex);
		}
    }
	
	@RequestMapping(value="/getOrderDetail", method = RequestMethod.POST )
    public ApiRequestResult monthList(OrderDetail data)
    {
	 try
		{
			List<OrderDetail> dataList = null;
			
			dataList = orderService.getOrderDetail(data);
			Map<String, Object> result = new HashMap<String, Object>();
			result.put("dataList", dataList);
			
			return new ApiRequestResult(result);
		}
		catch(Exception ex)
		{
			return new ApiRequestResult(ex);
		}
    }
	
}
