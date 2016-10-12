package com.didispace.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RabbitListener(queues = "hello2")
public class Receiver2 {
	
	@Autowired
	private Sender3 sender3;


	@RabbitHandler
    public void test(String hello2) {
        System.out.println("Receiver2222222 : " + hello2);    
    
     //   sender3.send();
	}

}
