package com.merchant.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchant.dao.MerchantsSupplierMapper;
import com.merchant.dto.ResultMessage;
import com.merchant.form.CommonFrom;
import com.merchant.form.MerchantsQueryBean;
import com.merchant.model.MerchantsSupplier;
import com.merchant.service.MerchantsSupplierService;

@Service
public class MerchantsSupplierServiceImpl implements MerchantsSupplierService {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MerchantsSupplierMapper merchantsSupplierMapper;

	@Override
	public ResultMessage add(MerchantsSupplier merchantsSupplier) {
		try {
			merchantsSupplierMapper.insertSelective(merchantsSupplier);
		} catch (Exception e) {
			logger.error("添加商户记录失败", e);
			return new ResultMessage(false,"插入数据库失败！");
		}
		
		return new ResultMessage(true,"插入数据库成功！");
		
	}

	@Override
	public MerchantsSupplier queryById(Integer id) {
		return merchantsSupplierMapper.selectByPrimaryKey(id);

	}

	@Override
	public List queryByPage(CommonFrom<MerchantsQueryBean> from) {
		return merchantsSupplierMapper.queryByPage(from);
	}

	@Override
	public int updateMerchantsSupplier(MerchantsSupplier form) {
		return merchantsSupplierMapper.updateByPrimaryKey(form);
	}
	
 
	
 
	

}
