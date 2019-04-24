package com.ycnet.dbank.dto.condition;


/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class FaqCondition {
	
	private Long id;
	private String faqCategoryId;
	private String question;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFaqCategoryId() {
		return faqCategoryId;
	}
	public void setFaqCategoryId(String faqCategoryId) {
		this.faqCategoryId = faqCategoryId;
	}
	
}
