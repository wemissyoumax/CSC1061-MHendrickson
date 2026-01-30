
public class Horse extends Animal{
	
	private int speed;
	
	@Override
	public String makeSound() {
		return "Neigh neigh";
	}

	@Override
	public String toString() {
		return super.toString() + "Horse [speed=" + speed + "]";
	}
	
}
