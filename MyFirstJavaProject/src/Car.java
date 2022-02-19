
public class Car {

	String vin;
	String brand;
	String color;
	Double price;
	int year;
	
	Car(String vin, String brand, String color, Double price, int year) {
		this.vin = vin;
		this.brand = brand;
		this.color = color;
		this.price = price;
		this.year = year;
	}
	
	void printAllInfo() {
		System.out.println(this.vin + ": " + this.color + " " + this.year + " " + this.brand);
	}
}
