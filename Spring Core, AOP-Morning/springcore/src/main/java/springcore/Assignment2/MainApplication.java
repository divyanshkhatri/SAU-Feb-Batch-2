package springcore.Assignment2;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
		
		Scanner sc = new Scanner(System.in);
		
		Brand b = context.getBean(Brand.class);
		Laptop l = context.getBean(Laptop.class);
		
		System.out.println("Set Laptop Name");
		l.setLaptopName(sc.next());

		l.setLaptopBrand();
		
		System.out.println("The laptop name is: " + l.getLaptopName());
		
		System.out.println("Set Laptop Id");
		l.setLaptopId(sc.nextInt());
		
		sc.close();
		
		
	}
	
}

	
	
	

