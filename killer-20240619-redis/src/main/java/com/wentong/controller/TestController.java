package com.wentong.controller;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private JedisPool jedisPool;

    @GetMapping("go")
    public String go() {
        long start = System.currentTimeMillis();
        Jedis resource = jedisPool.getResource();
        resource.set(UUID.randomUUID().toString(), "abc");
        resource.close();
        return "" + (System.currentTimeMillis() - start);
    }

    @GetMapping("metrics")
    public String metrics() {
        return JSON.toJSONString(jedisPool.listAllObjects());
    }

}
