package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.RechargeCondition;
import com.ycnet.dbank.dto.create.RechargeCreateForm;
import com.ycnet.dbank.dto.details.RechargeDetails;
import com.ycnet.dbank.dto.update.RechargeUpdateForm;
import com.ycnet.dbank.service.RechargeService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/recharge")
public class RechargeController extends BaseController {

	@Autowired
	private RechargeService rechargeService;
	
	/**
	 * 创建Recharge
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(RechargeCreateForm form){
		return rechargeService.create(form);
	}
	
	/**
	 * 更新Recharge
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public RechargeDetails update(@PathVariable Long id,RechargeUpdateForm form){
		return rechargeService.update(id,form);
	}
	/**
	 * 删除Recharge
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		rechargeService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public RechargeDetails getDetails(@PathVariable Long id){
		return rechargeService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<RechargeDetails> query(RechargeCondition condition,Pageable page){
		return rechargeService.query(condition,page);
	}
}
