package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.FaqCategoryCondition;
import com.ycnet.dbank.dto.create.FaqCategoryCreateForm;
import com.ycnet.dbank.dto.details.FaqCategoryDetails;
import com.ycnet.dbank.dto.update.FaqCategoryUpdateForm;
import com.ycnet.dbank.service.FaqCategoryService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/faqCategory")
public class FaqCategoryController extends BaseController {

	@Autowired
	private FaqCategoryService faqCategoryService;
	
	/**
	 * 创建FaqCategory
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(FaqCategoryCreateForm form){
		return faqCategoryService.create(form);
	}
	
	/**
	 * 更新FaqCategory
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public FaqCategoryDetails update(@PathVariable Long id,FaqCategoryUpdateForm form){
		return faqCategoryService.update(id,form);
	}
	/**
	 * 删除FaqCategory
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		faqCategoryService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public FaqCategoryDetails getDetails(@PathVariable Long id){
		return faqCategoryService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<FaqCategoryDetails> query(FaqCategoryCondition condition,Pageable page){
		return faqCategoryService.query(condition,page);
	}
}
