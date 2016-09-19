package com.icloud.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icloud.model.MerchantsAccount;
import com.icloud.service.MerchantsSupplierService;


@RestController
@SuppressWarnings("rawtypes")
public class MerchantsSupplierController extends BaseController {
	@Autowired
	 private MerchantsSupplierService mtsSupplierService;  
	
	 /**添加商户号**/
	@RequestMapping(value = "/merchants/add")
	public ResponseEntity add(String data) throws Exception {
		MerchantsAccount account =  currentMerchants();
		Integer accountId = account.getId();
		return Optional.ofNullable(mtsSupplierService.add(data, accountId))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("add message fail"));
	}
	
	
	/**更新**/
	@RequestMapping(value = "/merchants/update")
	public ResponseEntity update(String data) throws Exception {
		return Optional.ofNullable(mtsSupplierService.update(data))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("add message fail"));
	}
	
	
	/**列表**/
	@RequestMapping(value = "/merchants/list")
	 public ResponseEntity list(String data,Integer accountId) throws Exception {
		if (accountId == null) {
			MerchantsAccount account =  currentMerchants();
			accountId = account.getId();
		}
        return Optional.ofNullable(mtsSupplierService.list(data, accountId))
                .map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
                .orElseThrow(() -> new Exception("list message fail "));
    }
	
	
	/**商户对应公众号**/
	@RequestMapping(value = "/merchants/mp")
	public ResponseEntity mplist(String data,Integer accountId) throws Exception {
		if (accountId == null) {
			MerchantsAccount account =  currentMerchants();
			accountId = account.getId();
		}
		return Optional.ofNullable(mtsSupplierService.list(data, accountId))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("list message fail "));
	}
	
	/**获取详情**/ 
	@RequestMapping(value = "/merchants/get")
	public ResponseEntity get(Integer merchantsId) throws Exception {
		return Optional.ofNullable(mtsSupplierService.get(merchantsId))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("update message fail"));
	}
	
	
	/**修改商户关联公众号**/ 
	@RequestMapping(value = "/merchants/merchants_mp")
	public ResponseEntity case_merchants_mp(String data) throws Exception {
		return Optional.ofNullable(mtsSupplierService.caseMerchantsMp(data))
				.map(event -> new ResponseEntity(HttpStatus.NO_CONTENT))
				.orElseThrow(() -> new Exception("update message fail"));
	}
	
	

	 
}