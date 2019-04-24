package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 帮助内容
 * User: guozp
 * Date: 14-4-21
 * Time: 上午12:19
 */
@Entity
public class Faq extends DomainImpl {

    private static final long serialVersionUID = 4155666587635097356L;
    /**序号*/
    private String seqNo;
    /**问题*/
    private String question;
    /**答案*/
    private String answer;
    /**所属分类*/
    @ManyToOne
    private FaqCategory category;

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

    public FaqCategory getCategory() {
        return category;
    }

    public void setCategory(FaqCategory category) {
        this.category = category;
    }
}
