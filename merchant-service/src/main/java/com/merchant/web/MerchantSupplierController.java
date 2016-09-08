package com.merchant.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.merchant.dto.BaseResponseDto;
import com.merchant.dto.CommonResponseDto;
import com.merchant.dto.QueryMerchantsResponseDto;
import com.merchant.dto.ResultMessage;
import com.merchant.form.CommonFrom;
import com.merchant.form.MerchantsQueryBean;
import com.merchant.model.MerchantsSupplier;
import com.merchant.service.MerchantsSupplierService;
import com.merchant.util.RequestUtil;

@RestController
public class MerchantSupplierController {

	private final Logger logger = Logger.getLogger(getClass());


	@Autowired
	private MerchantsSupplierService merchantsSupplierService;

	@RequestMapping(value = "/supplier/add" ,method = RequestMethod.POST)
	public Object supplierAdd(HttpServletRequest request){

		String jsonText = RequestUtil.readPostContent(request); 

		logger.warn("/supplier/add入参："+jsonText);
		MerchantsSupplier data = JSONObject.parseObject(jsonText, MerchantsSupplier.class);
		ResultMessage result = merchantsSupplierService.add(data);
		if (result.isSuccess()) {
			return new BaseResponseDto("success","10000");
		}

		return new BaseResponseDto("success","90001");


	}

	@RequestMapping(value = "/supplier/query" ,method = RequestMethod.GET)
	public Object query(HttpServletRequest request) {

		String id=request.getParameter("id");
		CommonResponseDto commonResponseDto=new CommonResponseDto();

		logger.warn("/supplier/query入参："+id);
		if(id==null||"".equals(id)){

			commonResponseDto.setErrorMsg("参数不全！");
			commonResponseDto.setResultCode("10001");
			commonResponseDto.setResultType("success");

		}else{

			MerchantsSupplier merchantsSupplier=merchantsSupplierService.queryById(Integer.parseInt(id));

			if(merchantsSupplier==null){
				commonResponseDto.setErrorMsg("该商户不存在！");
				commonResponseDto.setResultCode("90001");
				commonResponseDto.setResultType("success");
			}else{
				commonResponseDto.setErrorMsg("查询成功！");
				commonResponseDto.setResultCode("10000");
				commonResponseDto.setResultType("success");
				commonResponseDto.setMp(merchantsSupplier);
			}

		}
		return commonResponseDto;
	}

	@RequestMapping(value = "/supplier/list" ,method = RequestMethod.POST)
	public Object list(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 

		logger.warn("/supplier/list入参:"+jsonText);
		CommonFrom<MerchantsQueryBean> form = JSONObject.parseObject(jsonText, CommonFrom.class);
		QueryMerchantsResponseDto queryMerchantsResponseDto=new QueryMerchantsResponseDto();

		if(form.getQueryConditions()==null){

			queryMerchantsResponseDto.setErrorMsg("查询失败!");
			queryMerchantsResponseDto.setOffset(form.getOffset());
			queryMerchantsResponseDto.setPageSize(form.getPageSize());
			queryMerchantsResponseDto.setResultCode("10002");
			queryMerchantsResponseDto.setResultType("error");

		}else{

			List list = merchantsSupplierService.queryByPage(form);

			if(list==null){
				queryMerchantsResponseDto.setErrorMsg("查询失败!");
				queryMerchantsResponseDto.setOffset(form.getOffset());
				queryMerchantsResponseDto.setPageSize(form.getPageSize());
				queryMerchantsResponseDto.setResultCode("10002");
				queryMerchantsResponseDto.setResultType("error");
				//queryMerchantsResponseDto.setMerchants(list);

			}else{
				queryMerchantsResponseDto.setErrorMsg("查询成功!");
				queryMerchantsResponseDto.setOffset(form.getOffset());
				queryMerchantsResponseDto.setPageSize(form.getPageSize());
				queryMerchantsResponseDto.setResultCode("10000");
				queryMerchantsResponseDto.setResultType("success");
				queryMerchantsResponseDto.setMerchants(list);

			}

		}


		return queryMerchantsResponseDto;


	}
	
	@RequestMapping(value = "/supplier/ids" ,method = RequestMethod.POST)
	public Object ids(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 
		
		//JSONArray.

		logger.warn("/supplier/list入参:"+jsonText);
		CommonFrom<MerchantsQueryBean> form = JSONObject.parseObject(jsonText, CommonFrom.class);
		QueryMerchantsResponseDto queryMerchantsResponseDto=new QueryMerchantsResponseDto();

		if(form.getQueryConditions()==null){

			queryMerchantsResponseDto.setErrorMsg("查询失败!");
			queryMerchantsResponseDto.setOffset(form.getOffset());
			queryMerchantsResponseDto.setPageSize(form.getPageSize());
			queryMerchantsResponseDto.setResultCode("10002");
			queryMerchantsResponseDto.setResultType("error");

		}else{

			List list = merchantsSupplierService.queryByPage(form);

			if(list==null){
				queryMerchantsResponseDto.setErrorMsg("查询失败!");
				queryMerchantsResponseDto.setOffset(form.getOffset());
				queryMerchantsResponseDto.setPageSize(form.getPageSize());
				queryMerchantsResponseDto.setResultCode("10002");
				queryMerchantsResponseDto.setResultType("error");
				//queryMerchantsResponseDto.setMerchants(list);

			}else{
				queryMerchantsResponseDto.setErrorMsg("查询成功!");
				queryMerchantsResponseDto.setOffset(form.getOffset());
				queryMerchantsResponseDto.setPageSize(form.getPageSize());
				queryMerchantsResponseDto.setResultCode("10000");
				queryMerchantsResponseDto.setResultType("success");
				queryMerchantsResponseDto.setMerchants(list);

			}

		}


		return queryMerchantsResponseDto;


	}


	@RequestMapping(value = "/supplier/update" ,method = RequestMethod.POST)
	public Object update(HttpServletRequest request) {
		String jsonText = RequestUtil.readPostContent(request); 

		logger.warn("/supplier/update入参:"+jsonText);
		MerchantsSupplier form = JSONObject.parseObject(jsonText, MerchantsSupplier.class);

		BaseResponseDto baseResponseDto=new BaseResponseDto();

		if(form.getId()==null){

			baseResponseDto.setErrorMsg("更新失败!");
			baseResponseDto.setResultCode("10001");
			baseResponseDto.setResultType("success");

		}else{

			int result=merchantsSupplierService.updateMerchantsSupplier(form);

			if(result>0){
				baseResponseDto.setErrorMsg("更新成功!");
				baseResponseDto.setResultCode("10000");
				baseResponseDto.setResultType("success");

			}else{
				baseResponseDto.setErrorMsg("更新失败!");
				baseResponseDto.setResultCode("10002");
				baseResponseDto.setResultType("success");

			}

		}


		return baseResponseDto;


	}

}