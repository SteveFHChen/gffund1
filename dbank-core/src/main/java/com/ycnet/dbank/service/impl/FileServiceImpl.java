package com.ycnet.dbank.service.impl;

import com.ycnet.dbank.service.FileService;
import com.ycnet.mirage.context.MirageService;
import com.ycnet.mirage.filecenter.client.core.FileInfo;
import com.ycnet.mirage.filecenter.client.exception.MirageFileException;
import com.ycnet.mirage.filecenter.client.service.IFileClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件服务
 * User: guozp
 * Date: 14-4-13
 * Time: 下午4:41
 */
@MirageService
public class FileServiceImpl implements FileService {

    @Autowired
    private IFileClient fileClient;

    @Override
    public String upload(MultipartFile file) throws IOException, MirageFileException {
        return fileClient.upload(file);
    }

    @Override
    public void download(String path, OutputStream os) throws IOException, MirageFileException {
        fileClient.download(path, os);
    }

    @Override
    public void delete(String path) throws IOException, MirageFileException {
        fileClient.delete(path);
    }

    @Override
    public String crop(String path, int x, int y, int width, int height) throws IOException, MirageFileException {
        return fileClient.crop(path,x,y,width,height);
    }

    @Override
    public String rotate(String path, int angle) throws IOException, MirageFileException {
        return fileClient.rotate(path, angle);
    }

    @Override
    public String thumbnail(String path, int width, int height) throws IOException, MirageFileException {
        return fileClient.thumbnail(path, width, height);
    }

    @Override
    public FileInfo getFileInfo(String path) throws IOException, MirageFileException {
        return fileClient.getFileInfo(path);
    }
}
