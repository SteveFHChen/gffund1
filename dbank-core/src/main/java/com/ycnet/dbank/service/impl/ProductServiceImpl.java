package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Product;
import com.ycnet.dbank.dto.condition.ProductCondition;
import com.ycnet.dbank.dto.create.ProductCreateForm;
import com.ycnet.dbank.dto.details.ProductDetails;
import com.ycnet.dbank.dto.details.ProductDetails2;
import com.ycnet.dbank.dto.update.ProductUpdateForm;
import com.ycnet.dbank.repository.ProductRepository;
import com.ycnet.dbank.repository.spec.ProductSpec;
import com.ycnet.dbank.service.ProductService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public DomainCreated create(ProductCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDetails update(Long id, ProductUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDetails getDetails(Long id) {
		Product product = productRepository.findOne(id);
		return MirageUtils.toDto(ProductDetails.class, product);
	}
	
	@Override
	public ProductDetails2 getDetails2(Long id) {
		Product product = productRepository.findOne(id);
		return MirageUtils.toDto(ProductDetails2.class, product);
	}

	@Override
	public Page<ProductDetails> query(ProductCondition condition, Pageable page) {
		Page<Product> pages = productRepository.findAll(new ProductSpec(condition), page);
		
		return MirageUtils.toDto(pages, new Transformer() {
			
			@Override
			public Object transform(Object input) {
				Product product = (Product) input;
				return MirageUtils.toDto(ProductDetails.class, product);
			}
		});
	}
	
}