package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.FaqCondition;
import com.ycnet.dbank.dto.create.FaqCreateForm;
import com.ycnet.dbank.dto.details.FaqDetails;
import com.ycnet.dbank.dto.update.FaqUpdateForm;
import com.ycnet.dbank.service.FaqService;
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
@RequestMapping("/faq")
public class FaqController extends BaseController {

	@Autowired
	private FaqService faqService;
	
	/**
	 * 创建Faq
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(FaqCreateForm form){
		return faqService.create(form);
	}
	
	/**
	 * 更新Faq
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public FaqDetails update(@PathVariable Long id,FaqUpdateForm form){
		return faqService.update(id,form);
	}
	/**
	 * 删除Faq
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		faqService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public FaqDetails getDetails(@PathVariable Long id){
		return faqService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<FaqDetails> query(FaqCondition condition,Pageable page){
		return faqService.query(condition,page);
	}
}
