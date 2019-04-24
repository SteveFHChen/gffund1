package com.ycnet.dbank.service.impl;

import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.AdvertiseColumn;
import com.ycnet.dbank.domain.Notice;
import com.ycnet.dbank.dto.common.AdvertiseColumnDtoBase;
import com.ycnet.dbank.dto.condition.AdvertiseColumnCondition;
import com.ycnet.dbank.dto.create.AdvertiseColumnCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseColumnDetails;
import com.ycnet.dbank.dto.details.NoticeDetails;
import com.ycnet.dbank.dto.update.AdvertiseColumnUpdateForm;
import com.ycnet.dbank.repository.AdvertiseColumnRepository;
import com.ycnet.dbank.repository.spec.AdvertiseColumnSpec;
import com.ycnet.dbank.service.AdvertiseColumnService;
import com.ycnet.mirage.context.MirageException;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
*
* @author zhanghuan  
* Date: 2014/05/08 13:17:09
*/
@MirageService
public class AdvertiseColumnServiceImpl implements AdvertiseColumnService {
	
	@Autowired
	private AdvertiseColumnRepository advertiseColumenRepository;

	@Override
	public DomainCreated create(AdvertiseColumnCreateForm form) {
		
//		AdvertiseColumn advertiseColumn = new AdvertiseColumn();
//		Long id = -1L;
//		try {
//			BeanUtils.copyProperties(advertiseColumn, form);
//			advertiseColumn = advertiseColumenRepository.save(advertiseColumn);
//			id = advertiseColumn.getId();
//		} catch (Exception e) {
//			throw new MirageException("save error!please try again!");
//		}
//		
//		return id;
		
		AdvertiseColumn advertiseColumn  = MirageUtils.fromDto(form,AdvertiseColumn.class);
		advertiseColumn = advertiseColumenRepository.save(advertiseColumn);
        return new DomainCreated(advertiseColumn.getId());
	}

	@Override
	public AdvertiseColumnDetails update(Long id, AdvertiseColumnUpdateForm form) {
		
		AdvertiseColumn advertiseColumn = advertiseColumenRepository.findOne(id);
		advertiseColumn.setName(form.getName());
		advertiseColumn.setState(form.getState());
		advertiseColumn.setPolling(form.getPolling());
		advertiseColumn.setDesc(form.getDesc());
		return MirageUtils.toDto(AdvertiseColumnDetails.class,advertiseColumn);
	}

	@Override
	public void delete(Long id) {
		advertiseColumenRepository.delete(id);
	}

	@Override
	public AdvertiseColumnDetails getDetails(Long id) {
		return MirageUtils.toDto(AdvertiseColumnDetails.class, advertiseColumenRepository.getOne(id));
	}

	@Override
	public Page<AdvertiseColumnDetails> query(AdvertiseColumnCondition condition, Pageable page) {
		Page<AdvertiseColumn> list = advertiseColumenRepository.findAll(new AdvertiseColumnSpec(condition), page);

		return MirageUtils.toDto(list, new Transformer() {
			public Object transform(Object input) {
				AdvertiseColumn advertiseColumn = (AdvertiseColumn)input;
				AdvertiseColumnDtoBase dto = new AdvertiseColumnDtoBase();
				dto.setId(advertiseColumn.getId());
				dto.setName(advertiseColumn.getName());
				dto.setState(advertiseColumn.getState().toString());
				return dto;
			}
		});
	}

	@Override
	public List<AdvertiseColumnDetails> query(AdvertiseColumnCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}
}