package com.taomall.rest.controller;

import com.taomall.common.utils.JsonUtils;
import com.taomall.rest.entities.CatResult;
import com.taomall.rest.services.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by zhoun on 2018/3/21.
 **/
@Controller
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "itemcat/list", produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
    @ResponseBody
    public String getItemCatList(String callback) {
        CatResult catResult = itemCatService.getItemCatResult();
        String json = JsonUtils.objectToJson(catResult);
        String result = callback + "(" + json + ")";
        return result;
    }

}
