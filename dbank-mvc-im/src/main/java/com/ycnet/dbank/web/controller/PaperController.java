package com.ycnet.dbank.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ycnet.dbank.dto.condition.PaperCondition;
import com.ycnet.dbank.dto.create.PaperCreateForm;
import com.ycnet.dbank.dto.details.PaperDetails;
import com.ycnet.dbank.dto.update.PaperUpdateForm;
import com.ycnet.dbank.service.PaperService;
import com.ycnet.mirage.event.DomainCreated;

/**
  * 试卷管理
  * @author zhanghuan  
  * Date: 2014/05/14 13:17:09
  */
@RestController
@RequestMapping("/paper")
public class PaperController extends BaseController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private PaperService paperService;
	
	/**
	 * 创建PaperController
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public DomainCreated create(PaperCreateForm form){
		logger.info("试卷管理[create]方法开始调用.....");
		return paperService.create(form);
	}
	/**
	 * 更新
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "/update",method = RequestMethod.POST)
	public PaperDetails update(@RequestParam Long id,PaperUpdateForm form){
		logger.info("试卷管理[update]方法开始调用.....");
		return paperService.update(id,form);
	}
	/**
	 * 删除
	 * @param id
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.POST)
	public void delete(@RequestParam Long id){
		logger.info("试卷管理[delete]方法开始调用.....");
		paperService.delete(id);
		logger.info("试卷管理[delete]方法结束.");
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getOne",method = RequestMethod.GET)
	public PaperDetails getDetails(@RequestParam Long id){
		return paperService.getDetails(id);
	}
	/**
	 * 分页查询
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "/queryList",method = RequestMethod.GET)
	public Page<PaperDetails> query(@RequestParam String name,Pageable page){
		logger.info("试卷管理[query]方法开始调用.....");
		logger.info("name-value ==========" + name);
		logger.info("试卷管理[query]方法调用结束.");
		return paperService.query(new PaperCondition(name),page);
	}
}
