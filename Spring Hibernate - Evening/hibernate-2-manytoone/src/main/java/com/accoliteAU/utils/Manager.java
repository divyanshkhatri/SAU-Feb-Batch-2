package com.accoliteAU.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.accoliteAU.model.Owner;
import com.accoliteAU.model.Pet;

public class Manager {

	public  static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();	
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		
		String ch = "";
		
		try {
			do {
				
				Pet p1 = new Pet();
				Pet p2 = new Pet();
				Owner o = new Owner();
				
				System.out.println("Enter the 1st Pet Id");
				p1.setPetId(sc.nextInt());
				
				System.out.println("Enter the 1st Pet Name");
				p1.setPetName(sc.next());
				
				System.out.println("Enter the 2nd Pet Id");
				p2.setPetId(sc.nextInt());
				
				System.out.println("Enter the 2nd Pet Name");
				p2.setPetName(sc.next());
				
				List<Pet> pets = new ArrayList<>();
				
				pets.add(p1);
				pets.add(p2);
				
				o.setPets(pets);
				
				p1.setOwner(o);
				p2.setOwner(o);
				
				System.out.println("Enter the 1st Owner Id");
				o.setOwnerId(sc.nextInt());
				
				System.out.println("Enter the 1st Owner Name");
				o.setOwnerName(sc.next());
				
				session.save(p1);
				session.save(p2);
				session.save(o);
				
				System.out.println("Do you want to add more Pets and Owners?");
				ch = sc.next();
			} while("y".equalsIgnoreCase(ch));
			tx.commit();
			session.close();
			sc.close();
			System.out.println("Your details are persisted, thanks!!");
		} catch(Exception e) {
			tx.rollback();
			System.out.println("Exception occured, hence rollback!!!");
		}
		
	}
}
