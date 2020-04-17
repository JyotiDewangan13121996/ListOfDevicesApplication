package com.app.tester;



import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app.controller.KafkaController;
import com.app.services.KafkaProducer;

@RunWith(SpringRunner.class)
public class KafkaProducerTester 
{
  
   @InjectMocks
   private KafkaController kafkaController ;
   
   
   @Mock
   private KafkaProducer producer;
   
   
   @Test
   public void testSendMessageToKafkaTopic()
   {
	   String message = "Some Record" ;
	   
	   Mockito.when(this.producer.sendMessage(message)).thenReturn("Published Successfully!");
	   
	   assertThat(kafkaController.sendMessageToKafkaTopic(message)).isEqualTo("Published Successfully!");
	  
   }
   
   
   
}
