package com.accoliteAU.utils;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.accoliteAU.model.Owner;

public class Manager1 {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("1. Try method 1");
		System.out.println("2. Try method 2");
		System.out.println("3. Try method 3");
		
		int val = sc.nextInt();
		
		switch(val) {
		
			case 1:
				
				@SuppressWarnings("deprecation")
				Criteria criteria = session.createCriteria(Owner.class);
				criteria.add(Restrictions.like("ownerName", "Owner1"));
		
				@SuppressWarnings("unchecked")
				List<Owner> owners = criteria.list();
				
				owners.forEach(o1->System.out.println("Owner Id: "  + o1.getOwnerId() + ", Owner Name: " + o1.getOwnerName()));
				break;
		
			case 2:
				
				@SuppressWarnings("unchecked") List<Owner> Owner = session.createQuery("from Owner").list();

				for (Owner o : Owner) {
					System.out.print("Owner Id: " + o.getOwnerId() + " ");
					System.out.println(", Owner Name: " + o.getOwnerName());
					System.out.println("----------");

				}
				
				break;
			
			case 3:
				
				@SuppressWarnings("deprecation") Criteria ctr=session.createCriteria(Owner.class);
				Criterion c1=Restrictions.like("ownerName", "OwnerB");
				Criterion c2=Restrictions.like("ownerId", 2);
				Criterion sum=Restrictions.and(c1,c2);
				ctr.add(sum);
				@SuppressWarnings("unchecked") List<Owner> owner = ctr.list();
				
				for (Owner o : owner) {
					System.out.print("Owner Id: " + o.getOwnerId() + " ");
					System.out.println(", Owner Name: " + o.getOwnerName());
					System.out.println("----------");

				}
				break;		
		}
		
		sc.close();
		session.close();
		
	}

}
