package com.ycnet.dbank.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.PersonCondition;
import com.ycnet.dbank.dto.create.PersonCreateForm;
import com.ycnet.dbank.dto.details.PersonDetails;
import com.ycnet.dbank.dto.update.PersonUpdateForm;
import com.ycnet.dbank.repository.PersonRepository;
import com.ycnet.dbank.service.PersonService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public DomainCreated create(PersonCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersonDetails update(Long id, PersonUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PersonDetails> query(PersonCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String modPassword(Long id, PersonUpdateForm form){
		//调用E帐通密码修改接口修改用户密码
		return null;
	}
	
}