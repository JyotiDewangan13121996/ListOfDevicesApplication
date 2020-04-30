package com.app.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer
{

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "KafkaProducer" , groupId = "group_id")
	
	public String consumeMessageFromTheTopics(String message) 
	{
		logger.info(String.format("** ->  Consumed Message --> %s  ", message));
		return "Message Consumed Successfully!!" ;
		
	}
	
	
}
