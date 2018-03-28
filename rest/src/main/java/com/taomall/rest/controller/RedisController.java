package com.taomall.rest.controller;

import com.taomall.common.entities.TaotaoResult;
import com.taomall.rest.services.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhoun on 2018/3/28.
 **/
@Controller
@RequestMapping("/cache/sync")
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/content/{contentCid}")
    @ResponseBody
    public TaotaoResult contentCacheSync(@PathVariable Long contentCid) {
        TaotaoResult result = redisService.syncContent(contentCid);
        return result;
    }


}
