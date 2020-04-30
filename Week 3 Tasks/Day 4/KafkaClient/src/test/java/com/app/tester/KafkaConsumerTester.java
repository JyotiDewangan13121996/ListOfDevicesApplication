package com.app.tester;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.controller.KafkaController;
import com.app.services.KafkaConsumer;



@RunWith(SpringRunner.class)
public class KafkaConsumerTester 
{
	
	@InjectMocks
	private KafkaController kafkaController;
	
	@Mock
	private KafkaConsumer consumer ;
	
	@Test
	public void testConsumer() throws Exception
	{
		String message = "Some Record " ;
		
		Mockito.when(this.consumer.consumeMessageFromTheTopics(message)).thenReturn("Message Consumed Successfully!!") ;
		assertThat(kafkaController.consumeMessageFromTopic(message)).isEqualTo("Message Consumed Successfully!!");
	
		
	}
	
	
	
	
}
