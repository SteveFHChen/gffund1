package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.dto.condition.AdvertiseCondition;
import com.ycnet.dbank.dto.create.AdvertiseCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseDetails;
import com.ycnet.dbank.dto.update.AdvertiseUpdateForm;
import com.ycnet.mirage.event.DomainCreated;

public interface AdvertiseService {
	/**
     * 分页查询广告列表
     * @param condition
     * @param page
     * @return
     */
	public Page<AdvertiseDetails> query(AdvertiseCondition condition, Pageable page);
	/**
     * 获取广告详情
     * @param id
     * @return
     */
	public AdvertiseDetails getDetails(Long id);
	/**
     * 创建广告
     * @param form
     * @return
     */
	public DomainCreated create(AdvertiseCreateForm form);
	/***
     * 修改广告
     * @param id
     * @param form
     * @return
     */
	public AdvertiseDetails update(Long id, AdvertiseUpdateForm form);
	/**
     * 删除广告
     * @param id
     */
	public void delete(Long id);
}
