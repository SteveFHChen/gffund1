package com.ycnet.dbank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ycnet.dbank.dto.condition.QuestionCondition;
import com.ycnet.dbank.dto.create.QuestionCreateForm;
import com.ycnet.dbank.dto.details.QuestionDetails;
import com.ycnet.dbank.dto.update.QuestionUpdateForm;
import com.ycnet.dbank.service.QuestionService;
import com.ycnet.mirage.event.DomainCreated;

@RestController
@RequestMapping("/question")
public class QuestionController extends BaseController {
	@Autowired
	private QuestionService questionService;
	
	/**
	 * 分页查询试题列表
	 * @param condition
	 * @param page
	 * @return
	 */
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public Page<QuestionDetails> query(QuestionCondition condition, Pageable page){
		return questionService.query(condition, page);
	}
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public QuestionDetails getDetails(@PathVariable Long id){
		return questionService.getDetails(id);
	}
	/**
	 * 创建试题
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/", method=RequestMethod.POST)
	public DomainCreated create(QuestionCreateForm form){
		return questionService.create(form);
	}
	/**
	 * 更新试题
	 * @param id
	 * @param form
	 * @return
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public QuestionDetails update(Long id, QuestionUpdateForm form){
		return questionService.update(id, form);
	}
	/**
	 * 删除试题
	 * @param id
	 */
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public void delete(@PathVariable Long id){
		questionService.delete(id);
	}
}
