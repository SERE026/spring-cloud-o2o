package com.icloud.service.impl;

import java.util.UUID;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icloud.service.AmqpService;

@Service
public class AmqpServiceImpl implements  AmqpService,ConfirmCallback{
	public static final String routingKey_order = "order";
	public static final String exchange = "order";
	private RabbitTemplate rabbitTemplate;

	
	/**
	 * 
	 * @param exchange 交换机名称
	 * @param routingKey 路由关键字
	 * @param object 发送的消息内容
	 * @param correlationData 消息ID
	 */
	public void convertAndSend(String exchange,
		String routingKey, 
		final Object object, 
		CorrelationData correlationData){
		rabbitTemplate.convertAndSend(exchange,
				routingKey, 
				object, 
				correlationData);
	};
	
	/**
	 * 构造方法注入
	 */
	@Autowired
	public  AmqpServiceImpl(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
		rabbitTemplate.setConfirmCallback(this); //rabbitTemplate如果为单例的话，那回调就是最后设置的内容
	}

	public void send(String routingKey, String context) {
		rabbitTemplate.convertAndSend(routingKey, context);
	}

	 public void sendMsg(String content) {
	        CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
	        rabbitTemplate.convertAndSend(exchange, routingKey_order, content, correlationId);
	    }
	
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println(" 回调id:" + correlationData);
		if (ack) {
			System.out.println("消息成功消费");
		} else {
			System.out.println("消息消费失败:" + cause);
		}
	}

}
