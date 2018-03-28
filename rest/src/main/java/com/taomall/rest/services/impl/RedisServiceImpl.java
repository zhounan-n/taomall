package com.taomall.rest.services.impl;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.common.utils.ExceptionUtil;
import com.taomall.rest.dao.JedisClient;
import com.taomall.rest.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by zhoun on 2018/3/28.
 **/
@Service
public class RedisServiceImpl implements RedisService{

    @Autowired
    private JedisClient jedisClient;

    @Value("${INDEX_CONTENT_REDIS_KEY}")
    private String INDEX_CONTENT_REDIS_KEY;

    @Override
    public TaotaoResult syncContent(long contentCid) {
        try {
            jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid + "");
        } catch (Exception e) {
            e.printStackTrace();
            return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
        }
        return TaotaoResult.ok();
    }

}
