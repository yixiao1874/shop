package com.my.shop.shopmanagerservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Hello {
    @RequestMapping("index")
    public String hello(){
        return "index";
    }
}
