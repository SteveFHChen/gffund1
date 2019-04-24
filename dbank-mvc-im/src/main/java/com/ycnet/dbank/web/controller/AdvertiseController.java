package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.dto.condition.AdvertiseCondition;
import com.ycnet.dbank.dto.create.AdvertiseCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseDetails;
import com.ycnet.dbank.dto.update.AdvertiseUpdateForm;
import com.ycnet.dbank.service.AdvertiseService;
import com.ycnet.mirage.event.DomainCreated;
/**
 * 广告管理
 * @author chenfh
 *
 */
@RestController
@RequestMapping("/advertise")
public class AdvertiseController extends BaseController {
	
	@Autowired
	private AdvertiseService advertiseService;
	
	/**
	 * 分页查询公告列表
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public Page<AdvertiseDetails> query(AdvertiseCondition condition, Pageable page){
		return advertiseService.query(condition, page);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public AdvertiseDetails getDetails(@PathVariable Long id){
		return advertiseService.getDetails(id);
	}
	/**
	 * 创建广告
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public DomainCreated create(AdvertiseCreateForm form){
		return advertiseService.create(form);
	}
	/**
	 * 更新广告
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public AdvertiseDetails update(Long id, AdvertiseUpdateForm form){
		return advertiseService.update(id, form);
	}
	/**
	 * 删除广告
	 * @param id
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public void delete(@PathVariable Long id){
		advertiseService.delete(id);
	}
}
