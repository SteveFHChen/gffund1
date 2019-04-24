package com.ycnet.dbank.service;

import com.ycnet.mirage.filecenter.client.core.FileInfo;
import com.ycnet.mirage.filecenter.client.exception.MirageFileException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件服务
 * User: guozp
 * Date: 14-4-13
 * Time: 下午3:25
 */
public interface FileService {
    /**
     * 上传文件
     * @param file
     * @return 文件在文件服务器上的路径
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public String upload(MultipartFile file) throws IOException, MirageFileException;

    /**
     * 文件下载
     * @param path 文件在文件服务器上的路径
     * @param outputStream 输出流，需要自己关闭输出流
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public void download(String path, OutputStream outputStream) throws IOException, MirageFileException;

    /**
     * 删除文件
     * @param path 文件在文件服务器上的路径
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public void delete(String path) throws IOException, MirageFileException;

    /**
     * 切图
     * @param path 文件在文件服务器上的路径
     * @param x       x坐标
     * @param y       y坐标
     * @param width  截取宽度
     * @param height 截取高度
     * @return 切后的图在文件服务器上的路径
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public String crop(String path, int x, int y, int width, int height) throws IOException, MirageFileException;

    /**
     * 按角度旋转图片
     * @param path  文件在文件服务器上的路径
     * @param angle 顺时针旋转角度，逆时针可用负值
     * @return 生成旋转图在文件服务器上的路径
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public String rotate(String path, int angle) throws IOException, MirageFileException;

    /**
     * 等比缩略图
     * @param path   文件在文件服务器上的路径
     * @param width  缩略的宽度
     * @param height 缩略的高度
     * @return 生成后的缩略图在文件服务器上的路径
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public String thumbnail(String path, int width, int height) throws IOException, MirageFileException;

    /**
     * 获取服务器上文件的信息
     * @param path 文件在文件服务器上的路径
     * @return {@link FileInfo} 文件信息
     * @throws java.io.IOException
     * @throws {@link com.ycnet.mirage.filecenter.client.exception.MirageFileException}
     */
    public FileInfo getFileInfo(String path) throws IOException, MirageFileException;

}
