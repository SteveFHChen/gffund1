package com.ycnet.dbank.web.support;

import org.apache.commons.codec.binary.Base64;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * 文件处理扩展Util
 * User: guozp
 * Date: 13-10-18
 * Time: 下午12:38
 */
public class FileExtUtil {

    public final static int BROWSER_TYPE_OTHERS = 0x000;
    public final static int BROWSER_TYPE_IE = 0x001;
    public final static int BROWSER_TYPE_FIREFOX = 0x002;
    public final static int BROWSER_TYPE_SAFARI = 0x003;
    public final static int BROWSER_TYPE_OPERA = 0x004;
    public final static int BROWSER_TYPE_CHROME = 0x005;

    public final static String CHARSET_UTF8 = "UTF-8";
    public final static String CHARSET_ISO88591 = "iso-8859-1";
    public final static String CHARSET_GB18030 = "GB18030";

    /**
     * 针对不同浏览器，中文文件名的乱码问题，对不同的attachment的filename进行处理，返回处理后的结果
     * @param request
     * @param filename 原文件名
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    public static String handleFileName(HttpServletRequest request,  String filename) throws UnsupportedEncodingException {
        String res = filename;
        switch (getBrowserType(request)){
            case BROWSER_TYPE_FIREFOX:
                res = "=?UTF-8?B?" + (new String(Base64.encodeBase64(filename.getBytes(CHARSET_UTF8)),CHARSET_ISO88591)) + "?=";
                break;
            case BROWSER_TYPE_CHROME:
            case BROWSER_TYPE_SAFARI:
            case BROWSER_TYPE_OPERA:
                res = new String(filename.getBytes(CHARSET_UTF8),CHARSET_ISO88591);
                break;
            case BROWSER_TYPE_IE:
                res = java.net.URLEncoder.encode(filename,CHARSET_UTF8);
                if(res.length() > 150){//IE6 bug：文件名过长
                    res = new String(res.getBytes(CHARSET_GB18030),CHARSET_ISO88591);
                }
                break;
            case BROWSER_TYPE_OTHERS:
            default:
                res = java.net.URLEncoder.encode(filename,CHARSET_UTF8);
                break;
        }
        return res;
    }

    /**
     * 获取浏览器的类型
     * @param request
     * @return
     */
    public static int getBrowserType(HttpServletRequest request){
        String userAgent = request.getHeader("USER-AGENT").toLowerCase();
        if(userAgent != null && !"".equals(userAgent.trim())){
            if (userAgent.indexOf("msie") >=0 ) return BROWSER_TYPE_IE;
            if (userAgent.indexOf("firefox") >= 0) return BROWSER_TYPE_FIREFOX;
            if (userAgent.indexOf("safari") >= 0) return BROWSER_TYPE_SAFARI;
            if (userAgent.indexOf("opera") >= 0) return BROWSER_TYPE_OPERA;
            if (userAgent.indexOf("applewebkit") >= 0) return BROWSER_TYPE_CHROME;
        }
        return BROWSER_TYPE_OTHERS;
    }
}
