package com.merchant.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.fastjson.JSONObject;
import com.merchant.dto.BaseResponseDto;
import com.merchant.dto.MerchantsAccountCheckResDto;
import com.merchant.dto.MerchantsAccountDetailResDto;
import com.merchant.dto.MerchantsAccountLoginCheckResDto;
import com.merchant.dto.MerchantsAccountQueryResDto;
import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsAccountForm;
import com.merchant.model.MerchantsAccount;
import com.merchant.service.MerchantsAccountService;
import com.merchant.util.RequestUtil;

@RestController
public class MerchantsAccountController {

 
    @Autowired
	private MerchantsAccountService mtsAccountService;

     
	@RequestMapping(value = "/account/add", method = RequestMethod.POST)
	public Object add(MerchantsAccount data) {
		ResultMessage result = mtsAccountService.add(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	 
	@RequestMapping(value = "/account/update", method = RequestMethod.POST)
	public Object update(MerchantsAccount data) { 
		ResultMessage result = mtsAccountService.updateByPrimaryKeySelective(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	
	@RequestMapping(value = "/account/list", method = RequestMethod.POST)
	public Object list(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 
		MerchantsAccountForm form = JSONObject.parseObject(jsonText, MerchantsAccountForm.class);
		ResultMessage result = mtsAccountService.queryByPage(form);
		if (result.isSuccess()) {
			@SuppressWarnings("unchecked")
			List<MerchantsAccount> list = (List<MerchantsAccount>) result.getData();
			return new MerchantsAccountQueryResDto("success","10000",form.getOffset(),form.getPageSize(),list);
		}
		
		return new MerchantsAccountQueryResDto("success","90001","查询失败",form.getOffset(),form.getPageSize());
	}
	
 
	@RequestMapping(value = "/account/get", method = RequestMethod.GET)
	public Object get(@PathVariable("id") Integer id) { 
		ResultMessage result = mtsAccountService.findById(id); 
		if (result.isSuccess()) {
			MerchantsAccount account  = (MerchantsAccount) result.getData();
			return new MerchantsAccountDetailResDto("success","10000",account);
		}
		
		return new MerchantsAccountDetailResDto("success","90001","查询失败");
	}
	
	
	@RequestMapping(value = "/account/has", method = RequestMethod.GET)
	public Object has(@PathVariable("account") String account) { 
		ResultMessage result = mtsAccountService.countByAccount(account);
		if (result.isSuccess()) {
			Integer count  = (Integer) result.getData();
			boolean resultCheck = count>0?true:false;
			return new MerchantsAccountCheckResDto("success","10000",resultCheck);
		}
		
		return new MerchantsAccountCheckResDto("success","90001","查询失败");
	}
	
	
	@RequestMapping(value = "/account/validation", method = RequestMethod.GET)
	public Object validation(
			@PathVariable("account") String account,
			@PathVariable("password") String password) { 
		ResultMessage result = mtsAccountService.findByAccountAndPwd(account, password);
		if (result.isSuccess()) {
			MerchantsAccount mtsAccount  = (MerchantsAccount) result.getData();
			boolean resultCheck = mtsAccount!=null?true:false;
			return new MerchantsAccountLoginCheckResDto("success","10000",resultCheck,mtsAccount);
		}
		
		return new MerchantsAccountLoginCheckResDto("success","90001","查询失败");
	}
	
	
	
	
	
	
    

}