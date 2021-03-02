package springcore.Assignment2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Laptop {

	int laptopId;
	
	String laptopName;
	
	String laptopBrand;
	
	int laptopRank;
	
	@Autowired
	Brand b;

	public int getLaptopId() {
		return laptopId;
	}

	public void setLaptopId(int laptopId) {
		this.laptopId = laptopId;
		throw new RuntimeException();
	}

	public String getLaptopName() {
		return laptopName;
	}

	public void setLaptopName(String laptopName) {
		this.laptopName = laptopName;
		System.out.println("Setting Laptop Name (called from the Laptop.java class)...");
	}

	public String getLaptopBrand() {
		return laptopBrand;
	}

	public void setLaptopBrand() {
		System.out.println("Around Annotation will be called in the getBrand function called inside the setLaptopBrand function.");
		this.laptopBrand = b.getBrand();
	}

	public int getLaptopRank() {
		return laptopRank;
	}

	public void setLaptopRank() {
		this.laptopRank = b.getRank();
	}

}
