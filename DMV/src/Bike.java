
public class Bike extends Vehicle{
	
	public Bike (String color, long id) {
		super(color, id);
	}

	@Override
	public double drive() {
		return 3.0;
	}

	@Override
	public void feed(int numGallons) {
		
	}


}
