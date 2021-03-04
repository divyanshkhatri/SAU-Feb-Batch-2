package com.example.kafka.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.kafka.model.Order;
import com.example.kafka.service.ProducerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin("*")
@Slf4j
public class Controller {
	
  List<Order> orders = new ArrayList<>();

  @Autowired
  private ProducerService producerService;

	@PostMapping(value = "/createOrder")
	public ResponseEntity<Order> createOrder(@RequestBody Order order) {
		
		orders.add(order);
		log.debug("Inside create order controller");
        System.out.println(order.toString());
  		producerService.createOrder(order);	
  		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
		
    }
	
	@GetMapping(value = "/orderShipped/{id}")
	public ResponseEntity<Order> produceNewShippingOrder(@PathVariable("id") int orderId) {
		if(orders.get(orderId) != null) {
			producerService.shipOrder(orders.get(orderId));	
			log.debug("Inside order shipped controller");
			return new ResponseEntity<Order>(orders.get(orderId), HttpStatus.ACCEPTED);
		}        
        else{
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
    }
	

}
