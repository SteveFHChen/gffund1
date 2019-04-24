package com.ycnet.dbank.domain;

import com.ycnet.dbank.domain.enums.PaperState;
import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 风险评估试卷
 * User: guozp
 * Date: 14-4-20
 * Time: 下午10:48
 */
@Entity
public class Paper extends DomainImpl {

    private static final long serialVersionUID = -1614544313057099622L;
    /**题目*/
    private String name;
    /**答卷状态*/
    @Enumerated(EnumType.STRING)
    private PaperState state = PaperState.ACTIVE;
    /**问题*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "paper")
    private List<PaperQuestion> questions = new ArrayList<PaperQuestion>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PaperState getState() {
        return state;
    }

    public void setState(PaperState state) {
        this.state = state;
    }

    public List<PaperQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<PaperQuestion> questions) {
        this.questions = questions;
    }
}
