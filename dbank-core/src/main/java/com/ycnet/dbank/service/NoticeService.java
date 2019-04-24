package com.ycnet.dbank.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.dto.condition.NoticeCondition;
import com.ycnet.dbank.dto.create.NoticeCreateForm;
import com.ycnet.dbank.dto.details.NoticeDetails;
import com.ycnet.dbank.dto.update.NoticeUpdateForm;
import com.ycnet.mirage.event.DomainCreated;

/**
  * 公告相关接口
  * @author guozp   
  * Date: 2014/04/22 10:20:47
  */
public interface NoticeService {
    /**
     * 创建公告
     * @param form
     * @return
     */
	DomainCreated create(NoticeCreateForm form);

    /***
     * 修改公告内容
     * @param id
     * @param form
     * @return
     */
	NoticeDetails update(Long id, NoticeUpdateForm form);

    /**
     * 删除公告
     * @param id
     */
	void delete(Long id);

    /**
     * 获取公告详情
     * @param id
     * @return
     */
	NoticeDetails getDetails(Long id);

    /**
     * 分页查询公告列表
     * @param condition
     * @param page
     * @return
     */
	Page<NoticeDetails> query(NoticeCondition condition, Pageable page);
	
}
