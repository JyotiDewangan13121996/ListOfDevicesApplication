package com.app.services;


import java.util.Collections;


import java.util.Properties;
import java.util.stream.IntStream;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;



import avro.com.example.Person;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;


@Service
public class AvroKafkaConsumer
{

	 private static final String TOPIC = "KafkaAvro" ;
	 
	 
	 private static Consumer<String, Person> createConsumer() {
	        Properties props = new Properties();
	        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9094");
	        props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
	        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
	        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1000);
	        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 30000);
	        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
	        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	                KafkaAvroDeserializer.class.getName());  //<----------------------
	        //Use Specific Record or else you get Avro GenericRecord.
	        props.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, "true");
	        //Schema registry location.
	        props.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG,
	                "http://localhost:8081"); //<----- Run Schema Registry on 8081
	        return new KafkaConsumer<>(props);
	    }

	 
	 
	
	public String consumeMessageFromTheTopics( ) 
	{
		 final Consumer<String, Person> consumer = createConsumer();
	        consumer.subscribe(Collections.singletonList(TOPIC));
	        IntStream.range(1, 100).forEach(index -> {
	            final ConsumerRecords<String,Person> records =
	                    consumer.poll(100);
	            if (records.count() == 0) {
	                System.out.println("None found");
	            } else records.forEach(record -> {
	            	Person personRecord = record.value();
	                System.out.printf("%s %d %d %s \n", record.topic(),
	                        record.partition(), record.offset(), personRecord);
	            });
	        });
		
		return "Message Consumed Successfully!!" ;
		
	}
}
