package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.CertificationCondition;
import com.ycnet.dbank.dto.create.CertificationCreateForm;
import com.ycnet.dbank.dto.details.CertificationDetails;
import com.ycnet.dbank.dto.update.CertificationUpdateForm;
import com.ycnet.dbank.service.CertificationService;
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
@RequestMapping("/certification")
public class CertificationController extends BaseController {

	@Autowired
	private CertificationService certificationService;
	
	/**
	 * 创建Certification
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(CertificationCreateForm form){
		return certificationService.create(form);
	}
	
	/**
	 * 更新Certification
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public CertificationDetails update(@PathVariable Long id,CertificationUpdateForm form){
		return certificationService.update(id,form);
	}
	/**
	 * 删除Certification
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		certificationService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public CertificationDetails getDetails(@PathVariable Long id){
		return certificationService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<CertificationDetails> query(CertificationCondition condition,Pageable page){
		return certificationService.query(condition,page);
	}
}
