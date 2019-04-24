package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AccountCondition;
import com.ycnet.dbank.dto.create.AccountCreateForm;
import com.ycnet.dbank.dto.details.AccountDetails;
import com.ycnet.dbank.dto.update.AccountUpdateForm;
import com.ycnet.dbank.service.AccountService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {

	@Autowired
	private AccountService accountService;
	
	/**
	 * 创建Account
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(AccountCreateForm form){
		return accountService.create(form);
	}
	
	/**
	 * 更新Account
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public AccountDetails update(@PathVariable Long id,AccountUpdateForm form){
		return accountService.update(id,form);
	}
	/**
	 * 删除Account
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		accountService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AccountDetails getDetails(@PathVariable Long id){
		return accountService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<AccountDetails> query(AccountCondition condition,Pageable page){
		return accountService.query(condition,page);
	}
}
