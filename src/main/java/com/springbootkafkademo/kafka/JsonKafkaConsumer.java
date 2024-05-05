package com.springbootkafkademo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springbootkafkademo.model.Employee;

@Service
public class JsonKafkaConsumer {

	  
	      private static  Logger LOGGER =LoggerFactory.getLogger(JsonKafkaConsumer.class);
	      
	      @KafkaListener(topics="javaguides_Json",groupId="myGroup")
	      public void consume(Employee emp) {
	    	  LOGGER.info(String.format("Recieved Message->%s", emp.toString()));
	      }
}
