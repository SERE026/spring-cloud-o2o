package com.icloud.config.amqp;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.icloud.dao.TestOrderMapper;
import com.icloud.dao.TestOrderSystemMapper;
import com.icloud.model.TestOrder;
import com.icloud.model.TestOrderSystem;


public class MQReceiver {

	protected Logger logger = Logger.getLogger(MQReceiver.class.getName());

	@Autowired
	private TestOrderSystemMapper orderSysMapper;
	
	
	@RabbitListener(queues = "order", containerFactory = "rabbitListenerContainerFactory")
	public void processMessageOrder(@Payload TestOrder order) {
		
		System.out.println("Order接收的内容： "+JSONObject.toJSON(order));
		TestOrderSystem orderSystem = JSONObject.parseObject(JSONObject.toJSONString(order), TestOrderSystem.class);
		TestOrderSystem entity = orderSysMapper.findByTxId(orderSystem.getTransactionalid());
		if (entity == null ) {
			orderSysMapper.insertSelective(orderSystem);
		}
		 
	}
	
	@RabbitListener(queues = "orderRockback", containerFactory = "rabbitListenerContainerFactory")
	public void processMessageOrder(String txId) {
		
		TestOrderSystem entity = orderSysMapper.findByTxId(txId);
		if (entity != null ) {
			orderSysMapper.deleteByPrimaryKey(entity.getId());
		}
		
	}
}
