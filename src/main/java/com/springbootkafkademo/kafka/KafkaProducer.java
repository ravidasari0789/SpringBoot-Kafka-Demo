package com.springbootkafkademo.kafka;

import org.apache.kafka.clients.producer.Producer;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class KafkaProducer {

	    private static final Logger LOGGER=(Logger) LoggerFactory.getLogger(KafkaProducer.class);
	     private KafkaTemplate<String, String> kafkatemplate;

		public KafkaProducer(KafkaTemplate<String, String> kafkatemplate) {
			super();
			this.kafkatemplate = kafkatemplate;
		}
	     
	     public void sendMessage(String message) {
	    	 LOGGER.info("Message Sent %s",message);
	    	 kafkatemplate.send("javaguides",message);
	     }
}
