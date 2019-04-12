package com.yhjp.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/ee")
    public  String index(Model model){
        return  "index";
    }

    @RequestMapping("/bb")
    public  String index1(Model model){
        return  "index.ftl";
    }
}
