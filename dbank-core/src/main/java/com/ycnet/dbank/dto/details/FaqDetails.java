package com.ycnet.dbank.dto.details;


/**
  *
  * @author guozp  
  * Date: 2014/04/22 10:20:47
  */
public class FaqDetails {
	
	/**ID*/
	private Long id;
	/**序号*/
    private String seqNo;
    /**问题*/
    private String question;
    /**答案*/
    private String answer;
    /** FAQ 分类*/
    private String categoryName;
    
    /**FAQ 创建时间***/
    private String creatDate;
    
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCreatDate() {
		return creatDate;
	}

	public void setCreatDate(String creatDate) {
		this.creatDate = creatDate;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(String seqNo) {
        this.seqNo = seqNo;
    }

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


}
