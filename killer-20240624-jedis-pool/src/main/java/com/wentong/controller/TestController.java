package com.wentong.controller;

import com.wentong.config.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RedisClient redisClient;

    @GetMapping("go")
    String go() {
//        redisClient.set("abc", "a");
        return redisClient.get("abc");

    }

}
