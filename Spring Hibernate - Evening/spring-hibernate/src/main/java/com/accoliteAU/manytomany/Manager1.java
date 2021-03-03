package com.accoliteAU.manytomany;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager1 {
	public static void main(String args[]) {
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session ses = factory.openSession();	
		Transaction tx = ses.beginTransaction();
		Category c1 = new Category();
		c1.setCategoryId(1);
		c1.setCategoryName("cat 1");

		Category c2 = new Category();
		c2.setCategoryId(2);
		c2.setCategoryName("cat 2");

		Item i1 = new Item();
		Item i2 = new Item();

		i1.setItemId(101);
		i1.setItemName("item1");

		i2.setItemId(102);
		i2.setItemName("item2");
		
		Set<Item> items = new HashSet<>();
		items.add(i1);
		items.add(i2);

		c1.setItems(items);
		c2.setItems(items);

		Set<Category> categories = new HashSet<>();
		
		categories.add(c1);
		categories.add(c2);
		
		i1.setCategories(categories);
		i2.setCategories(categories);
		
		ses.save(c1);
		ses.save(c2);
		tx.commit();
		System.out.println("Many to Many using annotations been done...!!!!!");
		ses.close();
	}
}