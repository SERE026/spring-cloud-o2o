package com.merchant.service;

import com.merchant.dto.ResultMessage;
import com.merchant.form.CommonFrom;
import com.merchant.form.MerchantsQueryBean;
import com.merchant.model.MerchantsSupplier;


public interface MerchantsSupplierService {

	/**
	 * 添加
	 * @param data
	 * @return
	 */
	ResultMessage add(MerchantsSupplier data);

	/**
	 * 根据id查询
	 * @param id
	 * @return
	 */
	MerchantsSupplier queryById(Integer id);

	/**
	 * 分页查询
	 * @param form
	 * @return
	 */
	ResultMessage queryByPage(CommonFrom<MerchantsQueryBean> form);

	/**
	 * 更新
	 * @param form
	 * @return
	 */
	int updateMerchantsSupplier(MerchantsSupplier form);

	/**
	 * 根据商户账户id分页查询 
	 * @param accountId
	 * @param offset
	 * @param pageSize
	 * @return
	 */
	ResultMessage queryByPageForAccount(Integer accountId, Integer offset, Integer pageSize);

	
}
