package com.ycnet.dbank.service.impl;

import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.Faq;
import com.ycnet.dbank.domain.FaqCategory;
import com.ycnet.dbank.dto.condition.FaqCondition;
import com.ycnet.dbank.dto.create.FaqCreateForm;
import com.ycnet.dbank.dto.details.FaqDetails;
import com.ycnet.dbank.dto.update.FaqUpdateForm;
import com.ycnet.dbank.repository.FaqCategoryRepository;
import com.ycnet.dbank.repository.FaqRepository;
import com.ycnet.dbank.repository.spec.FaqSpec;
import com.ycnet.dbank.service.FaqService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class FaqServiceImpl implements FaqService {
	
	@Autowired
	private FaqRepository faqRepository;

	@Autowired
	private FaqCategoryRepository faqCategoryRepository;
	
	@Override
	public DomainCreated create(FaqCreateForm form) {
		Faq faq = MirageUtils.fromDto(form,Faq.class);
		FaqCategory faqCat = faqCategoryRepository.findOne(form.getFaqCategoryId());
		faq.setCategory(faqCat);
		faq = faqRepository.save(faq);
        return new DomainCreated(faq.getId());
	}

	@Override
	public FaqDetails update(Long id, FaqUpdateForm form) {
		Faq faq = faqRepository.findOne(id);
		faq.setAnswer(form.getAnswer());
		faq.setQuestion(form.getQuestion());
		FaqCategory faqCat = faqCategoryRepository.findOne(form.getFaqCategoryId());
		faq.setCategory(faqCat);
		faq = faqRepository.save(faq);
        return MirageUtils.toDto(FaqDetails.class,faq);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 根据ID查找FAQ详情
	 */
	@Override
	public FaqDetails getDetails(Long id) {
		Faq faq  = faqRepository.findOne(id);
		FaqDetails faqDetail = MirageUtils.toDto(FaqDetails.class, faq);
		faqDetail.setCategoryName(faq.getCategory().getCategoryName());
		faqDetail.setCreatDate(faq.getCreatedDate().toString("yyyy-MM-dd"));
		return faqDetail ;
	}

	@Override
	public Page<FaqDetails> query(FaqCondition condition, Pageable page) {
		Page<Faq> faq = faqRepository.findAll(new FaqSpec(condition), page);
		return MirageUtils.toDto(faq, new Transformer() {
			@Override
			public Object transform(Object input) {
				Faq faq = (Faq)input;
				FaqDetails faqDetail = MirageUtils.toDto(FaqDetails.class, faq);
				faqDetail.setCategoryName(faq.getCategory().getCategoryName());
				faqDetail.setCreatDate(faq.getCreatedDate().toString("yyyy-MM-dd"));
				return faqDetail;
			}
		});
	}
}