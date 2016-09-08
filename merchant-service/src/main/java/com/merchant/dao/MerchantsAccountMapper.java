package com.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.merchant.form.MerchantsAccountForm;
import com.merchant.model.MerchantsAccount;

public interface MerchantsAccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantsAccount record);

    int insertSelective(MerchantsAccount record);

    MerchantsAccount selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantsAccount record);

    int updateByPrimaryKey(MerchantsAccount record);

	MerchantsAccount findByAccountAndPwd(
			@Param("account")String account, 
			@Param("password")String password);

	int countByAccount(String account);

	List<MerchantsAccount> queryByPage(MerchantsAccountForm form);
}