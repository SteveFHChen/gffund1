package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.dto.condition.ProductCondition;
import com.ycnet.dbank.dto.create.ProductCreateForm;
import com.ycnet.dbank.dto.details.ProductDetails;
import com.ycnet.dbank.dto.details.ProductDetails2;
import com.ycnet.dbank.dto.update.ProductUpdateForm;
import com.ycnet.mirage.event.DomainCreated;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface ProductService {

	DomainCreated create(ProductCreateForm form);

	ProductDetails update(Long id, ProductUpdateForm form);

	void delete(Long id);

	ProductDetails getDetails(Long id);
	
	ProductDetails2 getDetails2(Long id);

	Page<ProductDetails> query(ProductCondition condition, Pageable page);
	
}
