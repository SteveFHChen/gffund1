package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * 字典表
 * User: guozp
 * Date: 14-4-20
 * Time: 下午11:32
 */
@Entity
public class Dictionary extends DomainImpl {

    private static final long serialVersionUID = 2150316235544386530L;
    /**字典代码*/
    private String code;
    /**字典名称*/
    private String name;
    /**字典描述*/
    private String desc;
    /**字典细项列表*/
    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "dictionary")
    private List<Option> options = new ArrayList<Option>();

    /**获取游离态的options列表*/
    @SuppressWarnings("unchecked")
	@Transient
    public List<Option> getDetachedOptions(){
        return (List<Option>) CollectionUtils.collect(getOptions(), new Transformer() {
            public Object transform(Object input) {
                final Option option = (Option) input;
                return new Option(option.getName(), option.getValue());
            }
        });
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
