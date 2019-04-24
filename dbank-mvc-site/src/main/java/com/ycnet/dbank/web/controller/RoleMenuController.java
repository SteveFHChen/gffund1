package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.RoleMenuCondition;
import com.ycnet.dbank.dto.create.RoleMenuCreateForm;
import com.ycnet.dbank.dto.details.RoleMenuDetails;
import com.ycnet.dbank.dto.update.RoleMenuUpdateForm;
import com.ycnet.dbank.service.RoleMenuService;
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
@RequestMapping("/roleMenu")
public class RoleMenuController extends BaseController {

	@Autowired
	private RoleMenuService roleMenuService;
	
	/**
	 * 创建RoleMenu
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(RoleMenuCreateForm form){
		return roleMenuService.create(form);
	}
	
	/**
	 * 更新RoleMenu
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public RoleMenuDetails update(@PathVariable Long id,RoleMenuUpdateForm form){
		return roleMenuService.update(id,form);
	}
	/**
	 * 删除RoleMenu
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		roleMenuService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public RoleMenuDetails getDetails(@PathVariable Long id){
		return roleMenuService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<RoleMenuDetails> query(RoleMenuCondition condition,Pageable page){
		return roleMenuService.query(condition,page);
	}
}
