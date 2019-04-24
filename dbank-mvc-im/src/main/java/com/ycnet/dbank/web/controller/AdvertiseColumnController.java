package com.ycnet.dbank.web.controller;


import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.domain.enums.AdState;
import com.ycnet.dbank.dto.condition.AdvertiseColumnCondition;
import com.ycnet.dbank.dto.create.AdvertiseColumnCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseColumnDetails;
import com.ycnet.dbank.dto.update.AdvertiseColumnUpdateForm;
import com.ycnet.dbank.service.AdvertiseColumnService;
import com.ycnet.mirage.event.DomainCreated;

/**
  * 广告栏管理
  * @author zhanghuan  
  * Date: 2014/05/08 13:17:09
  */
@RestController
@RequestMapping("/advertiseColumn")
public class AdvertiseColumnController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private AdvertiseColumnService advertiseColumnService;
	
	/**
	 * 创建AdvertiseColumnController
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public DomainCreated create(AdvertiseColumnCreateForm form){
		logger.info("广告栏管理[create]方法开始调用.....");
		return advertiseColumnService.create(form);
	}
	/**
	 * 更新
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public AdvertiseColumnDetails update(@RequestParam Long id,AdvertiseColumnUpdateForm form){
		logger.info("广告栏管理[update]方法开始调用.....");
		return advertiseColumnService.update(id,form);
	}
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public void delete(@RequestParam Long id){
		logger.info("广告栏管理[delete]方法开始调用.....");
		advertiseColumnService.delete(id);
		logger.info("广告栏管理[delete]方法结束.");
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOne",method = RequestMethod.GET)
	public AdvertiseColumnDetails getDetails(@RequestParam Long id){
		return advertiseColumnService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	public Page<AdvertiseColumnDetails> query(@RequestParam Long id, @RequestParam String name,@RequestParam String state,Pageable page){
		logger.info("广告栏管理[query]方法开始调用.....");
		logger.info("id-value ==========" + id);
		logger.info("name-value ==========" + name);
		logger.info("adstate-value ==========" + state);
		logger.info("广告栏管理[query]方法调用结束.");
		AdvertiseColumnCondition condition = new AdvertiseColumnCondition(id,name,StringUtils.equals(state,"ALL") ? null :AdState.valueOf(state));
		return advertiseColumnService.query(condition,page);
	}
}
