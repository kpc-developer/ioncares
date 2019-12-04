package kr.co.ioncares.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.ioncares.model.OrderDetail;


@Controller
public class MainController {

	
	@RequestMapping(value={"", "/"}, method = RequestMethod.GET)
    public String index()
    {
        return "redirect:/Main";
    }


    @RequestMapping(value="/Main", method = RequestMethod.GET)
    public String Main()
    {
        return "orderListForm";
    }
    
    @RequestMapping(value="/orderDetail", method = RequestMethod.GET)
    public String orderDetail(OrderDetail data)
    {
        return "orderDetailForm";
    }
    
    
}
