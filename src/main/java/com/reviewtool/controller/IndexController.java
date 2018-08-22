package com.reviewtool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Author wuyongqiang
 * @Date 2018/8/16 11:19
 * @Version 1.0
 **/
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
