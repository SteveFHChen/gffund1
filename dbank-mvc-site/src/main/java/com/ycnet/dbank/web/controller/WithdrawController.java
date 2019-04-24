package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.WithdrawCondition;
import com.ycnet.dbank.dto.create.WithdrawCreateForm;
import com.ycnet.dbank.dto.details.WithdrawDetails;
import com.ycnet.dbank.dto.update.WithdrawUpdateForm;
import com.ycnet.dbank.service.WithdrawService;
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
@RequestMapping("/withdraw")
public class WithdrawController extends BaseController {

	@Autowired
	private WithdrawService withdrawService;
	
	/**
	 * 创建Withdraw
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(WithdrawCreateForm form){
		return withdrawService.create(form);
	}
	
	/**
	 * 更新Withdraw
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public WithdrawDetails update(@PathVariable Long id,WithdrawUpdateForm form){
		return withdrawService.update(id,form);
	}
	/**
	 * 删除Withdraw
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		withdrawService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public WithdrawDetails getDetails(@PathVariable Long id){
		return withdrawService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<WithdrawDetails> query(WithdrawCondition condition,Pageable page){
		return withdrawService.query(condition,page);
	}
}
