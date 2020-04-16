package com.app.service;


import java.util.Properties;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Configuration
@Service
public class KafkaProducer
{
     private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class) ;
     
     private static final String TOPIC = "KafkaProducer" ;
     
     @Autowired
      private KafkaTemplate<String, String> kafkaTemplate ;
     

   
     
     public String sendMessage(String message)
     {
    	 logger.info(String.format("** -> Producing Message -->  %s ", message));
    	 this.kafkaTemplate.send(TOPIC, message) ;
    	 return "Published Successfully !!" ;
     }
     
     
     public KafkaProducer()
     {
	    System.out.println("in kafka producer class");
	}
     
}
