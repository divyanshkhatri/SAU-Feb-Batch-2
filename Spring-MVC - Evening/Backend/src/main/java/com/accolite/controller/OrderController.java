package com.accolite.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.accolite.model.Order;
import com.accolite.service.OrderService;

@RestController 
public class OrderController {

	
	@CrossOrigin
	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = "application/json") 
	public ResponseEntity<Object> createOrder(@RequestBody Order order) throws Exception {
		System.out.println("Order: "+ order);
		Order response = OrderService.createOrder(order);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/add/items", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json") 
	public ResponseEntity<Object> addItems(@RequestBody Order order) throws Exception {
		
		Order response = OrderService.addItems(order);
		System.out.println("Reached");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/update/items", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json") 
	public ResponseEntity<Object> updateItems(@RequestBody Order order) throws Exception {
		
		Order response = OrderService.updateItem(order);
		System.out.println("Reached");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = "application/json") 
	public ResponseEntity<Object> allDetails(@PathVariable Integer orderId) throws Exception {
		
		Order response = OrderService.getAllDetails(orderId);
		System.out.println("Reached");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/delete/item/{orderId}/{itemId}", method = RequestMethod.DELETE, produces = "application/json") 
	public ResponseEntity<Object> deleteItem(@PathVariable Integer orderId, @PathVariable Integer itemId) throws Exception {
		
		System.out.println(orderId);
		System.out.println(itemId);
		Order response = OrderService.deleteItem(orderId, itemId);
		System.out.println("Reached");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	
	
	
}
