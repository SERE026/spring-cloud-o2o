package com.merchant.service;

import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsAccountForm;
import com.merchant.model.MerchantsAccount;


public interface MerchantsAccountService {

	/**
	 * 根据id更新传入的字段（data字段不为null则更新）
	 * @param data
	 * @return
	 */
	ResultMessage updateByPrimaryKeySelective(MerchantsAccount data);

	/**
	 * 添加实体
	 * @param data
	 * @return
	 */
	ResultMessage add(MerchantsAccount data);
	 
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	ResultMessage findById(Integer id);
	
	/**
	 * 检查账户名是否存在
	 * @param account
	 * @return
	 */
	ResultMessage countByAccount(String account);
	
	/**
	 * 根据用户名密码查询
	 * @param account
	 * @return
	 */
	ResultMessage findByAccountAndPwd(String account,String password);
	
	/**
	 * 按条件分页查询
	 * @param form
	 * @return
	 */
	ResultMessage queryByPage(MerchantsAccountForm form);
}
