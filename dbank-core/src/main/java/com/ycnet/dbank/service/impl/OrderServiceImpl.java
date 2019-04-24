package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Advertise;
import com.ycnet.dbank.domain.Order;
import com.ycnet.dbank.domain.Person;
import com.ycnet.dbank.dto.condition.OrderCondition;
import com.ycnet.dbank.dto.create.OrderCreateForm;
import com.ycnet.dbank.dto.details.OrderDetails;
import com.ycnet.dbank.dto.update.OrderUpdateForm;
import com.ycnet.dbank.repository.OrderRepository;
import com.ycnet.dbank.repository.spec.OrderSpec;
import com.ycnet.dbank.service.OrderService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public DomainCreated create(OrderCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails update(Long id, OrderUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<OrderDetails> query(OrderCondition condition, Pageable page) {
		Page<Order> rst = orderRepository.findAll(new OrderSpec(condition), page);
		return MirageUtils.toDto(rst, new Transformer(){
			@Override
			public Object transform(Object input){
				OrderDetails od = MirageUtils.toDto(OrderDetails.class, (Order)input);
				od.setOrderId(((Order)input).getId());
				Person person = ((Order)input).getPerson();
				od.setPersonName(person.getUsername());
				od.setPhone(person.getPhone());
				return od;
			}
		});
	}
	
}