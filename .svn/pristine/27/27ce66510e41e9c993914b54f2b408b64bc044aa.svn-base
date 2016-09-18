package com.icloud.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.common.ServiceUrlContants;
import com.icloud.dto.BaseResponseDto;
import com.icloud.dto.MerchantsMessageDetailResDto;
import com.icloud.dto.MerchantsMessageQueryResDto;
import com.icloud.model.MerchantsMessage;
import com.icloud.service.MerchantsMessageService;


@Service
public class MerchantsMessageServiceImpl extends BaseServiceImple implements MerchantsMessageService{

	@Override
	public MerchantsMessageQueryResDto list(String data) {
		MerchantsMessageQueryResDto dto = doPost(ServiceUrlContants.mct_message_list, data,MerchantsMessageQueryResDto.class);
		return dto;
	}
	@Override
	public BaseResponseDto add(String jsonParams) {
		BaseResponseDto addDto = doPost(ServiceUrlContants.mct_message_add, jsonParams,BaseResponseDto.class);
		return addDto;
	}
	@Override
	public BaseResponseDto markRead(Integer messageId) {
		BaseResponseDto baseDto = null;
		String rType = "";
		String rCode = "";  

		MerchantsMessageDetailResDto detailDto = doGet(ServiceUrlContants.mct_message_get+"?id="+messageId,
				MerchantsMessageDetailResDto.class);//查询
		rType = detailDto.getResultType();
		rCode = detailDto.getResultCode();  
		if ("success".endsWith(rType) && "10000".endsWith(rCode) ) { 
			MerchantsMessage message = detailDto.getMessage();
			if (message != null) {
				message.setReadState("1");//标记已读
				JSONObject jsonObj = (JSONObject) JSONObject.toJSON(message);
				baseDto = doPost(ServiceUrlContants.mct_message_update, jsonObj,BaseResponseDto.class);//更新
			}else{
				baseDto = new BaseResponseDto(rType, rCode,detailDto.getErrorMsg());
			}
		}else{
			baseDto = new BaseResponseDto(rType, rCode,detailDto.getErrorMsg());
		}
		return baseDto;
	}



}