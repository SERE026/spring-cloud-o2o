package com.icloud.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.icloud.common.ServiceUrlContants;
import com.icloud.dto.BaseResponseDto;
import com.icloud.dto.MpDetailResponseDto;
import com.icloud.dto.QueryMpResponseDto;
import com.icloud.model.MerchantsAccount;
import com.icloud.model.MerchantsMp;


@RestController
public class MerchantsMpController extends BaseController {
	

	/**
	 * 添加公众号
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/mp/add", method = RequestMethod.POST)
	public Object mpAdd(HttpServletRequest request) {
		String jsonParams = request.getParameter("data");
		String result = doPost(ServiceUrlContants.mct_mp_add, jsonParams);
		BaseResponseDto addDto = JSONObject.parseObject(result,com.icloud.dto.BaseResponseDto.class);
		return addDto;
		
	}
	
	/**
	 * 获取当前账户所管理的公众号列表
	 * @param access_token
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/mp/list", method = RequestMethod.POST)
	public Object mpList(@PathVariable("access_token") String access_token,@PathVariable("data") String data) {
		MerchantsAccount account = currentMerchants(access_token);
		/*if (account == null) {
			return new QueryMpResponseDto("success","40002","token失效");
			
		}*/
		int account_id = account.getId();
		JSONObject jsonObj = JSONObject.parseObject(data);
		JSONObject dataObj = new  JSONObject();
		jsonObj.put("account_id", account_id);
		dataObj.put("data", jsonObj.toString());
		String result = doPost(ServiceUrlContants.mct_mp_list, dataObj);
		QueryMpResponseDto queryDto = JSONObject.parseObject(result,QueryMpResponseDto.class);
		return queryDto;
		
	}
	
	/**
	 * 获取指定账户所管理的公众号列表
	 * @param account_id
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/admin/mp/list", method = RequestMethod.POST)
	public Object admin_MpList(@PathVariable("account_id") String account_id,@PathVariable("data") String data) {
		JSONObject jsonObj = JSONObject.parseObject(data);
		JSONObject dataObj = new  JSONObject();
		jsonObj.put("account_id", account_id);
		dataObj.put("data", jsonObj.toString());
		String result = doPost(ServiceUrlContants.mct_mp_list, dataObj);
		QueryMpResponseDto queryDto = JSONObject.parseObject(result,QueryMpResponseDto.class);
		return queryDto;
	}
	
 
	@RequestMapping(value = "/mp/disable", method = RequestMethod.GET)
	public Object mpDisable(@PathVariable("mp_id") String mp_id,@PathVariable("access_token") String access_token) { 
		MpDetailResponseDto mpDeDto = null; 
		BaseResponseDto baseDto = null;
		String rType = "";
		String rCode = "";
		String result = "";
		
		result = doPost(ServiceUrlContants.mct_mp_query+"/id="+mp_id, ""); //查询Mp
		mpDeDto = JSONObject.parseObject(result,MpDetailResponseDto.class);
		rType = mpDeDto.getResultType();
		rCode = mpDeDto.getResultCode();  
		if ("success".endsWith(rType) && "10000".endsWith(rCode) ) { 
			MerchantsMp mp = mpDeDto.getMp();
			mp.setUseStatus("0");//设置不启用
			result = doPost(ServiceUrlContants.mct_mp_update, JSONObject.toJSONString(mp)); //修改Mp不可用
			baseDto = JSONObject.parseObject(result,BaseResponseDto.class);
			if ("success".endsWith(rType) && "10000".endsWith(rCode) ) { 
				JSONObject params = new  JSONObject();
				params.put("mp_id", mp_id);
				result = doPost(ServiceUrlContants.mct_mp_merchants_del+"/id="+mp_id , params);//删除公众号与商户关联
				baseDto = JSONObject.parseObject(result,BaseResponseDto.class);
			}
		}
		return baseDto;
		
	}

}