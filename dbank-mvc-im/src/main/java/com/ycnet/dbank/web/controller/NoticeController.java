package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.NoticeCondition;
import com.ycnet.dbank.dto.create.NoticeCreateForm;
import com.ycnet.dbank.dto.details.NoticeDetails;
import com.ycnet.dbank.dto.update.NoticeUpdateForm;
import com.ycnet.dbank.service.NoticeService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.web.support.PageRequest;
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
@RequestMapping("/notice")
public class NoticeController extends BaseController {

	@Autowired
	private NoticeService noticeService;
	
	/**
	 * 创建Notice
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(NoticeCreateForm form){
		return noticeService.create(form);
	}
	
	/**
	 * 更新Notice
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public NoticeDetails update(@PathVariable Long id,NoticeUpdateForm form){
		return noticeService.update(id,form);
	}
	/**
	 * 删除Notice
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		noticeService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public NoticeDetails getDetails(@PathVariable Long id){
		return noticeService.getDetails(id);
	}
	/**
	 * 分页查询公告列表
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<NoticeDetails> query(NoticeCondition condition, PageRequest page){
		return noticeService.query(condition,page);
	}
}
