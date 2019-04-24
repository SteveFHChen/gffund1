package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.condition.IndexSpotConfigCondition;
import com.ycnet.dbank.dto.create.IndexSpotConfigCreateForm;
import com.ycnet.dbank.dto.details.IndexSpotConfigDetails;
import com.ycnet.dbank.dto.update.IndexSpotConfigUpdateForm;
import com.ycnet.dbank.service.IndexSpotConfigService;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
  * 首页配置
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
@RestController
@RequestMapping("/indexSpotConfig")
public class IndexSpotConfigController extends BaseController {

	@Autowired
	private IndexSpotConfigService indexSpotConfigService;
	
	/**
	 * 创建IndexSpotConfig
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/",method = RequestMethod.POST)
	public DomainCreated create(IndexSpotConfigCreateForm form){
		return indexSpotConfigService.create(form);
	}
	
	/**
	 * 更新IndexSpotConfig
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
	public IndexSpotConfigDetails update(@PathVariable Long id,IndexSpotConfigUpdateForm form){
		return indexSpotConfigService.update(id,form);
	}
	/**
	 * 删除IndexSpotConfig
	 * @param id
	 */
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
	public void delete(@PathVariable Long id){
		indexSpotConfigService.delete(id);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public IndexSpotConfigDetails getDetails(@PathVariable Long id){
		return indexSpotConfigService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/page/",method = RequestMethod.GET)
	public Page<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition,Pageable page){
		return indexSpotConfigService.query(condition,page);
	}
}
