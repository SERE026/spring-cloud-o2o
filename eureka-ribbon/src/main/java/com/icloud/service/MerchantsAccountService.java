package com.icloud.service;

import com.icloud.dto.BaseResponseDto;
import com.icloud.dto.MerchantsAccountCheckResDto;
import com.icloud.dto.MerchantsAccountDetailResDto;
import com.icloud.dto.MerchantsAccountQueryResDto;

/**
 * 
 * @author luoqw
 *
 */
public interface MerchantsAccountService {

	public BaseResponseDto  add(String data);

	public BaseResponseDto update(String data);
	
	public MerchantsAccountQueryResDto list(String data);
	
	public MerchantsAccountCheckResDto has(String account);
	
	public MerchantsAccountDetailResDto get(Integer id);
}
