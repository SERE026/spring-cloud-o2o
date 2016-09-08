package com.merchant.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.merchant.dto.BaseResponseDto;
import com.merchant.dto.ResultMessage;
import com.merchant.model.MerchantsMpSupplier;
import com.merchant.service.MerchantsMpSupplierService;

@RestController
public class MerchantsMpSupplierController {

 
    @Autowired
	private MerchantsMpSupplierService mtsMpSupplierService;

    /**3.1 添加接口*/
	@RequestMapping(value = "/mp_merchants/add", method = RequestMethod.POST)
	public Object add(MerchantsMpSupplier data) {
		ResultMessage result = mtsMpSupplierService.add(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	
	
	/**3.2 删除接口*/
	@RequestMapping(value = "/mp_merchants/del", method = RequestMethod.POST)
	public Object del(
			@PathVariable("mpId")Integer mpId,
			@PathVariable("merchantsId")Integer merchantsId) {
		
		if (mpId == null && merchantsId == null) {
			return new BaseResponseDto("success","10001");
		}
		ResultMessage result = mtsMpSupplierService.delete(mpId,merchantsId);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	
 
	
 
	
	
	
	
    

}