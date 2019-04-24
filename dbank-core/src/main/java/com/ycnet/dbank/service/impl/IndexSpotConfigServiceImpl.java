package com.ycnet.dbank.service.impl;

import com.ycnet.dbank.domain.IndexSpotConfig;
import com.ycnet.mirage.utils.MirageUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.dbank.dto.condition.IndexSpotConfigCondition;
import com.ycnet.dbank.dto.create.IndexSpotConfigCreateForm;
import com.ycnet.dbank.dto.details.IndexSpotConfigDetails;
import com.ycnet.dbank.dto.update.IndexSpotConfigUpdateForm;
import com.ycnet.dbank.repository.IndexSpotConfigRepository;
import com.ycnet.dbank.service.IndexSpotConfigService;

import java.util.List;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 13:17:09
  */
@MirageService
public class IndexSpotConfigServiceImpl implements IndexSpotConfigService {
	
	@Autowired
	private IndexSpotConfigRepository indexSpotConfigRepository;

	@Override
	public DomainCreated create(IndexSpotConfigCreateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IndexSpotConfigDetails update(Long id, IndexSpotConfigUpdateForm form) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IndexSpotConfigDetails getDetails(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition, Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public List<IndexSpotConfigDetails> query(IndexSpotConfigCondition condition) {
        return MirageUtils.toDto(indexSpotConfigRepository.findBySpotType(condition.getSpotType()), new Transformer() {
            @Override
            public Object transform(Object input) {
                IndexSpotConfig isc = (IndexSpotConfig) input;
                return MirageUtils.toDto(IndexSpotConfigDetails.class,isc);
            }
        });
    }

}