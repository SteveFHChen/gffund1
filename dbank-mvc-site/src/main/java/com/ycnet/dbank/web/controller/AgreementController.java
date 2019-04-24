package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.AgreementCondition;
import com.ycnet.dbank.dto.create.AgreementCreateForm;
import com.ycnet.dbank.dto.details.AgreementDetails;
import com.ycnet.dbank.dto.update.AgreementUpdateForm;
import com.ycnet.dbank.service.AgreementService;
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
@RequestMapping("/agreement")
public class AgreementController extends BaseController {

	@Autowired
	private AgreementService agreementService;
	
	/**
	 * 创建Agreement
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(AgreementCreateForm form){
		return agreementService.create(form);
	}
	
	/**
	 * 更新Agreement
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public AgreementDetails update(@PathVariable Long id,AgreementUpdateForm form){
		return agreementService.update(id,form);
	}
	/**
	 * 删除Agreement
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		agreementService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public AgreementDetails getDetails(@PathVariable Long id){
		return agreementService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<AgreementDetails> query(AgreementCondition condition,Pageable page){
		return agreementService.query(condition,page);
	}
}
