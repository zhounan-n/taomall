package com.taomall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhoun on 2018/3/18.
 **/
@Controller
public class PageController {

    @RequestMapping(value = "/")
    public String showIndex() {
        return "index";
    }

    @RequestMapping(value = "/{page}")
    public String page(@PathVariable String page) {
        return page;
    }


}
