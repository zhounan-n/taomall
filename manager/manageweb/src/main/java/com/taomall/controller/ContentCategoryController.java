package com.taomall.controller;

import com.taomall.common.entities.EuTreeNode;
import com.taomall.common.entities.TaotaoResult;
import com.taomall.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容分类
 * Created by zhoun on 2018/3/21.
 **/
@Controller
@RequestMapping(value = "/content/category")
public class ContentCategoryController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EuTreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
        List<EuTreeNode> list = contentCategoryService.getCategoryList(parentId);
        return list;
    }

    @RequestMapping("/create")
    @ResponseBody
    public TaotaoResult createContentCategory(Long parentId, String name) {
        TaotaoResult result = contentCategoryService.insertContentCategory(parentId, name);
        return result;
    }

}
