package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.dto.condition.FaqCategoryCondition;
import com.ycnet.dbank.dto.create.FaqCategoryCreateForm;
import com.ycnet.dbank.dto.details.FaqCategoryDetails;
import com.ycnet.dbank.dto.update.FaqCategoryUpdateForm;
import com.ycnet.dbank.service.FaqCategoryService;
import com.ycnet.mirage.event.DomainCreated;

/**
 * @author shine
 *后台帮助分类
 */
@RestController
@RequestMapping("/faqCategory")
public class FaqCategoryController extends BaseController {
	
	@Autowired
	FaqCategoryService faqCategoryService;
	
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(FaqCategoryCreateForm form){
		return faqCategoryService.create(form);
	}
	
	@RequestMapping("/query")
	public Page<FaqCategoryDetails> query(FaqCategoryCondition condition, Pageable page) {
		return faqCategoryService.query(condition, page);
	}
	
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public FaqCategoryDetails update(Long id,FaqCategoryUpdateForm form){
		return faqCategoryService.update(id,form);
	}
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public void delete(Long id){
		faqCategoryService.delete(id);
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getDetailsById",method = RequestMethod.GET)
	public FaqCategoryDetails getDetails(Long id){
		return faqCategoryService.getDetails(id);
	}
	
}
