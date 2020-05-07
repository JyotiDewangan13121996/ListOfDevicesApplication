package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.AvroKafkaConsumer;
import com.app.services.AvroKafkaProducer;




@RestController
@RequestMapping(value="/kafka")
public class KafkaClientController 
{


	private  AvroKafkaProducer producer;
	private AvroKafkaConsumer consumer ;
	
	@Autowired
	private KafkaClientController(AvroKafkaProducer producer , AvroKafkaConsumer consumer)
	{
		this.producer = producer ;
		this.consumer = consumer ;
	}
	
	
	//To publish  topics
	
	@GetMapping(value = "/publish")
	public String sendMessageToKafkaTopic( )
	{
		
	   String notification= this.producer.sendMessage();	
	   return notification;
	}
	
	@GetMapping(value = "/consume")
	public String consumeMessageFromTopic()
	{
		
		String notification = this.consumer.consumeMessageFromTheTopics();
		return notification;
	}
	
}
