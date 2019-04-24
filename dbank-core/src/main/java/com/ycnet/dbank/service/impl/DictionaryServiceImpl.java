package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.DictionaryCondition;
import com.ycnet.dbank.dto.create.DictionaryCreateForm;
import com.ycnet.dbank.dto.details.DictionaryDetails;
import com.ycnet.dbank.dto.update.DictionaryUpdateForm;
import com.ycnet.dbank.repository.DictionaryRepository;
import com.ycnet.dbank.service.DictionaryService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class DictionaryServiceImpl implements DictionaryService {
	
	@Autowired
	private DictionaryRepository dictionaryRepository;

	@Override
	public DomainCreated create(DictionaryCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DictionaryDetails update(Long id, DictionaryUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DictionaryDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<DictionaryDetails> query(DictionaryCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
}