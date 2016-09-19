package com.icloud.service;

import com.icloud.dto.BaseDto;
import com.icloud.dto.MpQueryDto;
import com.icloud.dto.SupplierDetailDto;
import com.icloud.dto.SupplierQueryDto;

public interface MerchantsSupplierService {


	
	/**
	 * 更新
	 * @param jsonParams
	 * @return
	 */
	public BaseDto update(String jsonParams);
	
	
	/**
	 * 添加
	 * @param jsonParams
	 * @param accountId
	 * @return
	 */
	public BaseDto add(String jsonParams,Integer accountId);
	
	
	/**
	 * 查询
	 * @param merchantsId
	 * @return
	 */
	public SupplierDetailDto get(Integer merchantsId);
	
	
	/**
	 * 查询列表
	 * @param jsonParams
	 * @param accountId
	 * @return
	 */
	public SupplierQueryDto list(String jsonParams,Integer accountId);
	
	/**
	 * 根据商户号查询公众号列表
	 * @param merchantsId
	 * @return
	 */
	public MpQueryDto findMpListByMerchant(Integer merchantsId);
	
	/**
	 * 商户审核
	 * @param jsonParams
	 * @return
	 */
	public BaseDto audit(String jsonParams);
	
	/**
	 * 修改商户关联公众号
	 * @param jsonParams
	 * @return
	 */
	public BaseDto caseMerchantsMp(String jsonParams);
	
	
	


}
