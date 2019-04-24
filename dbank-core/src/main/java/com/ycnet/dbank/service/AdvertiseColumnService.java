package com.ycnet.dbank.service;

import com.ycnet.dbank.dto.condition.AdvertiseColumnCondition;
import com.ycnet.dbank.dto.create.AdvertiseColumnCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseColumnDetails;
import com.ycnet.dbank.dto.update.AdvertiseColumnUpdateForm;
import com.ycnet.mirage.event.DomainCreated;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 广告栏管理页面相关接口
 * 
 * @author zhanghuan Date: 2014/05/08 13:17:09
 */
public interface AdvertiseColumnService {

	DomainCreated create(AdvertiseColumnCreateForm form);

	AdvertiseColumnDetails update(Long id, AdvertiseColumnUpdateForm form);

	void delete(Long id);

	AdvertiseColumnDetails getDetails(Long id);

	Page<AdvertiseColumnDetails> query(AdvertiseColumnCondition condition,
			Pageable page);

	List<AdvertiseColumnDetails> query(AdvertiseColumnCondition condition);

}
