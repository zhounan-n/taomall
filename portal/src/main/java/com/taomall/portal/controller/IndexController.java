package com.taomall.portal.controller;

import com.taomall.portal.services.ContentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoun on 2018/3/20.
 **/
@Controller
public class IndexController {

    @Autowired
    private ContentServie contentServie;

    @RequestMapping("/index")
    public String showIndex(Model model) throws Exception {
        String adJson = contentServie.getContentList();
        model.addAttribute("ad1", adJson);
        return "index";
    }

}
