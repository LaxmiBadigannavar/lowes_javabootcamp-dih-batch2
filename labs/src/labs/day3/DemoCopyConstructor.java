package labs.day3;
class Car{
	public String name;
	public String brand;
	public String color;
	public String engineType;
	public int price;
	
	public Car(String name,String brand,String color,String engineType,int price) {
		this.name = name;
		this.brand = brand;
		this.color = color;
		this.engineType = engineType;
		this.price=price;
		System.out.println("Parametrised Constructor");
		
	}
	public Car(Car car) {
		this.name = car.name;
		this.brand = car.brand;
		this.color = car.color;
		this.engineType = car.engineType;
		this.price=car.price;
		System.out.println("Copy Constructor");
	}
	public Car(Car car,int price) {
		this.name = car.name;
		this.brand = car.brand;
		this.color = car.color;
		this.engineType = car.engineType;
		this.price=price;
		System.out.println("Copy Constructor with one parameter");
	}
	
}
public class DemoCopyConstructor {
	public static void main(String[] args) {
		Car car1 = new Car("Swift","Maruthi","White","Petrol",1000000);
		Car car2= new Car(car1);
		Car car3 = new Car(car1,1400000);
	}

}
