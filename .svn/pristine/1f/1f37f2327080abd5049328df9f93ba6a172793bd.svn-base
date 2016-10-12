package com.icloud.scheduler.job;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.icloud.model.TestOrder;
import com.icloud.model.TestTransationalManage;
import com.icloud.service.AmqpService;
import com.icloud.service.TestOrderService;
import com.icloud.service.TestTransationalManageService;

@DisallowConcurrentExecution
public class OrderMqReceiverSureJob implements Job { 
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
	public TestTransationalManageService txManageService;
    @Autowired
	private RabbitTemplate rabbitTemplate;
    @Autowired
	public TestOrderService testOrderService;
    @Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		List<TestTransationalManage> list = txManageService.findUnSendMq(0);
		String routingKey = "order";
		if (list != null && list.size() > 0) {
			for (TestTransationalManage tx : list) {
				// 存入队列，发送出去
				TestOrder order = testOrderService.findByTxId(tx.getTransactionalid()); 
				rabbitTemplate.convertAndSend(routingKey, order);
				txManageService.alreadySend(tx.getTransactionalid());
				logger.info("-- 维护程序，将异常导致不能成功发送到MQ的重新执行 --  成功 " + new Date());
			}
		}

	}
    
    
    
}