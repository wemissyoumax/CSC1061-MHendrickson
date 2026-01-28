
public class Farm {
	
	public static void main(String[] args) {
		
		Cat tango = new Cat("Tango", 3.0, 1.0, 0);
		System.out.println(tango);
		
		System.out.println(tango.makeSound());
		
		Horse roscoe = new Horse();
		roscoe.setName("Roscoe");
		System.out.println(roscoe.makeSound());
		
	}
}
