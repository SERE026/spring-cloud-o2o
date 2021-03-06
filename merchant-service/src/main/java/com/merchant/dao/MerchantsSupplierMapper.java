package com.merchant.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.merchant.form.CommonFrom;
import com.merchant.form.MerchantsQueryBean;
import com.merchant.model.MerchantsSupplier;

public interface MerchantsSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantsSupplier record);

    int insertSelective(MerchantsSupplier record);

    MerchantsSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantsSupplier record);

    int updateByPrimaryKey(MerchantsSupplier record);

	List<MerchantsSupplier> queryByPage(CommonFrom<MerchantsQueryBean> from);

	List<MerchantsSupplier> queryByPageForAccount(
			@Param("accountId")Integer accountId, 
			@Param("offset")Integer offset, 
			@Param("pageSize")Integer pageSize);
	
}