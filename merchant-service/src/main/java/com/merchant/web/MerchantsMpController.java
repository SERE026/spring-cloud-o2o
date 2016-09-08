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
import com.merchant.dto.MerchantsMpDetailResDto;
import com.merchant.dto.MerchantsMpQueryResDto;
import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsMpForm;
import com.merchant.model.MerchantsMp;
import com.merchant.service.MerchantsMpService;
import com.merchant.util.RequestUtil;

@RestController
public class MerchantsMpController {

 
    @Autowired
	private MerchantsMpService merchantsMpService;

    /**1.1 添加接口*/
	@RequestMapping(value = "/mp/add", method = RequestMethod.POST)
	public Object add(MerchantsMp data) {
		ResultMessage result = merchantsMpService.add(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	
	/**1.2查询接口**/
	@RequestMapping(value = "/mp/list", method = RequestMethod.POST)
	public Object list(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 
		MerchantsMpForm form = JSONObject.parseObject(jsonText, MerchantsMpForm.class);
		ResultMessage result = merchantsMpService.queryByPage(form);
		if (result.isSuccess()) {
			@SuppressWarnings("unchecked")
			List<MerchantsMp> list = (List<MerchantsMp>) result.getData();
			return new MerchantsMpQueryResDto("success","10000",form.getOffset(),form.getPageSize(),list);
		}
		
		return new MerchantsMpQueryResDto("success","90001","查询失败",form.getOffset(),form.getPageSize());
	}
	
	@RequestMapping(value = "/mp/list/formerchants", method = RequestMethod.POST)
	public Object listFormerchants(
			@PathVariable("merchantsId") Integer merchantsId,
			@PathVariable("offset") Integer offset,
			@PathVariable("pageSize") Integer pageSize) {  
		ResultMessage result = merchantsMpService.queryByPageForMerchants(merchantsId,offset,pageSize);
		if (result.isSuccess()) {
			@SuppressWarnings("unchecked")
			List<MerchantsMp> list = (List<MerchantsMp>) result.getData();
			return new MerchantsMpQueryResDto("success","10000",offset,pageSize,list);
		}
		
		return new MerchantsMpQueryResDto("success","90001","查询失败",offset,pageSize);
	}
	
	
	/**1.3 更新接口**/
	@RequestMapping(value = "/mp/update", method = RequestMethod.POST)
	public Object update(MerchantsMp data) { 
		ResultMessage result = merchantsMpService.updateByPrimaryKeySelective(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}
		
		return new BaseResponseDto("success","90001");
	}
	
	/**1.4 通过ID获取公众号详情接口**/
	@RequestMapping(value = "/mp/query", method = RequestMethod.GET)
	public Object query(@PathVariable("id") Integer id) { 
		ResultMessage result = merchantsMpService.findById(id); 
		if (result.isSuccess()) {
			MerchantsMp mp  = (MerchantsMp) result.getData();
			return new MerchantsMpDetailResDto("success","10000",mp);
		}
		
		return new MerchantsMpDetailResDto("success","90001","查询失败");
	}
	
	
 
	
	
	
	
    

}