package com.taomall.controller;

import com.taomall.entities.EuTreeNode;
import com.taomall.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhoun on 2018/3/19.
 **/
@Controller
@RequestMapping(value = "/item/cat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<EuTreeNode> listNode(@RequestParam(value = "id", defaultValue = "0") Long parentId) {
        List<EuTreeNode> list = itemCatService.listCategories(parentId);
        return list;
    }
}
