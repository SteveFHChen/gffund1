package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.OptionCondition;
import com.ycnet.dbank.dto.create.OptionCreateForm;
import com.ycnet.dbank.dto.details.OptionDetails;
import com.ycnet.dbank.dto.update.OptionUpdateForm;
import com.ycnet.dbank.service.OptionService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/option")
public class OptionController extends BaseController {

	@Autowired
	private OptionService optionService;
	
	/**
	 * 创建Option
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(OptionCreateForm form){
		return optionService.create(form);
	}
	
	/**
	 * 更新Option
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public OptionDetails update(@PathVariable Long id,OptionUpdateForm form){
		return optionService.update(id,form);
	}
	/**
	 * 删除Option
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		optionService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public OptionDetails getDetails(@PathVariable Long id){
		return optionService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<OptionDetails> query(OptionCondition condition,Pageable page){
		return optionService.query(condition,page);
	}
}
