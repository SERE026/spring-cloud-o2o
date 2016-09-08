package com.icloud.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;
import com.icloud.common.ServiceUrlContants;
import com.icloud.model.MerchantsAccount;


/**
 * 基础Controller 提供常用方法
 * @author luoqw
 * 2016-9-6下午3:21:07
 */
public class BaseController {
	
	@Autowired
	public RestTemplate restTemplate;

	/**
	 * 发送http请求
	 * @param url 请求地址
	 * @param jsonParams 请求的参数（json字符串形式）
	 * @return json字符串
	 */
	public  String doPost(String url,String jsonParams) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(jsonParams, headers);
		String result = restTemplate.postForObject(url, formEntity, String.class);
		return result;
	}
	
	/**
	 * 发送http请求
	 * @param url 请求地址
	 * @param JSONObject 请求的参数（json对象）
	 * @return json字符串
	 */
	public  String doPost(String url,JSONObject jsonObj) {
		HttpHeaders headers = new HttpHeaders();
		MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
		headers.setContentType(type);
		headers.add("Accept", MediaType.APPLICATION_JSON.toString());
		HttpEntity<String> formEntity = new HttpEntity<String>(jsonObj.toString(), headers);
		String result = restTemplate.postForObject(url, formEntity, String.class);
		return result;
	}
	
	/**
	 * 根据access_token获取当前的商户信息
	 * @param access_token
	 * @return
	 */
	public MerchantsAccount currentMerchants(String access_token) {
		MerchantsAccount account = null;
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("access_token", access_token);
		jsonObj.put("grant_type", "merchants_credential");
		String result = doPost(ServiceUrlContants.token_server_domain, jsonObj); 
		jsonObj = JSONObject.parseObject(result);
		String resultType = (String) jsonObj.get("resultType");
		String resultCode = (String) jsonObj.get("resultCode");
		if ("success".endsWith(resultType) && "10000".endsWith(resultCode) ) {
			String userInfo = (String) jsonObj.get("userInfo");
			account = JSONObject.parseObject(userInfo,MerchantsAccount.class);
		}
		return account;
	}
	
	
 
	
}
