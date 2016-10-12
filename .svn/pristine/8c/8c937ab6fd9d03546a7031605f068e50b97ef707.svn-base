package com.didispace.rabbit;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender2 {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send() {
		String context = "大家吃饭没有呢？";
		System.out.println("Sender2 : " + context);
		this.rabbitTemplate.convertAndSend("hello2", context);
	}

}