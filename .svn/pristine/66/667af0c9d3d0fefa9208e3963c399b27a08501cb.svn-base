package com.merchant.service;

import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsMpForm;
import com.merchant.model.MerchantsMp;


public interface MerchantsMpService {

	/**
	 * 添加
	 * @param data
	 * @return
	 */
	ResultMessage add(MerchantsMp data);

	/**
	 * 根据条件分页查询
	 * @param form
	 * @return
	 */
	ResultMessage queryByPage(MerchantsMpForm form);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	ResultMessage findById(Integer id);
	 
	/**
	 * 根据id更新字段不为null的值
	 * @param mp
	 * @return
	 */
	public ResultMessage updateByPrimaryKeySelective(MerchantsMp mp);

	/**
	 * 根据商户id分页查询
	 * @param merchantsId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	ResultMessage queryByPageForMerchants(Integer merchantsId, Integer offset, Integer pageSize);
	
}
