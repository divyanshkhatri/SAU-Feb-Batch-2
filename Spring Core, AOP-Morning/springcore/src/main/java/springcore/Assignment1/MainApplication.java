package springcore.Assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
		
		Point p = context.getBean(Point.class);
		
		int[] point1 = {10,0}; 
		int[] point2 = {10,5};
		int[] point3 = {15,5};
		int[] point4 = {15,0};
		
		p.setA(point1);
		p.setB(point2);
		p.setC(point3);
		p.setD(point4);
		
		Rectangle rect = context.getBean(Rectangle.class);
		
		rect.setWidth(point1, point2);
		
		rect.setHeight(point2, point3);
		
		String[] colors = new String[] {"Red", "blue", "green", "yellow", "pink", "purple"};
		
		rect.setColors(colors);
		
		System.out.println(rect.calculatePerimeter());
		
		System.out.println(rect.calculateArea());
		
		System.out.println("The color of this rectangle is: " + rect.showColor());

	}

}
