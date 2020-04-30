package com.app.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;

import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.app.services.AvroKafkaProducer;
import com.app.services.AvroSerializer;

@EnableKafka
@Configuration
public class KafkaProducerConfig 
{
	//@Autowired
	//private KafkaProperties kafkaproperties;
   
	@Bean
	public Map<String, Object> producerConfigs()
	{
		//Map<String, Object> props = new HashMap<String, Object>(kafkaproperties.buildProducerProperties());
		
		Map<String, Object> props = new HashMap<String, Object>();
		//props.put(ProducerConfig.ACKS_CONFIG, SearchStrategy.ALL);
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, AvroSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "client_id");
		
		
		// Configure The KafkaAvroSerializer.
		
		
		
		return props;
	}
	
	@Bean
	public ProducerFactory<String, Object> producerFactory()
	{
		return new DefaultKafkaProducerFactory<>(producerConfigs());
	}
	
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate()
	{
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	public AvroKafkaProducer producer()
	{
		return new AvroKafkaProducer() ;
	}
	
	/*
	@Bean
	public NewTopic adviceTopic()
	{
		return new NewTopic("KafkaProducer", 1 ,(short) 1);
	}
	
	*/
	
}