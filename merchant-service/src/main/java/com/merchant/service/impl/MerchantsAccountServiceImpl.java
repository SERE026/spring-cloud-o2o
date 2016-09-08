package com.merchant.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchant.dao.MerchantsAccountMapper;
import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsAccountForm;
import com.merchant.model.MerchantsAccount;
import com.merchant.service.MerchantsAccountService;

@Service
public class MerchantsAccountServiceImpl implements MerchantsAccountService {
	private final Logger logger = Logger.getLogger(getClass());
	@Autowired
	private MerchantsAccountMapper mtsAccountMpMapper;

	@Override
	public ResultMessage updateByPrimaryKeySelective(MerchantsAccount data) {
		try {
			mtsAccountMpMapper.insertSelective(data);
		} catch (Exception e) {
			logger.error("添加公众号记录失败", e);
			return new ResultMessage(false,"插入数据库失败！");
		}
		
		return new ResultMessage(true,"插入数据库成功！");
		  
	}

	@Override
	public ResultMessage add(MerchantsAccount data) {
		int count = 0;
		try {
			count = mtsAccountMpMapper.updateByPrimaryKeySelective(data);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"更新失败！");
		}
		if (count == 0) {
			return new ResultMessage(false,"更新失败，记录不存在！");
		}
		
		return new ResultMessage(false,"更新成功！");
	}

 

	@Override
	public ResultMessage findById(Integer id) {
		MerchantsAccount entity = null; 
		try {
			entity = mtsAccountMpMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("查询失败！", e);
			return new ResultMessage(false,"查询失败！");
		}
		return new ResultMessage(false,"查询成功！",entity);
	}

	@Override
	public ResultMessage countByAccount(String account) {
		int count = 0;
		try {
			count = mtsAccountMpMapper.countByAccount(account);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"更新失败！");
		}
		
		return new ResultMessage(false,"更新成功！",count);
	}

	@Override
	public ResultMessage findByAccountAndPwd(String account, String password) {
		MerchantsAccount entity = null; 
		try {
			entity = mtsAccountMpMapper.findByAccountAndPwd(account,password);
		} catch (Exception e) {
			logger.error("查询失败！", e);
			return new ResultMessage(false,"查询失败！");
		}
		return new ResultMessage(false,"查询成功！",entity);
	}
	
 
	@Override
	public ResultMessage queryByPage(MerchantsAccountForm form) {
		List<MerchantsAccount> list = null;
		try {
			list = mtsAccountMpMapper.queryByPage(form);
		} catch (Exception e) {
			logger.error("查询失败！", e);
			return new ResultMessage(false,"查询失败！");
		}
		return new ResultMessage(false,"查询成功！",list);
	}
 
	

}
