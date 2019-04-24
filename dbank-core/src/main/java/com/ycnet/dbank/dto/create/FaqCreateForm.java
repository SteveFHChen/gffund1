package com.ycnet.dbank.dto.create;


/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class FaqCreateForm {
	
	/**问题*/
    private String question;
    /**答案*/
    private String answer;
    /** FAQ 分类ID*/
    private Long faqCategoryId;
    
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Long getFaqCategoryId() {
		return faqCategoryId;
	}
	public void setFaqCategoryId(Long faqCategoryId) {
		this.faqCategoryId = faqCategoryId;
	}

}
