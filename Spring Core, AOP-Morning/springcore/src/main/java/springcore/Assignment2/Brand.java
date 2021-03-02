package springcore.Assignment2;

import org.springframework.stereotype.Component;

@Component
public class Brand {
	
	String[] brandName = {"Dell", "Alienware", "Lenovo", "MSI", "Apple"};
	
	int[] brandRank = {4, 5, 3, 2, 1};

	public String[] getBrandName() {
		return brandName;
	}

	public void setBrandName(String[] brandName) {
		this.brandName = brandName;
	}

	public int[] getBrandRank() {
		return brandRank;
	}

	public void setBrandId(int[] brandRank) {
		this.brandRank = brandRank;
	}
	
	public String getBrand() {
		return brandName[(int) Math.round(Math.random()*(brandName.length-1))];
	}
	
	public int getRank() {
		return brandRank[(int) Math.round(Math.random()*(brandRank.length-1))];
	}
}
