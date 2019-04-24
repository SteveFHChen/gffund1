package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.LogCondition;
import com.ycnet.dbank.dto.create.LogCreateForm;
import com.ycnet.dbank.dto.details.LogDetails;
import com.ycnet.dbank.dto.update.LogUpdateForm;
import com.ycnet.dbank.service.LogService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/log")
public class LogController extends BaseController {

	@Autowired
	private LogService logService;
	
	/**
	 * 创建Log
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(LogCreateForm form){
		return logService.create(form);
	}
	
	/**
	 * 更新Log
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public LogDetails update(@PathVariable Long id,LogUpdateForm form){
		return logService.update(id,form);
	}
	/**
	 * 删除Log
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		logService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public LogDetails getDetails(@PathVariable Long id){
		return logService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<LogDetails> query(LogCondition condition,Pageable page){
		return logService.query(condition,page);
	}
}
