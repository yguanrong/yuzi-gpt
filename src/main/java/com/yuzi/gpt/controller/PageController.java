package com.yuzi.gpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YangGuanRong
 * date: 2023/4/3
 */
@Controller
public class PageController {

    @RequestMapping("/index")
    public String index(ModelMap map){
        map.addAttribute("newWorld","WELCOME TO NEW WORLD!!!");
        return "index";
    }

    @RequestMapping("/")
    public String newPage(ModelMap map){
        map.addAttribute("newWorld","WELCOME TO NEW WORLD!!!");
        return "index";
    }
}
