package com.wentong.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(200);
        config.setMinIdle(100);
        config.setMaxTotal(200);
        config.setMinEvictableIdleTimeMillis(3000);
        config.setTimeBetweenEvictionRunsMillis(1000);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        config.setTestWhileIdle(false);
        config.setTestOnCreate(false);
        config.setJmxEnabled(false);
        return config;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig  jedisPoolConfig){
        return new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);
    }
}
