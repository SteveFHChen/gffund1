package com.ycnet.dbank.service;

import com.ycnet.dbank.dto.condition.IndexSpotConfigCondition;
import com.ycnet.dbank.dto.create.IndexSpotConfigCreateForm;
import com.ycnet.dbank.dto.details.IndexSpotConfigDetails;
import com.ycnet.dbank.dto.update.IndexSpotConfigUpdateForm;
import com.ycnet.mirage.event.DomainCreated;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 首页配置页面相关接口
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
public interface IndexSpotConfigService {

	DomainCreated create(IndexSpotConfigCreateForm form);

	IndexSpotConfigDetails update(Long id, IndexSpotConfigUpdateForm form);

	void delete(Long id);

	IndexSpotConfigDetails getDetails(Long id);

	Page<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition, Pageable page);

    /**
     * 获取首页上各个区域的配置信息
     * 区域见{@link com.ycnet.dbank.domain.enums.SpotType}
     * @param condition
     * @return
     */
	List<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition);

}
