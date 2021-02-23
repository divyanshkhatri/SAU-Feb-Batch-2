package com.assignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

 class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int roll_no;
	public int marks;
}


public class q1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws SAXException, IOException {
		
		int[] roll_no = new int[9];
		int[] marks = new int[9];
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try {
			
			int[] total = new int[100];
			for(int i = 0; i<total.length; i++) {
				total[i] = 0;
			}
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse("Student.xml");
			NodeList studentList = doc.getElementsByTagName("student");
			for(int i = 0; i < studentList.getLength(); i++) {
				Node s = studentList.item(i);
				if(s.getNodeType() == Node.ELEMENT_NODE) {
					Element student = (Element) s;
//					System.out.println(student.getElementsByTagName("roll").item(0).getTextContent());
					roll_no[i] = Integer.parseInt(student.getElementsByTagName("roll").item(0).getTextContent());
					marks[i] = Integer.parseInt(student.getElementsByTagName("marks").item(0).getTextContent());
					total[roll_no[i]]+= marks[i];
				}
				
			}
			HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
			
			Student s = new Student();
			
			for(int i = 0; i<total.length; i++) {
				if(total[i] != 0) {
					hm.put(i, total[i]);
				}
			}
			
	        File file = new File("student.txt");
	        
	        BufferedWriter bf = null;
	        
	        bf = new BufferedWriter( new FileWriter(file) );
			
			for (Integer i : hm.keySet()) {
//				s.roll_no = i;
//				s.marks = hm.get(i);
				bf.write( "Roll Number " + i + " - Marks - " + hm.get(i));
                
                //new line
                bf.newLine();
				
			}
			bf.flush();

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
