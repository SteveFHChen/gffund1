package com.ycnet.dbank.web.controller;

import com.ycnet.dbank.dto.details.FileDetails;
import com.ycnet.dbank.service.FileService;
import com.ycnet.dbank.web.support.FileExtUtil;
import com.ycnet.mirage.filecenter.client.core.FileInfo;
import com.ycnet.mirage.filecenter.client.exception.MirageFileException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 文件服务controller
 * User: guozp
 * Date: 14-4-8
 * Time: 下午12:53
 */
@Controller
@RequestMapping("/file")
public class FileController extends BaseController  {

    @Autowired
    private FileService fileService;

    @Value("${fileWebHost}")
    private String fileWebHost;

    /**
     * 上传文件
     * @param file
     * @return {@link com.ycnet.dbank.dto.details.FileDetails}
     * @throws java.io.IOException
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public FileDetails upload(@RequestParam MultipartFile file) throws IOException, MirageFileException {
        return new FileDetails(fileService.upload(file), fileWebHost);
    }

    /**
     * 下载文件
     * @param path
     * @param request
     * @param response
     * @throws IOException
     * @throws MirageFileException
     */
    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public void download(@RequestParam String path, HttpServletRequest request, HttpServletResponse response) throws IOException, MirageFileException {
        response.setContentType("application/x-download");
        //TODO:可换为本地数据库中存储的文件名
        String fileName = StringUtils.substringAfterLast(path, "/");
        FileInfo fileInfo = fileService.getFileInfo(path);
        if(fileInfo != null){
            fileName = fileInfo.getFullName();
        }
        response.setHeader("Content-Disposition", "attachment; filename="+ FileExtUtil.handleFileName(request, fileName));

        OutputStream os = null;
        try{
            os = response.getOutputStream();
            fileService.download(path, os);
        }finally {
            IOUtils.closeQuietly(os);
        }
    }

    /**
     * 删除文件
     * @param path
     * @throws IOException
     * @throws MirageFileException
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam String path) throws IOException, MirageFileException {
        fileService.delete(path);
    }

    /**
     * 生成缩略图
     * @param path
     * @param width
     * @param height
     * @return
     * @throws IOException
     * @throws MirageFileException
     */
    @RequestMapping(value = "/thumbnail", method = RequestMethod.POST)
    @ResponseBody
    public FileDetails thumbnail(@RequestParam String path, @RequestParam int width, @RequestParam int height) throws IOException, MirageFileException {
        return new FileDetails(fileService.thumbnail(path,width,height),fileWebHost);
    }

    /**
     * 切图
     * @param path
     * @param x
     * @param y
     * @param width
     * @param height
     * @return
     * @throws IOException
     * @throws MirageFileException
     */
    @RequestMapping(value = "/crop", method = RequestMethod.POST)
    @ResponseBody
    public FileDetails crop(@RequestParam String path,@RequestParam int x, @RequestParam int y, @RequestParam int width, @RequestParam int height) throws IOException, MirageFileException {
        return new FileDetails(fileService.crop(path, x, y, width, height), fileWebHost);
    }

    /**
     * 旋转
     * @param path
     * @param angle
     * @return
     * @throws IOException
     * @throws MirageFileException
     */
    @RequestMapping(value = "/rotate", method = RequestMethod.POST)
    @ResponseBody
    public FileDetails rotate(@RequestParam String path, @RequestParam int angle) throws IOException, MirageFileException {
        return new FileDetails(fileService.rotate(path, angle), fileWebHost);
    }
}
