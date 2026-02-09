
public class Car extends Vehicle {

	public Car(String color, long id) {
		super(color, id);
	}

	@Override
	public double drive() {
		return 80.0;
	}

	@Override
	public void feed(int numGallons) {
		
	}



}
