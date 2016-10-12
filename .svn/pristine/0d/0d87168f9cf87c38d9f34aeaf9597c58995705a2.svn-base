package com.icloud.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icloud.dao.TestOrderMapper;
import com.icloud.dao.TestTransationalManageMapper;
import com.icloud.model.TestOrder;
import com.icloud.model.TestTransationalManage;
import com.icloud.service.TestOrderService;

@Service
public class TestOrderServiceImpl implements TestOrderService {

	@Autowired
	private TestOrderMapper orderMapper;
	@Autowired
	private TestTransationalManageMapper txMapper; 
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	
	
	@Override
	@Transactional
	public String createOrder() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		TestOrder order = new TestOrder();
		TestTransationalManage tx = new TestTransationalManage();
		String txId = UUID.randomUUID().toString();
		tx.setTransactionalid(txId);
		tx.setStatus(0);
		tx.setEventtype(sdf.format(new Date()) + "_创建订单的事务");
		txMapper.insert(tx);
//		int error = 5/0;
		Random r = new Random();
		int count = r.nextInt(5);
		order.setTransactionalid(txId);
		order.setCount(count);
		order.setProductname("购买商品A");
		order.setTotalpay(new BigDecimal(2).multiply(new BigDecimal(count)));
		orderMapper.insert(order); 
//		 int error = 5/0;

		return txId;
	}
	
	
	
	
	@Override
	@Transactional
	public String createOrder2() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		TestOrder order = new TestOrder();
		TestTransationalManage tx = new TestTransationalManage();
		String txId = UUID.randomUUID().toString();
		tx.setTransactionalid(txId);
		tx.setStatus(1);
		tx.setEventtype(sdf.format(new Date()) + "_创建订单的事务");
		
//		int error = 5/0;
		Random r = new Random();
		int count = r.nextInt(5);
		order.setTransactionalid(txId);
		order.setCount(count);
		order.setProductname("购买商品A");
		order.setTotalpay(new BigDecimal(2).multiply(new BigDecimal(count)));
		orderMapper.insert(order); 
//		 int error = 5/0;
		 
		rabbitTemplate.convertAndSend("order", order);  
		txMapper.insert(tx);
		System.out.println(5/0);
		return txId;
	}
	
	

	@Override
	public TestOrder findByTxId(String txId) {
		return orderMapper.findByTxId(txId);
		 
	}

}
