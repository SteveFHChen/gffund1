package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 试卷和题库问题的多对多关系表
 * User: guozp
 * Date: 14-5-14
 * Time: 下午2:16
 */
@Entity
public class PaperQuestion extends DomainImpl {

    private static final long serialVersionUID = -3540986546303747949L;
    /**试卷*/
    @ManyToOne
    private Paper paper;
    /**问题*/
    @ManyToOne
    private Question question;

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
