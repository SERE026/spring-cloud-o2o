package com.icloud.config.amqp;
 
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import com.rabbitmq.client.Channel;
 


 /**
  * rabbitMQ配置
  * @author luoqw
  *2016年9月30日 下午3:16:18
  */

@Configuration  
public class AmqpConfig implements RabbitListenerConfigurer{  
  
    public static final String EXCHANGE   = "spring-boot-exchange";  
    public static final String ROUTINGKEY = "spring-boot-routingKey";  
  
   	@Value("${spring.rabbitmq.host}")
   	String host;
   	@Value("${spring.rabbitmq.port}")
   	String port;
   	@Value("${spring.rabbitmq.username}")
   	String username;
   	@Value("${spring.rabbitmq.password}")
   	String password;
   	
   	
   	/**
   	 * ConnectionFactory
   	 * 连接队列服务工厂类
   	 * @return
   	 */
   	@Bean  
    public ConnectionFactory connectionFactory() {  
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();  
        connectionFactory.setAddresses(host+":"+port);  
        connectionFactory.setUsername(username);  
        connectionFactory.setPassword(password);  
        connectionFactory.setVirtualHost("/");  
        connectionFactory.setPublisherConfirms(true); //设置确认模式，消费者受到消息后，给生产者回调消息
        return connectionFactory;  
    }  
   	
    
    /**
     * 如果需要在生产者需要消息发送后的回调，需要对rabbitTemplate设置ConfirmCallback对象，                                   
     * 由于不同的生产者需要对应不同的ConfirmCallback，如果rabbitTemplate设置为单例bean，则所有的rabbitTemplate 
     *   实际的ConfirmCallback为最后一次申明的ConfirmCallback。
     */    
	@Bean  
//    @Scope("prototype")
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(new Jackson2JsonMessageConverter());
        return template;
    }

	
	/**
	 * SimpleRabbitListenerContainerFactory
	 * 接收MQ数据时，转换格式 工厂（运用于消费者端）
	 * @param connectionFactory
	 * @return
	 */
  /*  @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Jackson2JsonMessageConverter());
        return factory;
    }*/

    
    //
    @Bean
    public MappingJackson2MessageConverter jackson2Converter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        return converter;
    }

    @Bean
    public DefaultMessageHandlerMethodFactory myHandlerMethodFactory() {
        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
        factory.setMessageConverter(jackson2Converter());
        return factory;
    }
    
    //

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		  registrar.setMessageHandlerMethodFactory(myHandlerMethodFactory());
		
	}
	 
   /* @Bean
    public Queue queue() {
        return new Queue("order"); //队列持久

    }
    
    *//**
     * 针对消费者配置
        FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
        HeadersExchange ：通过添加属性key-value匹配
        DirectExchange:按照routingkey分发到指定队列
        TopicExchange:多关键字匹配
     *//*
    @Bean
    public DirectExchange defaultExchange() {
    	return new DirectExchange(EXCHANGE);
    }
    
    
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(AmqpConfig.ROUTINGKEY);
    }
    
    
    @Bean
    public SimpleMessageListenerContainer messageContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory());
        container.setQueues(queue());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(1);
        container.setConcurrentConsumers(1);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {
 
			 @Override
	            public void onMessage(Message message, Channel channel) throws Exception {
	                byte[] body = message.getBody();
	                System.out.println("接收到消息 : " + new String(body));
	                channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); //确认消息成功消费
	            }
			
			
            
        });
        return container;
    }*/
 
	
	@Bean
	public MQReceiver MQReceiverExecute(){
		return new MQReceiver();
	}
 
}  