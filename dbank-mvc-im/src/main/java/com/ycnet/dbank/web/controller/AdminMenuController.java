package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AdminMenuCondition;
import com.ycnet.dbank.dto.create.AdminMenuCreateForm;
import com.ycnet.dbank.dto.details.AdminMenuDetails;
import com.ycnet.dbank.dto.update.AdminMenuUpdateForm;
import com.ycnet.dbank.service.AdminMenuService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/adminMenu")
public class AdminMenuController extends BaseController {

	@Autowired
	private AdminMenuService adminMenuService;
	
	/**
	 * 创建AdminMenu
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(AdminMenuCreateForm form){
		return adminMenuService.create(form);
	}
	
	/**
	 * 更新AdminMenu
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public AdminMenuDetails update(@PathVariable Long id,AdminMenuUpdateForm form){
		return adminMenuService.update(id,form);
	}
	/**
	 * 删除AdminMenu
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		adminMenuService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AdminMenuDetails getDetails(@PathVariable Long id){
		return adminMenuService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<AdminMenuDetails> query(AdminMenuCondition condition,Pageable page){
		return adminMenuService.query(condition,page);
	}
}
