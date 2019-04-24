package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Notice;
import com.ycnet.dbank.domain.enums.ChannelType;
import com.ycnet.dbank.domain.enums.NoticeStatus;
import com.ycnet.dbank.dto.condition.NoticeCondition;
import com.ycnet.dbank.dto.create.NoticeCreateForm;
import com.ycnet.dbank.dto.details.NoticeDetails;
import com.ycnet.dbank.dto.update.NoticeUpdateForm;
import com.ycnet.dbank.repository.NoticeRepository;
import com.ycnet.dbank.repository.spec.NoticeSpec;
import com.ycnet.dbank.service.NoticeService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  * 公告实现
  * @author guozp   
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeRepository noticeRepository;

	@Override
	public DomainCreated create(NoticeCreateForm form) {
        Notice notice = MirageUtils.fromDto(form,Notice.class);
        notice = noticeRepository.save(notice);
        return new DomainCreated(notice.getId());
	}

	@Override
	public NoticeDetails update(Long id, NoticeUpdateForm form) {
        Notice notice = noticeRepository.findOne(id);
        notice.setAuthor(form.getAuthor());
        notice.setContent(form.getContent());
        notice.setPublishDate(form.getPublishDate());
        notice.setTitle(form.getTitle());
		return MirageUtils.toDto(NoticeDetails.class,notice);
	}

	@Override
	public void delete(Long id) {
        noticeRepository.delete(id);
	}

	@Override
	public NoticeDetails getDetails(Long id) {
        Notice notice = noticeRepository.findOne(id);
		return MirageUtils.toDto(NoticeDetails.class,notice);
	}

	@Override
	public Page<NoticeDetails> query(NoticeCondition condition, Pageable page) {
        Page<Notice> res = noticeRepository.findAll(new NoticeSpec(condition),page);
        return MirageUtils.toDto(res,new Transformer() {
            @Override
            public Object transform(Object input) {
            	Notice notice = (Notice)input;
                NoticeDetails nt = MirageUtils.toDto(NoticeDetails.class, notice);
                nt.setStatus(notice.getStatus().getName());
                nt.setChannelType(notice.getChannelType().getName());
                return nt;
            }
        });
	}
	
}