package com.springbootkafkademo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootkafkademo.kafka.JsonKafkaProducer;
import com.springbootkafkademo.model.Employee;

@RestController
public class JsonControllerMessage {

	
	        private JsonKafkaProducer jsonkafkaproducer;

			public JsonControllerMessage(JsonKafkaProducer jsonkafkaproducer) {
				super();
				this.jsonkafkaproducer = jsonkafkaproducer;
			}
	        
			@PostMapping("/message")
	        public ResponseEntity<String> publish(@RequestBody Employee emp){
	        	
	        	jsonkafkaproducer.sendMessage(emp);
	        	
	        	return  ResponseEntity.ok("Json messgae sent to kafka topic");
	        }
}
