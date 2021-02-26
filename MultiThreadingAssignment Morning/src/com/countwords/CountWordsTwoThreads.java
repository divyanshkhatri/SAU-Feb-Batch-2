package com.countwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Thread1 extends Thread {
	
	String str;

	public Thread1(String str) {
		this.str = str;
	}
	
	public void run() {
	
		System.out.println("Number of words from Thread 1 are: " + countWords(str));
		
	}
	
	public static int countWords(String str) { 
        
	      // Check if the string is null 
	      // or empty then return zero 
	      if (str == null || str.isEmpty()) 
	          return 0; 
	        
	      // Splitting the string around 
	      // matches of the given regular 
	      // expression 
	      String[] words = str.split("\\s+"); 
	        
	      // Return number of words 
	      // in the given string 
	      return words.length; 
		} 
}

class Thread2 extends Thread {
	
	String str;
	
	public Thread2(String str) {
		
		this.str = str;
		
	}
	
	public void run() {
		
		System.out.println("Number of words from Thread 2 are: " + countWords(str));
		
		
	}
	
	public int countWords(String str) { 
        
	      // Check if the string is null 
	      // or empty then return zero 
	      if (str == null || str.isEmpty()) 
	          return 0; 
	        
	      // Splitting the string around 
	      // matches of the given regular 
	      // expression 
	      String[] words = str.split("\\s+"); 
	        
	      // Return number of words 
	      // in the given string 
	      return words.length; 
		} 
}


public class CountWordsTwoThreads {
	
	public static String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	public static void main(String[] args) {
		
		var startTime = System.currentTimeMillis();
		String str = "";
		try {
			str = readFile("sample-text.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int size = str.length();
		
		int halfSize = size/2;
		
		while(str.charAt(halfSize) != ' ') {
			halfSize++;
		}
		
		String s1 = str.substring(0, halfSize+1);
		String s2 = str.substring(halfSize+1);
		
		Thread1 thread1 = new Thread1(s1);
		
		Thread2 thread2 = new Thread2(s2);
		
		thread1.start();
		thread2.start();
		
//		System.out.println(size);
		
		var endTime = System.currentTimeMillis();
		
		System.out.println("Total Time taken by two threads are: " + (endTime-startTime) + "ms");
		
	}

}
