package com.taomall.controller;

import com.taomall.service.PictrueServie;
import com.taomall.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * Created by zhoun on 2018/3/19.
 **/
@Controller
public class PictureController {

    @Autowired
    private PictrueServie pictrueServie;

    @RequestMapping("/pic/upload")
    @ResponseBody
    public String pictureUpload(MultipartFile uploadFile) throws Exception{
        Map result = pictrueServie.uploadPicture(uploadFile);
        //为了保证功能的兼容性，需要把Result转换成json格式的字符串。
        String json = JsonUtils.objectToJson(result);
        return json;
    }

}
