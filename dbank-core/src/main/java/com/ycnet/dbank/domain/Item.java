package com.ycnet.dbank.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotBlank;

import com.ycnet.mirage.domain.DomainImpl;

/**
 * 风险评估答卷答案选项
 * User: guozp
 * Date: 14-4-20
 * Time: 下午11:36
 */
@Entity
public class Item extends DomainImpl {

    private static final long serialVersionUID = 6427014519341815888L;

    /**选项序号*/
    private String itemNo;
    /**选项内容*/
    private String content;
    /**选项所属问题*/
    @ManyToOne
    private Question question;
    /**选项的分数*/
    @NotBlank
    private int score;

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
    
}
