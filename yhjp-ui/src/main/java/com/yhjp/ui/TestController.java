package com.yhjp.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/ee")
    public  String index(Model model){
        return  "index";
    }

    @RequestMapping("/bb")
    public  String index1(Model model, ModelMap map){
    System.out.println("say hi ……");

        map.put("name", "kimi");
    return  "index.ftl";
    }
    @ResponseBody
    @RequestMapping(value = "/savePdf",method = RequestMethod.POST)
    public  String savePdf(Model model, @RequestBody String allHtml){
      System.out.println(allHtml);
        return  "success";
    }
}
