
public class Animal implements Feedable {
	private String animalName;
	private double animalWeight;
	
	public Animal(String name, double weight) {
		setAnimalName(name);
		animalWeight = weight;
	}
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public double getAnimalWeight() {
		return animalWeight;
	}
	public void setAnimalWeight(double animalWeight) {
		this.animalWeight = animalWeight;
	}

	@Override
	public String toString() {
		return "Animal [animalName=" + animalName + ", animalWeight=" + animalWeight + "]";
	}

	@Override
	public void feed(int numGallons) {
		
	}

	
	
	
}
