package com.icloud.dao;

import com.icloud.model.TestOrderSystem;

public interface TestOrderSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestOrderSystem record);

    int insertSelective(TestOrderSystem record);

    TestOrderSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestOrderSystem record);

    int updateByPrimaryKey(TestOrderSystem record);

	TestOrderSystem findByTxId(String transactionalid);
}