package springcore.Assignment1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.stereotype.Component;

@Component
public class Rectangle {

	private double height;
	private double width;
	private String[] colors;
	
	public String[] getColors() {
		return colors;
	}

	public void setColors(String[] colors) {
		this.colors = colors;
	}

	@Autowired
	@Qualifier("point")
	Point p;
	
	public double getHeight() {
		
		return height;
	}
	
	public void setHeight(int[] p1, int[] p2) {
		
		height = Math.sqrt(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2));
		
	}
	
	public double getWidth() {
		
		return width;
	}
	
	public void setWidth(int[] p1, int[] p2) {

		width = Math.sqrt(Math.pow(p1[0]-p2[0], 2) + Math.pow(p1[1]-p2[1], 2));
		
	}
	
	public String showColor() {
		
		int i = (int) Math.round(Math.random()*(colors.length-1));
		
		return colors[i];
	}
	
	public String calculatePerimeter() {
		
		return "The perimeter is: " + 2*(width+height);
		
	}
	
	public String calculateArea() {
		
		return "The area is: " + width*height;
		
	}
		
}
