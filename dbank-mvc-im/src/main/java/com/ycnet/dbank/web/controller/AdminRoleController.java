package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.AdminRoleCondition;
import com.ycnet.dbank.dto.create.AdminRoleCreateForm;
import com.ycnet.dbank.dto.details.AdminRoleDetails;
import com.ycnet.dbank.dto.update.AdminRoleUpdateForm;
import com.ycnet.dbank.service.AdminRoleService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/adminRole")
public class AdminRoleController extends BaseController {

	@Autowired
	private AdminRoleService adminRoleService;
	
	/**
	 * 创建AdminRole
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(AdminRoleCreateForm form){
		return adminRoleService.create(form);
	}
	
	/**
	 * 更新AdminRole
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public AdminRoleDetails update(@PathVariable Long id,AdminRoleUpdateForm form){
		return adminRoleService.update(id,form);
	}
	/**
	 * 删除AdminRole
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		adminRoleService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AdminRoleDetails getDetails(@PathVariable Long id){
		return adminRoleService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<AdminRoleDetails> query(AdminRoleCondition condition,Pageable page){
		return adminRoleService.query(condition,page);
	}
}
