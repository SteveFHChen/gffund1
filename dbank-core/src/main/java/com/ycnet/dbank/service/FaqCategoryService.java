package com.ycnet.dbank.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.FaqCategoryCondition;
import com.ycnet.dbank.dto.create.FaqCategoryCreateForm;
import com.ycnet.dbank.dto.details.FaqCategoryDetails;
import com.ycnet.dbank.dto.update.FaqCategoryUpdateForm;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface FaqCategoryService {

	DomainCreated create(FaqCategoryCreateForm form);

	FaqCategoryDetails update(Long id, FaqCategoryUpdateForm form);

	void delete(Long id);

	FaqCategoryDetails getDetails(Long id);

	Page<FaqCategoryDetails> query(FaqCategoryCondition condition, Pageable page);

	List<FaqCategoryDetails> queryList();
	
}
