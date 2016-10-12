package com.icloud.service;

import java.util.List;

import com.icloud.model.TestTransationalManage;

public interface AmqpService {

	

	
	void send(String routingKey,String context);
}
