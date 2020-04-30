package com.app.services;


import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import avro.com.example.avro.User;

@Service
public class AvroKafkaProducer 
{
	private static final Logger logger = LoggerFactory.getLogger(AvroKafkaProducer.class) ;
    
    private static final String TOPIC = "KafkaProducer" ;
    
    @Autowired
     private KafkaTemplate<String, Object> kafkaTemplate ;
    
   
  
    
    public String sendMessage(User user)
    {
   	 logger.info(String.format("** -> Producing Message -->  %s ", user.toString()));
   	 this.kafkaTemplate.send(TOPIC, user) ;
   	 return "Published Successfully !!" ;
    }
    
    
    public AvroKafkaProducer()
    {
	    System.out.println("in kafka producer class");
	}
    
	
}
