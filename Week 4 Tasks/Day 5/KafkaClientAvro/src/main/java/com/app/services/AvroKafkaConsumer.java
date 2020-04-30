package com.app.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import avro.com.example.avro.User;

@Service
public class AvroKafkaConsumer
{

private final Logger logger = LoggerFactory.getLogger(AvroKafkaConsumer.class);
	
	@KafkaListener(topics = "KafkaProducer" , groupId = "group_id")
	
	public String consumeMessageFromTheTopics(User user) 
	{
		logger.info(String.format("** ->  Consumed Message --> %s  ", user.toString()));
		return "Message Consumed Successfully!!" ;
		
	}
}
