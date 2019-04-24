package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.ItemCondition;
import com.ycnet.dbank.dto.create.ItemCreateForm;
import com.ycnet.dbank.dto.details.ItemDetails;
import com.ycnet.dbank.dto.update.ItemUpdateForm;
import com.ycnet.dbank.repository.ItemRepository;
import com.ycnet.dbank.service.ItemService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public DomainCreated create(ItemCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemDetails update(Long id, ItemUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ItemDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<ItemDetails> query(ItemCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}