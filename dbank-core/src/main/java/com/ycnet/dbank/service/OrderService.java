package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.OrderCondition;
import com.ycnet.dbank.dto.create.OrderCreateForm;
import com.ycnet.dbank.dto.details.OrderDetails;
import com.ycnet.dbank.dto.update.OrderUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface OrderService {

	DomainCreated create(OrderCreateForm form);

	OrderDetails update(Long id, OrderUpdateForm form);

	void delete(Long id);

	OrderDetails getDetails(Long id);

	Page<OrderDetails> query(OrderCondition condition, Pageable page);
	
}
