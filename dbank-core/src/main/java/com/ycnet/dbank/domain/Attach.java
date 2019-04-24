package com.ycnet.dbank.domain;

import com.ycnet.mirage.domain.DomainImpl;
import org.apache.commons.io.FileUtils;

import javax.persistence.Entity;

/**
 * 附件表
 * User: guozp
 * Date: 14-3-12
 * Time: 下午5:09
 */
@Entity
public class Attach extends DomainImpl {

    private static final long serialVersionUID = -6692147088321757187L;

    /**
     * 文件名
     */
    private String name;
    /**
     * 文件路径（文件在文件服务器上的路径）
     */
    private String path;
    /**
     * 文件大小
     */
    private long size;

    /**
     * 显示一个易读的大小，如3K,2M
     * @return
     */
    public String getSizeForHuman(){
        return FileUtils.byteCountToDisplaySize(size);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

}
