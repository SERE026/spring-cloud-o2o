package com.merchant.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.merchant.dao.MerchantsMpMapper;
import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsMpForm;
import com.merchant.model.MerchantsMp;
import com.merchant.service.MerchantsMpService;

@Service
public class MerchantsMpServiceImpl implements MerchantsMpService {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MerchantsMpMapper merchantsMpMapper;

	@Override
	public ResultMessage add(MerchantsMp data) { 
		try {
			merchantsMpMapper.insertSelective(data);
		} catch (Exception e) {
			logger.error("添加公众号记录失败", e);
			return new ResultMessage(false,"插入数据库失败！");
		}
		
		return new ResultMessage(true,"插入数据库成功！");
		  
	}

	@Override
	public ResultMessage queryByPage(MerchantsMpForm form) {
		List<MerchantsMp> list = null;
		try {
			list = merchantsMpMapper.queryByPage(form);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"查询公众号失败！");
		}
		return new ResultMessage(false,"查询成功！",list);
	}

	@Override
	public ResultMessage findById(Integer id) {
		MerchantsMp mp = null;
		try {
			mp = merchantsMpMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"查询公众号失败！");
		}
		return new ResultMessage(false,"查询成功！",mp);
	}
	
	
	@Override
	public ResultMessage updateByPrimaryKeySelective(MerchantsMp mp) {
		int count = 0;
		try {
			count = merchantsMpMapper.updateByPrimaryKeySelective(mp);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"更新失败！");
		}
		if (count == 0) {
			return new ResultMessage(false,"更新失败，记录不存在！");
		}
		
		return new ResultMessage(false,"更新成功！",mp);
	}

	@Override
	public ResultMessage queryByPageForMerchants(Integer merchantsId, Integer offset, Integer pageSize) {
		List<MerchantsMp> list = null;
		try {
			list = merchantsMpMapper.queryByPageForMerchants(merchantsId,offset,pageSize);
		} catch (Exception e) {
			logger.error("查询公众号失败！", e);
			return new ResultMessage(false,"查询公众号失败！");
		}
		return new ResultMessage(false,"查询成功！",list);
	}
	
 
	
 
	

}
