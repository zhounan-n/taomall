package com.taomall.service.impl;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.common.utils.HttpClientUtil;
import com.taomall.entities.TbContent;
import com.taomall.mapper.TbContentMapper;
import com.taomall.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by zhoun on 2018/3/21.
 **/
@Service
public class ContentServiceImpl implements ContentService{

    @Autowired
    private TbContentMapper contentMapper;
    @Value("${REST_BASE_URL}")
    private String REST_BASE_URL;
    @Value("${REST_CONTENT_SYNC_URL}")
    private String REST_CONTENT_SYNC_URL;


    @Override
    public TaotaoResult insertContent(TbContent content) {
        //补全pojo内容
        content.setCreated(new Date());
        content.setUpdated(new Date());
        contentMapper.insert(content);

        //添加缓存同步逻辑
        try {
            HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_SYNC_URL + content.getCategoryId());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TaotaoResult.ok();
    }

}
