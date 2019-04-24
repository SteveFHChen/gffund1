package com.ycnet.dbank.dto.details;


/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class FaqCategoryDetails {

	/**分类名称*/
    private String categoryName;
    private long sequence;
    private Long id;
    private String createdDate;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public long getSequence() {
		return sequence;
	}
	public void setSequence(long sequence) {
		this.sequence = sequence;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
    
    
    
}
