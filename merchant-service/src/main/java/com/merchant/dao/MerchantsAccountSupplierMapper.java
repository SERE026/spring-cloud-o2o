package com.merchant.dao;

import java.util.List;

import com.merchant.form.MerchantsAccountQueryBean;
import com.merchant.model.MerchantsAccountSupplier;

public interface MerchantsAccountSupplierMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MerchantsAccountSupplier record);

    int insertSelective(MerchantsAccountSupplier record);

    MerchantsAccountSupplier selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MerchantsAccountSupplier record);

    int updateByPrimaryKey(MerchantsAccountSupplier record);

	List<MerchantsAccountSupplier> queryByPage(MerchantsAccountQueryBean form);

	int deleteByBean(MerchantsAccountQueryBean form);
}