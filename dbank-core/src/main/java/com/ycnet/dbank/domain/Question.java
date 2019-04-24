package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * 评估案卷问题表
 * User: guozp
 * Date: 14-5-4
 * Time: 下午2:07
 */
@Entity
public class Question extends DomainImpl {

    private static final long serialVersionUID = -2973702671571656602L;

    /**选项问题*/
    private String title;
    /**选项*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "question")
    private List<Item> items = new ArrayList<Item>();
    /**问题所属案卷*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "question")
    private List<PaperQuestion> paper = new ArrayList<PaperQuestion>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PaperQuestion> getPaper() {
        return paper;
    }

    public void setPaper(List<PaperQuestion> paper) {
        this.paper = paper;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
