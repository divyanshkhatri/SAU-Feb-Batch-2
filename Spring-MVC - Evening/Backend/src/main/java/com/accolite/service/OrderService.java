package com.accolite.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accolite.model.Item;
import com.accolite.model.Order;

@Service
public class OrderService {
	
	static List<Order> orders = new ArrayList<>();
	
	public static Order createOrder(Order order) throws Exception {
		orders.add(order);
		return orders.get(orders.size()-1);
	}
	
	public static Order addItems(Order order1) throws Exception {
		
		for(Order o: orders) {
			
			if(o.getOrderId() == order1.getOrderId()) {
				
				Item[] item = o.getItem();
				Item[] both = Arrays.copyOf(item, item.length + order1.getItem().length);
				System.arraycopy(order1.getItem(), 0, both, item.length, order1.getItem().length);
				o.setItem(both);
				return o;
			}
		}
		
		return null;
		
	}
	
	public static Order updateItem(Order order1) throws Exception {
		
		for(Order o: orders) {
			
			if(o.getOrderId() == order1.getOrderId()) {
				
				Item[] item = o.getItem();
				int newItemId = order1.getItem()[0].getItemId(); 
				String newItemName = order1.getItem()[0].getItemName(); 
				int newItemQuantity = order1.getItem()[0].getItemQuantity(); 
				
				for(Item i : item) {
					if(i.getItemId() == newItemId) {
						i.setItemName(newItemName);
						i.setItemQuantity(newItemQuantity);
						return o;
					}
				}
			}
		}
		
		return null;
		
	}
	
	public static Order getAllDetails(Integer orderId) throws Exception {
		
		for(Order o: orders) {
			
			if(o.getOrderId() == orderId) {
			
				return o;
				
			}
		}
		
		return null;
		
	}
	
	public static Order deleteItem(Integer orderId, Integer itemId) throws Exception {
		
		for(Order o: orders) {
			
			if(o.getOrderId() == orderId) {
				Item[] item = o.getItem();
				int j = 0;
				for(Item i : item) {
					
					if(i.getItemId() == itemId) {
						break;
					}
					j++;
				}
				
				Item[] newItem = new Item[item.length - 1]; 
				 
		        for (int i = 0, k = 0; i < item.length; i++) { 

		            if (i == j) { 
		                continue; 
		            } 
		  
		            newItem[k++] = item[i]; 
		        } 
		        o.setItem(newItem);
		        return o;
			}
		}
		
		return null;
		
	}
	
}