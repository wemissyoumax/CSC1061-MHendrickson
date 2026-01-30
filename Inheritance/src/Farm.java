import java.util.ArrayList;
import java.util.List;


public class Farm {
	
	public static void main(String[] args) {
		
		Animal[] animals = new Animal[3];
		
		List<Animal> animList = new ArrayList<>();
		animList.add(new Cat("Orange", 2.0, 1.0, 3));
		animList.add(new Dog("Rufus", 4.0, 3.0, 5));
		
		
		animals[0] = new Cat("Tabby", 2.0, 1.0, 3);
		animals[1] = new Horse();
		animals[2] = new Dog ("Rufus", 4.0, 3.0, 5);
		
		for (int i = 0; i < animals.length; i++) {
			System.out.println(animals[i].makeSound());
		}
		
		// For each loop (for traversing the array)
		// : = in
		// "For each anim in class Animal in type animals"
		for(Animal anim: animals) {
			System.out.println(anim.makeSound());
			printAnimal(anim);
		}
	}
	
	public static void printAnimal (Animal anim) {
		System.out.println(anim);
	}
	
	public static void printWithoutToString(Animal anim) {
		System.out.println("Name = " + anim.getName() 
		+ "Weight = " + anim.getWeight() + "Height = " + anim.getHeight());
		if (anim instanceof Cat) {
			int lengthOfWhiskers = ((Cat)anim).getLengthOfWhiskers();
			System.out.println("Length of whiskers = " + lengthOfWhiskers);
		}
		if (anim instanceof Dog) {
			System.out.println("Bark volume = " + ((Dog)anim).getBarkVolume());
		}
	}
}
