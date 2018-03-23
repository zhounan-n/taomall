package com.taomall.portal.controller;

import com.taomall.portal.services.ContentServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/httpclient/post", method = RequestMethod.POST,
            produces = MediaType.TEXT_PLAIN_VALUE + ";charset=utf-8")
    @ResponseBody
    public String testPost(String username, String password) {
        String result = "username:" + username + "\tpassword:" + password;
        System.out.println(result);
        return "username:" + username + ",password:" + password;
    }

}
