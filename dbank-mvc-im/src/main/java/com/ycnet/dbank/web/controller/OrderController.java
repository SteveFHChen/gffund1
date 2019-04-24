package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.OrderCondition;
import com.ycnet.dbank.dto.create.OrderCreateForm;
import com.ycnet.dbank.dto.details.OrderDetails;
import com.ycnet.dbank.dto.update.OrderUpdateForm;
import com.ycnet.dbank.service.OrderService;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
  * 订单开放接口
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/order")
public class OrderController extends BaseController {

	@Autowired
	private OrderService orderService;
	
	
	/**
	 * 创建Order
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(OrderCreateForm form){
		return orderService.create(form);
	}
	
	/**
	 * 更新Order
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public OrderDetails update(@PathVariable Long id,OrderUpdateForm form){
		return orderService.update(id,form);
	}
	/**
	 * 删除Order
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		orderService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public OrderDetails getDetails(@PathVariable Long id){
		return orderService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page",method = RequestMethod.GET)
	public Page<OrderDetails> query(OrderCondition condition,Pageable page){
		return orderService.query(condition,page);
	}
}
