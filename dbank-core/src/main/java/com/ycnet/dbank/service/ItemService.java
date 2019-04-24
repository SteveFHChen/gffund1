package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.ItemCondition;
import com.ycnet.dbank.dto.create.ItemCreateForm;
import com.ycnet.dbank.dto.details.ItemDetails;
import com.ycnet.dbank.dto.update.ItemUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface ItemService {

	DomainCreated create(ItemCreateForm form);

	ItemDetails update(Long id, ItemUpdateForm form);

	void delete(Long id);

	ItemDetails getDetails(Long id);

	Page<ItemDetails> query(ItemCondition condition, Pageable page);
	
}
