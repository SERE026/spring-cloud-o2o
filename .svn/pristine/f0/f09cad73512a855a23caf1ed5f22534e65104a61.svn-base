package com.icloud.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.common.ServiceUrlContants;
import com.icloud.dto.BaseAddDto;
import com.icloud.dto.BaseDto;
import com.icloud.dto.MpQueryDto;
import com.icloud.dto.SupplierDetailDto;
import com.icloud.dto.SupplierQueryDto;
import com.icloud.model.MerchantsSupplier;
import com.icloud.service.MerchantsSupplierService;

@Service
public class MerchantsSupplierServiceImpl extends BaseServiceImple implements MerchantsSupplierService{

	
	/**
	 * 更新
	 * @param jsonParams
	 * @return
	 */
	public BaseDto update(String jsonParams) { 
		BaseDto dto = null;
		dto = doPost(ServiceUrlContants.mct_supplier_update, jsonParams,BaseDto.class);
		return dto;
	}
	
	
	/**
	 * 添加
	 * @param jsonParams
	 * @param accountId
	 * @return
	 */
	public BaseDto add(String jsonParams,Integer accountId) { 
		BaseDto dto = null;
		BaseAddDto addDto = null;
		String rType = "";
		String rCode = "";  
		addDto = doPost(ServiceUrlContants.mct_supplier_add, jsonParams,BaseAddDto.class);
		rType = addDto.getResultType();
		rCode = addDto.getResultCode();  
		if ("success".endsWith(rType) && "10000".endsWith(rCode) ) { 
			JSONObject param = new JSONObject();
			Integer merchants = addDto.getId();
			param.put("accountId", accountId);
			param.put("merchants", merchants+"");
			dto = doPost(ServiceUrlContants.mct_accountMerchants_add, param.toJSONString(),BaseDto.class);
		}else{
			dto = new BaseDto(rType, rCode, addDto.getErrorMsg());
		}
		
		return dto;
	}
	
	
	/**
	 * 查询
	 * @param merchantsId
	 * @return
	 */
	public SupplierDetailDto get(Integer merchantsId) { 
		SupplierDetailDto dto = null;
		String url = ServiceUrlContants.mct_supplier_query+"?id="+merchantsId;
		dto = doGet(url, SupplierDetailDto.class);
		return dto;
	}
	
	
	/**
	 * 查询列表
	 * @param jsonParams
	 * @param accountId
	 * @return
	 */
	public SupplierQueryDto list(String jsonParams,Integer accountId) { 
		SupplierQueryDto dto = null;
		JSONObject json = (JSONObject) JSONObject.parse(jsonParams);
		json.put("accountId", accountId);
		dto = doPost(ServiceUrlContants.mct_supplier_list_forAccount, json,SupplierQueryDto.class);
		return dto;
	}
	
	/**
	 * 根据商户号查询公众号列表
	 * @param merchantsId
	 * @return
	 */
	public MpQueryDto findMpListByMerchant(Integer merchantsId){
		MpQueryDto dto = null;
		String url = ServiceUrlContants.mct_supplier_query+"?id="+merchantsId;
		dto = doGet(url, MpQueryDto.class);
		return dto;
	}
	
	/**
	 * 商户审核
	 * @param jsonParams
	 * @return
	 */
	public BaseDto audit(String jsonParams) {
		SupplierDetailDto detailDto = null;
		BaseDto dto = null;  
		JSONObject json = (JSONObject) JSONObject.parse(jsonParams);
		Integer merchantsId = json.getInteger("merchantsId");
		String auditStatus = json.getString("auditStatus");
		String messageJson = json.getString("message");
		
		String url = ServiceUrlContants.mct_supplier_query+"?id="+merchantsId;//查询商户
		detailDto = doGet(url, SupplierDetailDto.class);
		
		if (detailDto.isSuccess() ) { 
			MerchantsSupplier merchants = detailDto.getMerchants();
			merchants.setAuditStatus(auditStatus);
			JSONObject jsonObj = (JSONObject) JSONObject.toJSON(merchants);
			dto = doPost(ServiceUrlContants.mct_supplier_update, jsonObj,BaseDto.class);//更改商户审核信息
			if (dto.isSuccess() ) { 
				dto = doPost(ServiceUrlContants.mct_message_add, messageJson,BaseDto.class);//发送消息
			}
		}else{
			return new BaseDto(detailDto.getResultType(), detailDto.getResultCode(), detailDto.getErrorMsg()); 
		}
		
		return dto;
	}
	
	/**
	 * 修改商户关联公众号
	 * @param jsonParams
	 * @return
	 */
	public BaseDto caseMerchantsMp(String jsonParams) {
		BaseDto dto = null;  
		JSONObject json = (JSONObject) JSONObject.parse(jsonParams);
		Integer merchantsId = json.getInteger("merchantsId");
		
		String url = ServiceUrlContants.mct_accountMerchants_del+"?merchantsId="+merchantsId;//根据merchantsId删除关联关系
		dto = doGet(url, BaseDto.class);
		
		if (dto.isSuccess() ) {  
			dto = doPost(ServiceUrlContants.mct_accountMerchants_add, jsonParams,BaseDto.class);//更改商户审核信息
		} 
		
		return dto;
	}


 
	
	
	
}
