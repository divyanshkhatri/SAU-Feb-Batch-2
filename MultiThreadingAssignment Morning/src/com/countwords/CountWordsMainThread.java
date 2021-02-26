package com.countwords;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordsMainThread {
	
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
			e.printStackTrace();
		}

		int words = countWords(str);
		int size = str.length();
		System.out.println("Total number of words from main thread are: " + words);
		
		var endTime = System.currentTimeMillis();
		
		System.out.println("Total Time taken in main thread is: " + (endTime-startTime) + "ms");

	}

}
