package com.producerconsumer;

import java.util.ArrayList;
import java.util.List;

class Producer extends Thread {
	
	int i = 0;
	int queueSize;
	List<Integer> queue = new ArrayList<>();
	
	public Producer(List<Integer> queue, int queueSize) {
	
		this.queue = queue;
		this.queueSize = queueSize;
			
	}

	public void run () {
		
		System.out.println(Thread.currentThread().getName());
		for(int j = 0; j<10; j++) {
			
			while(queue.size() == queueSize) {
				
				synchronized (queue) {
					System.out.println("Queue is full");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
				}
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (queue) {
	            queue.add(j);
	            queue.notify();
	        }
			System.out.println("Producer Produced another one: " + j+ ". Size of queue is: " + queue.size());
		}
		
	}
}

class Consumer extends Thread {
	
	int queueSize;
	List<Integer> queue = new ArrayList<>();
	int i = 0;
	
	public Consumer(List<Integer> queue, int queueSize) {
		
		this.queue = queue;
		this.queueSize = queueSize;
		
	}

	public void run () {
		
		System.out.println(Thread.currentThread().getName());
		while(true) {
			while(queue.size() == 0) {
				
				synchronized (queue) {
				
					System.out.println("Queue is empty");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			
			synchronized (queue) {
	            queue.notify();
	            queue.remove(0);
	            System.out.println("Consumer consumed another one: " + ++i + ". Size of queue is: " + queue.size());
	        }
		}
	}
}


public class ProducerConsumer {
	public static void main(String[] args) {
		
		int queueSize = 6;
		List<Integer> queue = new ArrayList<>();
		
		queue.add(1);
		queue.add(1);
		queue.add(1);
		
		Producer p = new Producer(queue, queueSize);
		
		Consumer c = new Consumer(queue, queueSize);
		
		p.start();
		
		c.start();
		
		
	}
}

