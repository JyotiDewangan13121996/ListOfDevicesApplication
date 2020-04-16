package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.KafkaProducer;

@RestController
@RequestMapping(value="/kafka")
public class KafkaController 
{
 
	private  KafkaProducer producer;
	
	@Autowired
	private KafkaController(KafkaProducer producer)
	{
		this.producer = producer ;
	}
	
	
	//To publish  topics
	
	@GetMapping(value = "/publish/{message}")
	public String sendMessageToKafkaTopic(@PathVariable String message )
	{
	   String notification= this.producer.sendMessage(message);	
	   return notification;
	}
}
 
	
	
