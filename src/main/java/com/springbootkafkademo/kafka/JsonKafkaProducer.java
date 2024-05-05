package com.springbootkafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.springbootkafkademo.model.Employee;

@Service
public class JsonKafkaProducer {

	              private static final Logger LOGGER=LoggerFactory.getLogger(JsonKafkaProducer.class);
	              
	              private KafkaTemplate<String, Employee> kafkatemplate;

				public JsonKafkaProducer(KafkaTemplate<String, Employee> kafkatemplate) {
					super();
					this.kafkatemplate = kafkatemplate;
				}
	              
	            public void sendMessage(Employee emp) {
	            	
	            	LOGGER.info(String.format("Message Sent->%s",emp.toString()));
	            	     Message<Employee> message=MessageBuilder
	            	    		 . withPayload(emp).setHeader(KafkaHeaders.TOPIC, "javaguides_Json")
	            	    		 .build();
	            	     
	            	     kafkatemplate.send(message);
	            }
}
