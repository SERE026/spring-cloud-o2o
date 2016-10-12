package com.icloud.dao;

import com.icloud.model.TestTransationalManageSystem;

public interface TestTransationalManageSystemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestTransationalManageSystem record);

    int insertSelective(TestTransationalManageSystem record);

    TestTransationalManageSystem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TestTransationalManageSystem record);

    int updateByPrimaryKey(TestTransationalManageSystem record);
}