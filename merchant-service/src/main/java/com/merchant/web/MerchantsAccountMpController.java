package com.merchant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merchant.dto.BaseResponseDto;
import com.merchant.dto.ResultMessage;
import com.merchant.model.MerchantsAccountMp;
import com.merchant.service.MerchantsAccountMpService;

@RestController
public class MerchantsAccountMpController {

 
    @Autowired
	private MerchantsAccountMpService mtsAccountMpService;

    /**3.1 添加接口*/
	@RequestMapping(value = "/account_mp/add", method = RequestMethod.POST)
	public Object add(MerchantsAccountMp data) {
		ResultMessage result = mtsAccountMpService.add(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
 
	/**3.2 删除接口*/
	@RequestMapping(value = "/mp_merchants/del", method = RequestMethod.POST)
	public Object del(@PathVariable("mpId")Integer mpId,@PathVariable("accountId")Integer accountId) {
		if (mpId == null && accountId == null) {
			return new BaseResponseDto("success","10001");
		}
		ResultMessage result = mtsAccountMpService.deleteByAccountIdAndMpId(accountId,mpId);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	
 
	
 
	
	
	
	
    

}