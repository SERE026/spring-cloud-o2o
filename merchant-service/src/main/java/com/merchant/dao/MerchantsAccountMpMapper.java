package com.merchant.dao;

import org.apache.ibatis.annotations.Param;

import com.merchant.model.MerchantsAccountMp;

public interface MerchantsAccountMpMapper {

	/**
	 * 添加
	 * @param record
	 * @return
	 */
    int insert(MerchantsAccountMp record);


    /**
     * 删除
     * @param accountId
     * @param mpId
     * @return
     */
	int deleteByAccountIdAndMpId(
			@Param("accountId")Integer accountId, 
			@Param("mpId")Integer mpId);
}