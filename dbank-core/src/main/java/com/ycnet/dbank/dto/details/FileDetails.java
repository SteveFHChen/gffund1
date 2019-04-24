package com.ycnet.dbank.dto.details;

import org.apache.commons.lang.StringUtils;

/**
 * 文件内容
 * Created with IntelliJ IDEA.
 * User: guozp
 * Date: 14-4-14
 * Time: 上午10:42
 * To change this template use File | Settings | File Templates.
 */
public class FileDetails {

    private String path;

    private String absolutePath;

    private String host;

    public FileDetails() {

    }
    public FileDetails(String path) {
        this.path = path;
    }

    public FileDetails(String path, String host) {
        this.path = path;
        this.host = host;
        this.absolutePath = StringUtils.removeEnd(host,"/")+"/"+path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
