package com.springbootkafkademo.controller;

import java.io.Serializable;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springbootkafkademo.kafka.KafkaProducer;

@RestController
public class MessageConstroller implements Serializable {

	     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private KafkaProducer kafkaproducer;

		public MessageConstroller(KafkaProducer kafkaproducer) {
			super();
			this.kafkaproducer = kafkaproducer;
		}
		
		//http:localhost:5656/api/v1/kafka/publish?message=helloworld
	     @GetMapping("/publish")
	     public ResponseEntity<String> publish(@RequestParam("message") String message){
	    	 
	    	 kafkaproducer.sendMessage(message);
	    	 return ResponseEntity.ok("message send to topic");
	     }
}
