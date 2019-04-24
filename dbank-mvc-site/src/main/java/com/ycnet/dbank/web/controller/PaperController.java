package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.PaperCondition;
import com.ycnet.dbank.dto.create.PaperCreateForm;
import com.ycnet.dbank.dto.details.PaperDetails;
import com.ycnet.dbank.dto.update.PaperUpdateForm;
import com.ycnet.dbank.service.PaperService;
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
@RequestMapping("/paper")
public class PaperController extends BaseController {

	@Autowired
	private PaperService paperService;
	
	/**
	 * 创建Paper
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(PaperCreateForm form){
		return paperService.create(form);
	}
	
	/**
	 * 更新Paper
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public PaperDetails update(@PathVariable Long id,PaperUpdateForm form){
		return paperService.update(id,form);
	}
	/**
	 * 删除Paper
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		paperService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public PaperDetails getDetails(@PathVariable Long id){
		return paperService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<PaperDetails> query(PaperCondition condition,Pageable page){
		return paperService.query(condition,page);
	}
}
