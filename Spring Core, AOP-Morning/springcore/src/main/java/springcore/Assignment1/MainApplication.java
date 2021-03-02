package springcore.Assignment1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApplication {
	
	public static void main(String[] args) {
		
		ConfigurableApplicationContext context = SpringApplication.run(MainApplication.class);
		
		Point p = context.getBean(Point.class);
		Scanner sc = new Scanner(System.in);
		
		int[] point1 = new int[2]; 
		int[] point2 = new int[2];
		int[] point3 = new int[2];
		int[] point4 = new int[2];
		
		System.out.println("Enter the X-coordinate of the Point A");
		
		point1[0] = sc.nextInt();
		
		System.out.println("Enter the Y-coordinate of the Point A");

		point1[1] = sc.nextInt();
		
		System.out.println("Enter the X-coordinate of the Point B");
		
		point2[0] = sc.nextInt();
		
		System.out.println("Enter the Y-coordinate of the Point B");

		point2[1] = sc.nextInt();

		System.out.println("Enter the X-coordinate of the Point C");
		
		point3[0] = sc.nextInt();
		
		System.out.println("Enter the Y-coordinate of the Point C");

		point3[1] = sc.nextInt();

		System.out.println("Enter the X-coordinate of the Point D");
		
		point4[0] = sc.nextInt();
		
		System.out.println("Enter the Y-coordinate of the Point D");

		point4[1] = sc.nextInt();
		
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
