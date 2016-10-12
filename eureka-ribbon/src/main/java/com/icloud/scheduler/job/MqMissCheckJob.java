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

import com.icloud.model.TestTransationalManage;
import com.icloud.service.TestOrderService;
import com.icloud.service.TestTransationalManageService;

@DisallowConcurrentExecution
public class MqMissCheckJob implements Job { 
    private final Logger logger = Logger.getLogger(getClass());
    @Autowired
	public TestTransationalManageService txManageService;
    @Autowired
	private RabbitTemplate rabbitTemplate; 

    @Override
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
		List<TestTransationalManage> list = txManageService.findUnSendMq(0); //获取为发送MQ事务
		if (list != null && list.size() > 0) {
			for (TestTransationalManage mqTx : list) { 
				rabbitTemplate.convertAndSend(mqTx.getQueue(), mqTx.getContent());//发送消息
				txManageService.alreadySend(mqTx.getTransactionalid());//提交消息
				logger.info("-- 维护程序，将异常导致不能成功发送到MQ的重新执行 --  成功 " + new Date());
			}
		}
	}
    
}