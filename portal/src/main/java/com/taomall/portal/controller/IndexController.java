package com.taomall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoun on 2018/3/20.
 **/
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String showIndex() throws Exception {
        return "index";
    }

}
