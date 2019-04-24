package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.ProductCondition;
import com.ycnet.dbank.dto.create.ProductCreateForm;
import com.ycnet.dbank.dto.details.ProductDetails;
import com.ycnet.dbank.dto.update.ProductUpdateForm;
import com.ycnet.dbank.service.ProductService;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/product")
public class ProductController extends BaseController {

	@Autowired
	private ProductService productService;
	
	/**
	 * 创建Product
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(ProductCreateForm form){
		return productService.create(form);
	}
	
	/**
	 * 更新Product
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public ProductDetails update(@PathVariable Long id,ProductUpdateForm form){
		return productService.update(id,form);
	}
	/**
	 * 删除Product
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		productService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ProductDetails getDetails(@PathVariable Long id){
		return productService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<ProductDetails> query(ProductCondition condition,Pageable page){
		return productService.query(condition,page);
	}
}
