package com.icloud.dao;

import java.util.List;

import com.icloud.model.TestTransationalManage;

public interface TestTransationalManageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTransationalManage record);

    int insertSelective(TestTransationalManage record);

    TestTransationalManage selectByPrimaryKey(Integer id);
    
    List<TestTransationalManage> selectByStatus(Integer status);

    int updateByPrimaryKeySelective(TestTransationalManage record);

    int updateByPrimaryKey(TestTransationalManage record);

	TestTransationalManage selectByTxId(String txId);
}