package com.merchant.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.merchant.dao.MerchantsAccountSupplierMapper;
import com.merchant.dto.ResultMessage;
import com.merchant.form.MerchantsAccountQueryBean;
import com.merchant.model.MerchantsAccountSupplier;
import com.merchant.service.MerchantsAccountSupplierService;

@Service
public class MerchantsAccountSupplierServiceImpl implements MerchantsAccountSupplierService {
	
	private final Logger logger = Logger.getLogger(getClass());
	
	@Autowired
	private MerchantsAccountSupplierMapper merchantsAccountSupplierMapper;

	 
	@Override
	public ResultMessage add(MerchantsAccountSupplier merchantsSupplier) {
		try {
			merchantsAccountSupplierMapper.insertSelective(merchantsSupplier);
		} catch (Exception e) {
			logger.error("添加商户账户中间表记录失败", e);
			return new ResultMessage(false,"插入数据库失败！");
		}
		
		return new ResultMessage(true,"插入数据库成功！");
		
	}

	@Override
	public int updateMerchantsAccountSupplier(MerchantsAccountSupplier form) {
		return merchantsAccountSupplierMapper.updateByPrimaryKey(form);
	}

	@Override
	public List<MerchantsAccountSupplier> queryByPage(
			MerchantsAccountQueryBean form) {
		return merchantsAccountSupplierMapper.queryByPage(form);
		
	}

	@Override
	public int deleteByBean(MerchantsAccountQueryBean form) {
		
		return merchantsAccountSupplierMapper.deleteByBean(form);
	}
	
 
	

}
