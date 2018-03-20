package com.taomall.controller;

import com.taomall.common.entities.ListResult;
import com.taomall.common.entities.TaotaoResult;
import com.taomall.entities.TbItem;
import com.taomall.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by zhoun on 2018/3/18.
 **/
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }


    @RequestMapping(value = "/item/list")
    @ResponseBody
    public ListResult listItems(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows) {
        ListResult result = itemService.listItem(page, rows);
        return result;
    }

    @RequestMapping(value = "/item/save", method = RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
        TaotaoResult result = itemService.addItem(item, desc, itemParams);
        return result;
    }



}
