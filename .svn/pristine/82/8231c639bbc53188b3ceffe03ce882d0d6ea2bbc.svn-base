package com.didispace.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.didispace.service.redis.RedisUtil;

@RestController
public class ConsumerController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
    	redisUtil.set("11","000");
    	System.out.println(redisUtil.get("11"));
    	
    	
        return "success";
    }


}