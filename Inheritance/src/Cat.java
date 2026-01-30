
public class Cat extends Animal {
	
	private int lengthOfWhiskers;
	
	public Cat (int lengthOfWhiskers) {
		super();
		this.setName("Catty");
		this.lengthOfWhiskers = lengthOfWhiskers;
	}
	
	public Cat(String name, double height, double weight, int wlength) {
		super(name, weight, height);
		lengthOfWhiskers = wlength;
	}
	
	public int getLengthOfWhiskers() {
		return lengthOfWhiskers;
	}

	@Override
	public String makeSound() {
		return "Meow meow";
	}


	@Override
	public String toString() {
		return super.toString() + "Whiskers = " + lengthOfWhiskers;
	}
	
}
