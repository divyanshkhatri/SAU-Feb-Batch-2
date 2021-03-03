package com.accoliteAU.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.accoliteAU.model.Categories;
import com.accoliteAU.model.Product;
import com.accoliteAU.model.Supplier;

public class Manager1 {
	
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();	
		Transaction tx = session.beginTransaction();
		Scanner sc = new Scanner(System.in);
		
		String ch = "";
		try {
			do {
				
				Product p1 = new Product();
				
				Categories c1 = new Categories();
				Categories c2 = new Categories();
				Categories c3 = new Categories();
				
				Supplier s1 = new Supplier();
				Supplier s2 = new Supplier();
				Supplier s3 = new Supplier();
				
				System.out.println("Enter the Product Id");
				p1.setProductId(sc.nextInt());
				
				System.out.println("Enter the Product Name");
				p1.setProductName(sc.next());
				
				System.out.println("Enter the Category Id");
				c1.setCategoryId(sc.nextInt());
				
				System.out.println("Enter the Category Name");
				c1.setCategoryName(sc.next());
				
				c1.setProduct(p1);
				
				System.out.println("Enter the Category Id");
				c2.setCategoryId(sc.nextInt());
				
				System.out.println("Enter the Category Name");
				c2.setCategoryName(sc.next());
				
				c2.setProduct(p1);
				
				System.out.println("Enter the Category Id");
				c3.setCategoryId(sc.nextInt());
				
				System.out.println("Enter the Category Name");
				c3.setCategoryName(sc.next());
				
				c3.setProduct(p1);
				
				System.out.println("Enter the Supplier Id");
				s1.setSupplierId(sc.nextInt());
				
				System.out.println("Enter the Supplier Name");
				s1.setSupplierName(sc.next());
				
				List<Supplier> supplier1 = new ArrayList<>();
				supplier1.add(s1);
				supplier1.add(s2);
				
				c1.setSupplier(supplier1);
				
				System.out.println("Enter the Supplier Id");
				s2.setSupplierId(sc.nextInt());
				
				System.out.println("Enter the Supplier Name");
				s2.setSupplierName(sc.next());
				
				List<Supplier> supplier2 = new ArrayList<>();
				supplier2.add(s2);
				supplier2.add(s3);
				
				c2.setSupplier(supplier2);
				
				System.out.println("Enter the Supplier Id");
				s3.setSupplierId(sc.nextInt());
				
				System.out.println("Enter the Supplier Name");
				s3.setSupplierName(sc.next());
				
				List<Supplier> supplier3 = new ArrayList<>();
				supplier3.add(s1);
				supplier3.add(s3);
				
				c3.setSupplier(supplier3);
				
				List<Categories> category = new ArrayList<>();
				
				category.add(c1);
				category.add(c2);
				category.add(c3);
				p1.setCategories(category);
								
				List<Categories> category1 = new ArrayList<>();
				
				category1.add(c1);
				category1.add(c2);
				
				List<Categories> category2 = new ArrayList<>();
				
				category2.add(c2);
				category2.add(c3);
				
				List<Categories> category3 = new ArrayList<>();
				
				category3.add(c1);
				category3.add(c3);
				
				s1.setCategories(category1);
				s2.setCategories(category2);
				s3.setCategories(category3);
				
				session.save(p1);
				session.save(c1);
				session.save(c2);
				session.save(c3);
				session.save(s1);
				session.save(s2);
				session.save(s3);
				
				System.out.println("Do you want to add more Products, Categories And Suppliers?");
				ch = sc.next();
			} while("y".equalsIgnoreCase(ch));
			tx.commit();
			session.close();
			sc.close();
			System.out.println("Your accounts are persisted, thanks!!");
		} catch(Exception e) {
			tx.rollback();
			System.out.println("Exception occured, hence rollback!!!");
		}
	}

}
