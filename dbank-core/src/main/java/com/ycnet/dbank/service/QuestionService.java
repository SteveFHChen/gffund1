package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.dto.condition.QuestionCondition;
import com.ycnet.dbank.dto.create.QuestionCreateForm;
import com.ycnet.dbank.dto.details.QuestionDetails;
import com.ycnet.dbank.dto.update.QuestionUpdateForm;
import com.ycnet.mirage.event.DomainCreated;

public interface QuestionService {
	/**
     * 题库列表
     * @param condition
     * @param page
     * @return
     */
	public Page<QuestionDetails> query(QuestionCondition condition, Pageable page);
	/**
     * 获取题目详情
     * @param id
     * @return
     */
	public QuestionDetails getDetails(Long id);
	/**
     * 创建题目
     * @param form
     * @return
     */
	public DomainCreated create(QuestionCreateForm form);
	/***
     * 修改题目
     * @param id
     * @param form
     * @return
     */
	public QuestionDetails update(Long id, QuestionUpdateForm form);
	/**
     * 删除题目
     * @param id
     */
	public void delete(Long id);
}
