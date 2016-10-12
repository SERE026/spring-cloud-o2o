package com.didispace.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@RabbitListener(queues = "hello")

public class Receiver {

	@Autowired
	private Sender2 sender2;
	
	
	@RabbitHandler
    public void test(String hello) {
        System.out.println("Receiver : " + hello);
    
        sender2.send();

    
    }

}
