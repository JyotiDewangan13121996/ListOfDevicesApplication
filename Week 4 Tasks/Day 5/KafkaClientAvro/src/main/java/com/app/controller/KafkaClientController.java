package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.services.AvroKafkaConsumer;
import com.app.services.AvroKafkaProducer;

import avro.com.example.avro.User;


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
	public String sendMessageToKafkaTopic(@RequestBody User user )
	{
	   String notification= this.producer.sendMessage(user);	
	   return notification;
	}
	
	@GetMapping(value = "/consume")
	public String consumeMessageFromTopic(@RequestBody User user)
	{
		String notification = this.consumer.consumeMessageFromTheTopics(user);
		return notification;
	}
	
}
