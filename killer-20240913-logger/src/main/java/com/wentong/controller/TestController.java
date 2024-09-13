package com.wentong.controller;

import com.wentong.config.LogSystem;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        LogSystem.getLogSystemFromHost("shop.loongpos.com.cn");
        return "hello";
    }
}
