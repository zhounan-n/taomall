package com.taomall.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PictrueServie {

    Map uploadPicture(MultipartFile multipartFile) throws Exception;

}
