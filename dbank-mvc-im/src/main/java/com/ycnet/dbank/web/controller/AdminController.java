package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.dto.condition.AdminCondition;
import com.ycnet.dbank.dto.details.AdminDetails;
import com.ycnet.dbank.service.AdminService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/admin")
public class AdminController extends BaseController {

	@Autowired
	private AdminService adminService;
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AdminDetails getDetails(@PathVariable Long id){
		return adminService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public Page<AdminDetails> query(AdminCondition condition,Pageable page){
		return adminService.query(condition,page);
	}
}
