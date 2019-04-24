package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * 字典细项
 * User: guozp
 * Date: 14-4-20
 * Time: 下午10:50
 */
@Entity
public class Option extends DomainImpl {

    private static final long serialVersionUID = -4475395216820599936L;
    /**名称,代码标识*/
    private String name;
    /**值*/
    private String value;
    /**所属字典*/
    @ManyToOne
    private Dictionary dictionary;

    public Option() {

    }

    public Option(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
}
