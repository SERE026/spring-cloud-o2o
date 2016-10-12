package com.icloud.web;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.icloud.dto.TakeTokenDto;
import com.icloud.dto.TokenMessageDto;
import com.icloud.service.TokenService;
import com.icloud.service.redis.RedisService;
 

@RestController
public class TokenController {

    @Autowired
    RestTemplate restTemplate;
    @Autowired
    RedisService redisUtil;
    @Autowired
    TokenService tokenService;
    
    @RequestMapping(value = "/token/get")
    public Object get(String grantType,String account,String password) {
    	TakeTokenDto dto = tokenService.getToken(grantType, account, password);
        return dto;
    }
  
    
    
    @RequestMapping(value = "/token/userInfo")
    public Object userInfo(String grantType,String accessToken) {
    	
    	if (StringUtils.isBlank(grantType) || StringUtils.isBlank(accessToken) ) {
    		return new TakeTokenDto("success", "10001", "参数不全");
    	}
    	TokenMessageDto dto = tokenService.getUserInfo(accessToken, grantType);
    	return dto;
    }
   
    


}