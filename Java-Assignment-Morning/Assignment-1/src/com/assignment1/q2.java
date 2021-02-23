package com.assignment1;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class student1 {

	public String roll_no;
	public String marks;
		
	
}

class q2 {
	
	public static String extractInt(String str) 
    { 
        str = str.replaceAll("[^\\d]", " "); 
        str = str.trim(); 
        str = str.replaceAll(" +", " "); 
        if (str.equals("")) 
            return "-1"; 
        return str; 
    } 
	
	public static Comparator<student1> StuRollno = new Comparator<student1>() {

		public int compare(student1 s1, student1 s2) {

		   int marks1 = Integer.parseInt(s1.marks);
		   int marks2 = Integer.parseInt(s2.marks);

		   /*For ascending order*/
		   return marks1-marks2;

		   /*For descending order*/
		   //rollno2-rollno1;
	}};
	
	 private static void writeToCSV(ArrayList<student1> hm, StringBuffer oneLine, BufferedWriter bw){
        try
        {
  	      	
            for (student1 student : hm)
            {
                
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) {}
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
	public static void main(String[] args) {
	
	try {
		  ArrayList<student1> hm = new ArrayList<>(); 
		  File myObj = new File("student.txt");
		  @SuppressWarnings("resource")
		Scanner myReader = new Scanner(myObj);
		  while (myReader.hasNextLine()) {
		    String data = myReader.nextLine();
		    student1 s = new student1();
		    String str = extractInt(data);
		    String[] divided = str.split(" ");
		    s.roll_no = divided[0];
		    s.marks = divided[1];
		    hm.add(s);
		  }
		  
		  Collections.sort(hm, StuRollno);
		  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("student_result.csv"), "UTF-8"));
	      StringBuffer oneLine = new StringBuffer();
	      oneLine.append("Rank,Roll Number,Total Marks (out of 300)");
	      bw.write(oneLine.toString());
	      bw.newLine();
		  
	      int i = 0;
		  for(student1 s: hm) {
			  i++;
			  oneLine = new StringBuffer();
			  System.out.println(s.roll_no + " : " + s.marks + " : " + i );
			  oneLine.append(i);
              oneLine.append(",");
              oneLine.append(s.roll_no);
              oneLine.append(",");
              oneLine.append(s.marks);
              System.out.println(oneLine);
              bw.write(oneLine.toString());
              bw.newLine();
		  }
		  bw.flush();
          bw.close();
		  
	} catch (FileNotFoundException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

	
}


