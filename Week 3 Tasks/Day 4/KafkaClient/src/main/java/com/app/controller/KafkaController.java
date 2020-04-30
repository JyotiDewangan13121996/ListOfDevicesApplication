package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.KafkaConsumer;
import com.app.services.KafkaProducer;

@RestController
@RequestMapping(value="/kafka")
public class KafkaController 
{
 
	private  KafkaProducer producer;
	private KafkaConsumer consumer ;
	
	@Autowired
	private KafkaController(KafkaProducer producer , KafkaConsumer consumer)
	{
		this.producer = producer ;
		this.consumer = consumer ;
	}
	
	
	//To publish  topics
	
	@GetMapping(value = "/publish/{message}")
	public String sendMessageToKafkaTopic(@PathVariable String message )
	{
	   String notification= this.producer.sendMessage(message);	
	   return notification;
	}
	
	@GetMapping(value = "/consume/{message}")
	public String consumeMessageFromTopic(@PathVariable String message)
	{
		String notification = this.consumer.consumeMessageFromTheTopics(message);
		return notification;
	}
}
 
	
	
