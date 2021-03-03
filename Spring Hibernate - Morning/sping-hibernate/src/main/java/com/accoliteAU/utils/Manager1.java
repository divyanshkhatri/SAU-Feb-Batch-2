package com.accoliteAU.utils;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.accoliteAU.model.Employee;

public class Manager1 {
	
	@SuppressWarnings({ "unchecked", "resource" })
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();	
		Transaction tx = session.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose an Option");
		System.out.println("1. Create employee");
		System.out.println("2. Update all employee");
		System.out.println("3. Update employee by id");
		System.out.println("4. Delete employee - warning: this cannot be recovered");
		System.out.println("5. Get all employee");
		System.out.println("6. Get Employee by id");
		System.out.println("7. exit");
		int val = sc.nextInt();
		switch (val) {
			case 1:
				String ch = "";
				try {
					do {
						
						Employee e1 = new Employee();
						
						System.out.println("Enter the Id");
						e1.setId(sc.nextInt());
						
						System.out.println("Enter the First Name");
						e1.setfName(sc.next());
						
						System.out.println("Enter the Last Name");
						e1.setlName(sc.next());
						
						System.out.println("Enter the age");
						e1.setAge(sc.nextInt());
						
						System.out.println("Enter the salary");
						e1.setSalary(sc.nextInt());
						
						System.out.println("Enter the date of birth");
						e1.setDob(sc.next());
			
						System.out.println("Enter the Designation");
						e1.setDesignation(sc.next());
						
						session.save(e1);
						System.out.println("Do you want to add more Employee?");
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
				
				break;
				
			case 2:
				
				System.out.println("1. Change First Name");
				System.out.println("2. Change Last Name");
				System.out.println("3. Change Age");
				System.out.println("4. Change Salary");
				System.out.println("5. Change DOB");
				System.out.println("6. Change Designation");
				int choose = sc.nextInt();
				switch(choose) {
					case 1: 
						System.out.println("What do you want to change the first name to ?");
						String fname = sc.next();
					    Query query = session.createQuery("update Employee set fname = :fname WHERE id is NOT NULL");
					    query.setParameter("fname", fname);
					    int result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
					case 2:
						System.out.println("What do you want to change the last name to ?");
						String lname = sc.next();
						String sql = "update Employee set lname = :lname WHERE id is NOT NULL";
						query = session.createQuery(sql);
						query.setParameter("lname", lname);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 3:
						System.out.println("What do you want to change the age to ?");
						String age = sc.next();
						query = session.createQuery("update Employee set age = :age WHERE id is NOT NULL");
						query.setParameter("age", age);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 4: 
						System.out.println("What do you want to change the salary to ?");
						String salary = sc.next();
						query = session.createQuery("update Employee set salary= :salary WHERE id is NOT NULL");
						query.setParameter("salary", salary);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 5:
						System.out.println("What do you want to change the date of birth to ?");
						String dob = sc.next();
						query = session.createQuery("update Employee set dob= :dob WHERE id is NOT NULL");
						query.setParameter("dob", dob);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
					    tx.commit();
					    break;
					    
					case 6: 
						System.out.println("What do you want to change the designation to ?");
						String designation = sc.next();
						query = session.createQuery("update Employee set designation= :designation WHERE id is NOT NULL");
						query.setParameter("designation", designation);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
					    tx.commit();
					    break;
					    
				}
				
			    break;
			case 3:
				
				System.out.println("Provide the id of the employee");
				int id = sc.nextInt();
				System.out.println("1. Change First Name");
				System.out.println("2. Change Last Name");
				System.out.println("3. Change Age");
				System.out.println("4. Change Salary");
				System.out.println("5. Change DOB");
				System.out.println("6. Change Designation");
				choose = sc.nextInt();
				switch(choose) {
					case 1: 
						System.out.println("What do you want to change the first name to ?");
						String fname = sc.next();
					    Query query = session.createQuery("update Employee set fname = :fname WHERE id = :id");
					    query.setParameter("fname", fname);
					    query.setParameter("id", id);
					    int result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
					case 2:
						System.out.println("What do you want to change the last name to ?");
						String lname = sc.next();
						String sql = "update Employee set lname = :lname WHERE id = :id";
						query = session.createQuery(sql);
						query.setParameter("lname", lname);
						query.setParameter("id", id);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 3:
						System.out.println("What do you want to change the age to ?");
						String age = sc.next();
						query = session.createQuery("update Employee set age = :age WHERE id = :id");
						query.setParameter("age", age);
						query.setParameter("id", id);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 4: 
						System.out.println("What do you want to change the salary to ?");
						String salary = sc.next();
						query = session.createQuery("update Employee set salary= :salary WHERE id = :id");
						query.setParameter("salary", salary);
						query.setParameter("id", id);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
						tx.commit();
						break;
						
					case 5:
						System.out.println("What do you want to change the date of birth to ?");
						String dob = sc.next();
						query = session.createQuery("update Employee set dob= :dob WHERE id = :id");
						query.setParameter("dob", dob);
						query.setParameter("id", id);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
					    tx.commit();
					    break;
					    
					case 6: 
						System.out.println("What do you want to change the designation to ?");
						String designation = sc.next();
						query = session.createQuery("update Employee set designation= :designation WHERE id = :id");
						query.setParameter("designation", designation);
						query.setParameter("id", id);
					    result = query.executeUpdate();
					    System.out.println("Employee Update Status="+result);
					    tx.commit();
					    break;
					    
				}
			    break;
			case 4:
				System.out.println("Enter the id of the employee.");
				int emp_id = sc.nextInt();
				System.out.println("Are you sure you want to delete the employee? Press 1 to delete or Press 0 to exit!");
				int delete = sc.nextInt();
				if(delete == 1) {
					Employee e = session.get(Employee.class, emp_id);
					session.delete(e);
					tx.commit();
				} else {
					System.exit(1);
				}

				
			    break;
			case 5:
				String sql = "select * from EMPLOYEE";
				List<Object[]> obj = session.createSQLQuery(sql).list();
				for (Object row[] : obj) {
					for(Object ob:row) {
						System.out.print(ob +" ");
					}
					System.out.println();
				}
				tx.commit();
			    break;
			case 6:
				System.out.println("Enter the id of the employee");
				emp_id = sc.nextInt();
				Query query = session.createSQLQuery("select * from EMPLOYEE WHERE id = :id");
				query.setParameter("id", emp_id);
				obj = query.getResultList();
				for (Object row[] : obj) {
					for(Object ob:row) {
						System.out.print(ob +" ");
					}
					System.out.println();
				}
				tx.commit();
			    break;
			case 7:
				return; 
		}
		
	}
}
