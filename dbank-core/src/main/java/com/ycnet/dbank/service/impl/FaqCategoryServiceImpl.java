
package com.ycnet.dbank.service.impl;

import java.util.List;
import org.apache.commons.collections.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ycnet.dbank.domain.FaqCategory;
import com.ycnet.dbank.dto.condition.FaqCategoryCondition;
import com.ycnet.dbank.dto.create.FaqCategoryCreateForm;
import com.ycnet.dbank.dto.details.FaqCategoryDetails;
import com.ycnet.dbank.dto.update.FaqCategoryUpdateForm;
import com.ycnet.dbank.repository.FaqCategoryRepository;
import com.ycnet.dbank.repository.spec.FaqCategorySpec;
import com.ycnet.dbank.service.FaqCategoryService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.event.DomainCreated;
import com.ycnet.mirage.utils.MirageUtils;

/**
  *
  * @author shine  
  * Date: 2014/04/22 10:20:47
  */
@MirageService
public class FaqCategoryServiceImpl implements FaqCategoryService {
	
	@Autowired
	private FaqCategoryRepository faqCategoryRepository;

	@Override
	public DomainCreated create(FaqCategoryCreateForm form) {
		FaqCategory faqCate = MirageUtils.fromDto(form,FaqCategory.class);
		faqCate = faqCategoryRepository.save(faqCate);
        return new DomainCreated(faqCate.getId());
	}

	@Override
	public FaqCategoryDetails update(Long id, FaqCategoryUpdateForm form) {
		FaqCategory faqCate = faqCategoryRepository.findOne(id);
        faqCate.setCategoryName(form.getCategoryName());
		return MirageUtils.toDto(FaqCategoryDetails.class,faqCate);
	}

	@Override
	public void delete(Long id) {
		faqCategoryRepository.delete(id);
	}

	@Override
	public FaqCategoryDetails getDetails(Long id) {
		FaqCategory faqCate = faqCategoryRepository.findOne(id);
		return MirageUtils.toDto(FaqCategoryDetails.class,faqCate);
	}

	@Override
	public Page<FaqCategoryDetails> query(FaqCategoryCondition condition, Pageable page) {
		Page<FaqCategory> faqCates = faqCategoryRepository.findAll(new FaqCategorySpec(condition), page);
		return MirageUtils.toDto(faqCates, new Transformer() {
			
			@Override
			public Object transform(Object input) {
				FaqCategory faqCate = (FaqCategory) input;
				FaqCategoryDetails fd = MirageUtils.toDto(FaqCategoryDetails.class, faqCate);
				fd.setCreatedDate(faqCate.getCreatedDate().toString("yyyy-MM-dd HH:mm:ss"));
				return fd;
			}
		});
	}
	
	/**
	 * 查询FaqCategory所有列表数据
	 * @author Chenxh
	 */
	@Override
	public List<FaqCategoryDetails> queryList() {
		List<FaqCategory> faqCates = faqCategoryRepository.findAll();
		return MirageUtils.toDto(faqCates, new Transformer(){
			@Override
			public Object transform(Object input) {
				FaqCategory faqCate = (FaqCategory) input;
				FaqCategoryDetails fd = MirageUtils.toDto(FaqCategoryDetails.class, faqCate);
				return fd;
			}
			
		});
	}
	
}