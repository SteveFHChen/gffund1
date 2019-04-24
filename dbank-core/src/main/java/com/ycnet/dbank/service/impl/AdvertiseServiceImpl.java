package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Advertise;
import com.ycnet.dbank.domain.AdvertiseColumn;
import com.ycnet.dbank.dto.condition.AdvertiseCondition;
import com.ycnet.dbank.dto.create.AdvertiseCreateForm;
import com.ycnet.dbank.dto.details.AdvertiseDetails;
import com.ycnet.dbank.dto.update.AdvertiseUpdateForm;
import com.ycnet.dbank.repository.AdvertiseColumnRepository;
import com.ycnet.dbank.repository.AdvertiseRepository;
import com.ycnet.dbank.repository.spec.AdvertiseSpec;
import com.ycnet.dbank.service.AdvertiseService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

@MirageService
public class AdvertiseServiceImpl implements AdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;
	@Autowired
	private AdvertiseColumnRepository advertiseColumnRepository;
	
	@Override
	public Page<AdvertiseDetails> query(AdvertiseCondition condition, Pageable page) {
		Page<Advertise> rst = advertiseRepository.findAll(new AdvertiseSpec(condition), page);
		return MirageUtils.toDto(rst, new Transformer(){
			@Override
			public Object transform(Object input){
				AdvertiseDetails ad = MirageUtils.toDto(AdvertiseDetails.class, (Advertise)input);
				ad.setAdId(((Advertise)input).getId());
				return ad;
			}
		});
	}

	@Override
	public AdvertiseDetails getDetails(Long id) {
		Advertise advertise = advertiseRepository.findOne(id);
		AdvertiseDetails ads = MirageUtils.toDto(AdvertiseDetails.class, advertise);
		ads.setAdColumnName(advertise.getAdColumn().getName());
		ads.setStatus(advertise.getStatus().getName());
		return ads;
	}

	@Override
	public DomainCreated create(AdvertiseCreateForm form) {
		Advertise advertise=MirageUtils.fromDto(form, Advertise.class);
		advertise.setOpenTime(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(form.getOpenTime()).toDate());
		advertise.setCloseTime(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(form.getCloseTime()).toDate());
		AdvertiseColumn advertiseColumn = advertiseColumnRepository.findOne(form.getAdColumnId());
		advertise.setAdColumn(advertiseColumn);
		advertise = advertiseRepository.save(advertise);
		return new DomainCreated(advertise.getId());
	}

	@Override
	public AdvertiseDetails update(Long id, AdvertiseUpdateForm form) {
		Advertise advertise = advertiseRepository.findOne(id);
		advertise.setAdColumn(advertiseColumnRepository.findOne(form.getAdColumnId()));
		advertise.setName(form.getName());
		advertise.setTitle(form.getTitle());
		advertise.setContent(form.getContent());
		advertise.setSource(form.getSource());
		advertise.setLinked(form.getLinked());
		advertise.setStatus(form.getStatus());
		advertise.setOrderNo(form.getOrderNo());
		advertise.setOpenTime(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(form.getOpenTime()).toDate());
		advertise.setCloseTime(DateTimeFormat.forPattern("yyyy-MM-dd").parseDateTime(form.getCloseTime()).toDate());
		return MirageUtils.toDto(AdvertiseDetails.class, advertise);
	}

	@Override
	public void delete(Long id) {
		advertiseRepository.delete(id);
	}
	
}
