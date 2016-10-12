package com.icloud.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icloud.dto.BaseDto;
import com.icloud.model.TestTransationalManage;
import com.icloud.service.TestOrderService;
import com.icloud.service.TestTransationalManageService;

@RestController
public class TestOrderController {
	@Autowired
	public TestOrderService testOrderService;
	@Autowired
	public TestTransationalManageService txManageService;
    @Autowired
	private RabbitTemplate rabbitTemplate;

	@RequestMapping(value = "/order/cretate")
	public Object cretatOrder() {
		String txId = testOrderService.createOrder(); //执行本地业务数据操作,并包含创建消息事务
		try {
			TestTransationalManage mqTx = txManageService.findByTxId(txId);//获取要发送的消息事务
			rabbitTemplate.convertAndSend(mqTx.getQueue(), mqTx.getContent());  //发送消息
			txManageService.alreadySend(txId);//更新为已发消息
		} catch (Exception e) {
			e.printStackTrace();
		}

		return new BaseDto("success", "10000", "请求成功");
	}
 
}
