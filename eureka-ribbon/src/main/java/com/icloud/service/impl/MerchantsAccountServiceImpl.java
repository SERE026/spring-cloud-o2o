package com.icloud.service.impl;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.common.ServiceUrlContants;
import com.icloud.dto.BaseResponseDto;
import com.icloud.dto.MerchantsAccountCheckResDto;
import com.icloud.dto.MerchantsAccountDetailResDto;
import com.icloud.dto.MerchantsAccountQueryResDto;
import com.icloud.service.MerchantsAccountService;


@Service
public class MerchantsAccountServiceImpl extends BaseServiceImple implements MerchantsAccountService{

	@Override
	public BaseResponseDto add(String data) {
		BaseResponseDto dto = doPost(ServiceUrlContants.mct_account_add, data,BaseResponseDto.class);
		return dto;
	}
	
	
	@Override
	public BaseResponseDto update(String data) {
		JSONObject obj = JSONObject.parseObject(data);
		Integer id = obj.getInteger("id");
		if (id == null) {
			return new BaseResponseDto("success", "10001","id不能为空");
		}
		BaseResponseDto dto = doPost(ServiceUrlContants.mct_account_add, data,BaseResponseDto.class);
		return dto;
	}

	
	@Override
	public MerchantsAccountQueryResDto list(String data) {
		MerchantsAccountQueryResDto dto = doPost(ServiceUrlContants.mct_account_list, data,MerchantsAccountQueryResDto.class);
		return dto;
	}
	
	@Override
	public MerchantsAccountCheckResDto has(String account) {
		MerchantsAccountCheckResDto dto = doGet(ServiceUrlContants.mct_account_list+"?accoount="+account,
				MerchantsAccountCheckResDto.class);
		return dto;
	}
	
	@Override
	public MerchantsAccountDetailResDto get(Integer id) {
		MerchantsAccountDetailResDto dto = doGet(ServiceUrlContants.mct_account_get+"?id="+id,
				MerchantsAccountDetailResDto.class);
		return dto;
	}




}