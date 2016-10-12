package com.icloud.service;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.ConfigUtil;
import com.icloud.common.ServiceUrlContants;
import com.icloud.dto.AccountLoginCheckDto;
import com.icloud.dto.TakeTokenDto;
import com.icloud.dto.TokenMessageDto;
import com.icloud.service.redis.RedisService;
/**
 * 当前只实现对商户的token
 * 其他角色的 token待完善  //TODO
 * @author luoqw
 *2016年9月20日 下午2:12:27
 */
@Service
public class TokenService  extends BaseServiceImple{  
 
	
	@Autowired
	private RedisService redisService;
	
	public AccountLoginCheckDto loginCheck(String account,String password){
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("account", account);
		jsonObj.put("password", password);
		String url = ServiceUrlContants.mct_account_validation;
		AccountLoginCheckDto  dto = doPost(url, jsonObj,AccountLoginCheckDto.class); 
		return dto;
	}
	
	public TakeTokenDto getToken(String grantType ,String account,String password){
		TakeTokenDto takeDto = null;
		if (StringUtils.isBlank(account) || StringUtils.isBlank(password)) {
			return new TakeTokenDto("success", "10001", "参数不全");
		}
		AccountLoginCheckDto  dto = loginCheck(account, password);
		if (dto.isSuccess() && dto.isResultCheck()) {
			String accessToken = UUID.randomUUID().toString(); 
			long expireTime = Long.parseLong(ConfigUtil.get("expireTime")) ;
			TokenMessageDto tokenMsg = new TokenMessageDto("success", "10000", grantType, dto.getAccout());
			String tokenVal = JSONObject.toJSONString(tokenMsg);
			redisService.set(accessToken, tokenVal, expireTime);
			takeDto = new TakeTokenDto("success", "10000", accessToken, expireTime+"");
		}else{
			return new TakeTokenDto("success", "40001","身份认证失败");
		}
		
		return takeDto;
	}
	
	
	public TokenMessageDto getUserInfo(String accessToken,String grantType){
		String tokenVal =   (String) redisService.get(accessToken);
		if (StringUtils.isBlank(tokenVal)) {
			return new TokenMessageDto("success", "40002", "token无效",grantType);
		}
		TokenMessageDto dto =  JSONObject.parseObject(tokenVal,TokenMessageDto.class);
		return dto;
	}

}
