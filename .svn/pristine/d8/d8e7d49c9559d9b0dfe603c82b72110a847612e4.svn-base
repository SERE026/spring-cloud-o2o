package com.icloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icloud.dao.TestTransationalManageMapper;
import com.icloud.model.TestTransationalManage;
import com.icloud.service.TestTransationalManageService;

@Service
public class TestTransationalManageServiceImpl implements TestTransationalManageService {
	@Autowired
	private TestTransationalManageMapper txMapper;
	@Override
	public  List<TestTransationalManage> findUnSendMq(Integer status) {
		return txMapper.selectByStatus(status);
	}
	@Override
	public TestTransationalManage findByTxId(String txId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void alreadySend(String txId) { 
		TestTransationalManage txManage = txMapper.selectByTxId(txId);
		txManage.setStatus(1);//标识为已发送成功
		txMapper.updateByPrimaryKeySelective(txManage);
	}

}
