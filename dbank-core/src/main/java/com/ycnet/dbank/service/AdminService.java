package com.ycnet.dbank.service;

import com.ycnet.dbank.dto.condition.AdminCondition;
import com.ycnet.dbank.dto.details.AdminDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
  * 内管用户
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public interface AdminService {
    /**
     * 获取内管用户的详细信息
     * @param id
     * @return
     */
	AdminDetails getDetails(Long id);

    /**
     * 分页获取内管用户列表
     * @param condition
     * @param page
     * @return
     */
	Page<AdminDetails> query(AdminCondition condition, Pageable page);
	
}
