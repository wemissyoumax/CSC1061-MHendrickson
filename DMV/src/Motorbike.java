
public class Motorbike extends Vehicle{

	public Motorbike(String color, long id) {
		super(color, id);
	}

	@Override
	public double drive() {
		return 30.0;
	}

	@Override
	public void feed(int numGallons) {
		
	}



}
