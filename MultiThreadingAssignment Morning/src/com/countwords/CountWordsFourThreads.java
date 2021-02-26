package com.countwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Thread0 extends Thread {
	
	String str;
	
	public Thread0(String str) {
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

class Thread3 extends Thread {
	
	String str;

	public Thread3(String str) {
		this.str = str;
	}
	
	public void run() {
	
		System.out.println("Number of words from Thread 2 are: " + countWords(str));
		
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

class Thread4 extends Thread {
	
	String str;

	public Thread4(String str) {
		this.str = str;
	}
	
	public void run() {
	
		System.out.println("Number of words from Thread 3 are: " + countWords(str));
		
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

class Thread5 extends Thread {
	
	String str;
	
	public Thread5(String str) {
		
		this.str = str;
		
	}
	
	public void run() {
		
		System.out.println("Number of words from Thread 4 are: " + countWords(str));
		
		
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


public class CountWordsFourThreads {
	
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
		
		int quarterSize = size/4;
		
		int threeQuarterSize = 3*size/4;
		
		while(str.charAt(quarterSize) != ' ') {
			quarterSize++;
		}
		
		while(str.charAt(halfSize) != ' ') {
			halfSize++;
		}
		
		while(str.charAt(threeQuarterSize) != ' ') {
			threeQuarterSize++;
		}
		
		String s1 = str.substring(0, quarterSize+1);
		String s2 = str.substring(quarterSize+1, halfSize+1);
		String s3 = str.substring(halfSize+1, threeQuarterSize+1);
		String s4 = str.substring(threeQuarterSize+1);
		
		Thread0 thread0 = new Thread0(s1);
		
		Thread3 thread3 = new Thread3(s2);
		
		Thread4 thread4 = new Thread4(s3);
		
		Thread5 thread5 = new Thread5(s4);
		
		thread0.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
//		System.out.println(size);
		
		var endTime = System.currentTimeMillis();
		
		System.out.println("Total Time taken by four threads are: " + (endTime-startTime) + "ms");
		
	}

}
