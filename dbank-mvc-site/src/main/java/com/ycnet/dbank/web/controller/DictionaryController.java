package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.DictionaryCondition;
import com.ycnet.dbank.dto.create.DictionaryCreateForm;
import com.ycnet.dbank.dto.details.DictionaryDetails;
import com.ycnet.dbank.dto.update.DictionaryUpdateForm;
import com.ycnet.dbank.service.DictionaryService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {

	@Autowired
	private DictionaryService dictionaryService;
	
	/**
	 * 创建Dictionary
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(DictionaryCreateForm form){
		return dictionaryService.create(form);
	}
	
	/**
	 * 更新Dictionary
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public DictionaryDetails update(@PathVariable Long id,DictionaryUpdateForm form){
		return dictionaryService.update(id,form);
	}
	/**
	 * 删除Dictionary
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id){
		dictionaryService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public DictionaryDetails getDetails(@PathVariable Long id){
		return dictionaryService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<DictionaryDetails> query(DictionaryCondition condition,Pageable page){
		return dictionaryService.query(condition,page);
	}
}
