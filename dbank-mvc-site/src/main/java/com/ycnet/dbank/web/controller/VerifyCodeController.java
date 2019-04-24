package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.VerifyCodeCondition;
import com.ycnet.dbank.dto.create.VerifyCodeCreateForm;
import com.ycnet.dbank.dto.details.VerifyCodeDetails;
import com.ycnet.dbank.dto.update.VerifyCodeUpdateForm;
import com.ycnet.dbank.service.VerifyCodeService;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@RestController
@RequestMapping("/verifyCode")
public class VerifyCodeController extends BaseController {

	@Autowired
	private VerifyCodeService verifyCodeService;
	
	/**
	 * 创建VerifyCode
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(VerifyCodeCreateForm form){
		return verifyCodeService.create(form);
	}
	
	/**
	 * 更新VerifyCode
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public VerifyCodeDetails update(@PathVariable Long id,VerifyCodeUpdateForm form){
		return verifyCodeService.update(id,form);
	}
	/**
	 * 删除VerifyCode
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		verifyCodeService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public VerifyCodeDetails getDetails(@PathVariable Long id){
		return verifyCodeService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<VerifyCodeDetails> query(VerifyCodeCondition condition,Pageable page){
		return verifyCodeService.query(condition,page);
	}
}
