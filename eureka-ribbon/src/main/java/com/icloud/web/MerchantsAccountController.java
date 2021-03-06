package com.icloud.web;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icloud.model.MerchantsAccount;
import com.icloud.service.MerchantsAccountService;


@RestController
@SuppressWarnings("rawtypes")
public class MerchantsAccountController{
	@Autowired
	 private MerchantsAccountService mtsAccountService;  
	
 
	/**添加商户账户**/
	@RequestMapping(value = "/account/add")
	 public ResponseEntity add(String data) throws Exception {
        return Optional.ofNullable(mtsAccountService.add(data))
                .map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("Could not find shopping cart"));
    }
	
	/**商户自主注册**/
	@RequestMapping(value = "/account/register")
	public ResponseEntity register(String data) throws Exception {
		return Optional.ofNullable(mtsAccountService.add(data))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("Could not find shopping cart"));
	}
	
	
	/**更新商户账户**/
	@RequestMapping(value = "/account/update")
	public ResponseEntity update(String data) throws Exception {
		return Optional.ofNullable(mtsAccountService.update(data))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("Could not find shopping cart"));
	}
	
	
	/** 获取商户账户列表 */ 
	@RequestMapping(value = "/account/list")
	public ResponseEntity list(String data) throws Exception {
		return Optional.ofNullable(mtsAccountService.list(data))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("Could not find shopping cart"));
	}
	 
	
	/** 商户账户是否可用 */ 
	@RequestMapping(value = "/account/has")
	public ResponseEntity has(String account) throws Exception {
		return Optional.ofNullable(mtsAccountService.has(account))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("Could not find shopping cart"));
	}
 
	
	/** 商户账户信息获取 */ 
	@RequestMapping(value = "/account/get")
	public ResponseEntity get(Integer accountId,HttpServletRequest request) throws Exception {
		if (accountId == null) {
			MerchantsAccount account =  (MerchantsAccount) request.getAttribute("merchants");
			accountId = account.getId();
		}
		return Optional.ofNullable(mtsAccountService.get(accountId))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("Could not find shopping cart"));
	}
	

}