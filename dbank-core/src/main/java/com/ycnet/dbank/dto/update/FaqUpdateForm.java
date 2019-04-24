package com.ycnet.dbank.dto.update;

/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class FaqUpdateForm {
	
	private Long faqCategoryId;
	
	private String name; 
	
	private String answer;
	
	private String question;
	
	public Long getFaqCategoryId() {
		return faqCategoryId;
	}
	public void setFaqCategoryId(Long faqCategoryId) {
		this.faqCategoryId = faqCategoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	
	

}
