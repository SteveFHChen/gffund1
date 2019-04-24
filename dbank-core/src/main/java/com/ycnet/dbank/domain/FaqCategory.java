package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.TreeImpl;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

/**
 * 帮助分类，树形(菜单)
 * User: guozp
 * Date: 14-4-21
 * Time: 上午9:48
 */
@Entity
public class FaqCategory extends TreeImpl<FaqCategory> {

    private static final long serialVersionUID = -3075247095010460657L;

    /**分类名称*/
    @NotBlank
    private String categoryName;
    /**帮助列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "category")
    private List<Faq> faqs = new ArrayList<Faq>();

    /**用于拼接fullName*/
    @Override
    public String getName() {
        return categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Faq> getFaqs() {
        return faqs;
    }

    public void setFaqs(List<Faq> faqs) {
        this.faqs = faqs;
    }
}
