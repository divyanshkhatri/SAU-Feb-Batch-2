package com.countwords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


class Thread6 extends Thread {
	
	String str;

	public Thread6(String str) {
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


public class CountWordsSingleThread {
	
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
				
		Thread6 thread6 = new Thread6(str);
		
		thread6.start();

//		System.out.println(size);
		
		var endTime = System.currentTimeMillis();
		
		System.out.println("Total Time taken by a single thread is: " + (endTime-startTime) + "ms");
		
	}

}
