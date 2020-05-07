package com.app.services;


import java.util.Properties;


import java.util.stream.IntStream;

//import java.util.Map;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.stereotype.Service;

import avro.com.example.Person;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import io.confluent.kafka.serializers.KafkaAvroSerializerConfig;

//import avro.com.example.avro.User;

@Service
public class AvroKafkaProducer 
{
	
    
    private static final String TOPIC = "KafkaAvro" ;
  
   
    private static Producer<String, Person> createProducer() {
        Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9094");
		props.put(ProducerConfig.ACKS_CONFIG, "1");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, "client_id");
        // Configure the KafkaAvroSerializer.
       props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                KafkaAvroSerializer.class.getName());
        // Schema Registry location.
        props.put(KafkaAvroSerializerConfig.SCHEMA_REGISTRY_URL_CONFIG,
                "http://localhost:8081");
        
        return new KafkaProducer<>(props);
    }
  
    
    
    public String sendMessage()
    {
    	  Producer<String, Person> producer = createProducer();

    	  Person person = Person.newBuilder().setAge("Ananya").setAge("20").setWeight("50").setAddress("Pune").build();
       
    	  IntStream.range(1, 100).forEach(index->{
              producer.send(new ProducerRecord<>(TOPIC, person));
          });
          producer.flush();
          producer.close();
    	
    	
   	 
   	 return "Published Successfully !!" ;
    }
    
    
    public AvroKafkaProducer()
    {
	    System.out.println("in kafka producer class");
	}
    
	
}
