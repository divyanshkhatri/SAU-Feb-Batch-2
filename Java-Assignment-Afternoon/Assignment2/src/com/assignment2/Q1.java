package com.assignment2;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Q1 {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("license1.xml");
		Document doc1 = builder.parse("license2.xml");
		NodeList list = doc.getElementsByTagName("CSR_Producer");
		NodeList list1 = doc1.getElementsByTagName("CSR_Producer");
		for(int i = 0; i < list.getLength(); i++) {
			Node s = list.item(i);
			if(s.getNodeType() == Node.ELEMENT_NODE) {
				Element listItem = (Element) s;
//				System.out.println(listItem.getAttribute("NIPR_Number"));
				for(int j = 0; j<list1.getLength(); j++) {
					Node s1 = list1.item(j);
					if(s1.getNodeType() == Node.ELEMENT_NODE) {
						Element listItem1 = (Element) s1;
						if(listItem.getAttribute("NIPR_Number").equals(listItem1.getAttribute("NIPR_Number"))) {
							NodeList l = listItem1.getChildNodes();
//							s.appendChild((Node) l);
//							Node imported_node = doc.importNode(listItem1.getFirstChild(), true);
//							Element eElement = (Element) imported_node;
//							listItem.appendChild(imported_node);
							System.out.println(listItem.getAttribute("NIPR_Number"));
							NodeList list2 = listItem.getElementsByTagName("License");
							NodeList list3 = listItem1.getElementsByTagName("License");
							for(int k = 0; k<list2.getLength(); k++) {
								Node s2 = list2.item(k);
								if(s2.getNodeType() == Node.ELEMENT_NODE) {
									Element listItem2 = (Element) s2;
									for(int l1 = 0; l1<list3.getLength(); l1++) {
										Node s3 = list3.item(l1);
										if(s3.getNodeType() == Node.ELEMENT_NODE) {
											Element listItem3= (Element) s3;
											if(listItem2.getAttribute("State_Code").equals(listItem3.getAttribute("State_Code"))){
												if(listItem2.getAttribute("License_Number").equals(listItem3.getAttribute("License_Number"))) {
													if(listItem2.getAttribute("Date_Status_Effective").equals(listItem3.getAttribute("Date_Status_Effective"))) {
//														Node imported_node = doc.importNode(listItem1.getFirstChild(), true);
															NodeList list4 = listItem3.getElementsByTagName("LOA");
															Document newDoc = s2.getOwnerDocument();
															for(int m = 0; m<list4.getLength(); m++) {
																Node s4 = list4.item(m);
																Node imported_node = newDoc.importNode(s4, true);
																s2.appendChild(imported_node);
																if(s4.getNodeType() == Node.ELEMENT_NODE) {
																	Element listItem4 = (Element) s4;
			//														System.out.println(listItem4.getAttribute("LOA_Issue_Date"));
																}
															}
													}
												}
											}
										}
									}
								}
								
								
							}
//							System.out.println(listItem1.getAttribute("NIPR_Number"));
						}
					}
//					System.out.println(listItem1.getAttribute("NIPR_Number"));
				}

			} 
		}
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("Merged_Output.xml"));
        transformer.transform(source, result);
	}
	
	
	
	
}
