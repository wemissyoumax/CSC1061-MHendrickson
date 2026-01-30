
public class Dog extends Animal {

	public int barkVolume;
	
	public Dog() {
		
	}

	public Dog(String name, double weight, double height, int barkVolume) {
		super(name, weight, height);
		// TODO Auto-generated constructor stub
	}

	
	public int getBarkVolume() {
		return barkVolume;
	}

	@Override
	public String makeSound() {
		return "Bow wow";
	}

	@Override
	public String toString() {
		return super.toString() + "Dog [barkVolume=" + barkVolume + "]";
	}

	
	
}
