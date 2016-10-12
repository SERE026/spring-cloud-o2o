package com.icloud;


import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.icloud.model.TestOrder;
import com.icloud.model.TestTransationalManage;
import com.icloud.service.AmqpService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = RibbonApplication.class)
public class HelloApplicationTests {
	@Autowired
	private RabbitTemplate rabbitTemplate;
	 
	private RestTemplate restTemplate = new TestRestTemplate();
	
	@Test
	public void testCreateOrder(){
		String result = restTemplate.getForObject("http://127.0.0.1:2002/order/cretate/", String.class);
		System.out.println("result = "+ result);
	}
	
	/*@Test
	public void hello() throws Exception {
		TestOrder order = new TestOrder();
		String txId = UUID.randomUUID().toString();
		Random r = new Random();
		int count = r.nextInt(5);
		order.setTransactionalid(txId);
		order.setCount(count);
		order.setProductname("购买商品A");
		order.setTotalpay(new BigDecimal(2).multiply(new BigDecimal(count)));
		
		rabbitTemplate.convertAndSend("order", order);
		
//		sender.send("hello", "test hello context 111 队列消息测试");
//		sender.send("order", "test order context 222 队列消息测试");
	}*/

}
