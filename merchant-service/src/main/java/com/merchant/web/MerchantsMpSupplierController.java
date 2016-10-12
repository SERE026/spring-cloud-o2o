package com.merchant.web;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.merchant.dto.BaseAddDto;
import com.merchant.dto.BaseDto;
import com.merchant.dto.ResultMessage;
import com.merchant.model.MerchantsMpSupplier;
import com.merchant.service.MerchantsMpSupplierService;
import com.merchant.util.RequestUtil;

@RestController
public class MerchantsMpSupplierController {
	private final Logger logger = Logger.getLogger(getClass());
 
	
    @Autowired
	private MerchantsMpSupplierService mtsMpSupplierService;

    /**3.1 添加接口*/
	@RequestMapping(value = "/mpMerchants/add")
	public Object add(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 
		MerchantsMpSupplier data = null;
		try {
			data = JSONObject.parseObject(jsonText, MerchantsMpSupplier.class);
		} catch (Exception e) {
			return new BaseAddDto("success","10002","参数格式错误");
		}
		ResultMessage result = mtsMpSupplierService.add(data);
		if (result.isSuccess()) {
			Integer id = (Integer) result.getData();
			return new BaseAddDto("success", "10000",id);
		}
		return new BaseAddDto("success","90001");
	}
	
	
	
	/**3.2 删除接口*/
	@RequestMapping(value = "/mpMerchants/del")
	public Object del(Integer mpId,Integer merchantsId) {
		if (mpId == null && merchantsId == null) {
			return new BaseDto("success","10001","参数不全");
		}
		ResultMessage result = mtsMpSupplierService.delete(mpId,merchantsId);
		if (result.isSuccess()) {
			return new BaseDto("success","10000");
		}
		
		return new BaseDto("success","90001");
	}
	
	
 
	
 
	
	
	
	
    

}