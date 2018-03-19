package com.taomall.service;

import com.taomall.utils.FtpUtil;
import com.taomall.utils.IDUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by zhoun on 2018/3/19.
 **/
@Service
public class PictureServiceImpl implements PictrueServie {

    @Value("${FTP_ADDRESS}")
    private String FTP_ADDRESS;
    @Value("${FTP_PORT}")
    private Integer FTP_PORT;
    @Value("${FTP_USERNAME}")
    private String FTP_USERNAME;
    @Value("${FTP_PASSWORD}")
    private String FTP_PASSWORD;
    @Value("${FTP_BASE_PATH}")
    private String FTP_BASE_PATH;
    @Value("${IMAGE_BASE_URL}")
    private String IMAGE_BASE_URL;

    @Override
    public Map uploadPicture(MultipartFile multipartFile) throws Exception {
        String oldName = multipartFile.getOriginalFilename();
        String newName = IDUtils.genImageName();
        newName = newName + oldName.substring(oldName.lastIndexOf("."));
        boolean result = FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH, new DateTime().toString("yyyy/MM/dd"), newName, multipartFile.getInputStream());

        return null;
    }

}
