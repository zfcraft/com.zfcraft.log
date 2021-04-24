package com.zfcraft.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by chen
 * 2020/3/13.
 */
@Controller
public class IndexController {

    @RequestMapping("/kk")
    public String index(){
        return "login1";
    }

    @RequestMapping("/mm")
    public String indexCar(){
        return "fanIndex";
    }
    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }

}
