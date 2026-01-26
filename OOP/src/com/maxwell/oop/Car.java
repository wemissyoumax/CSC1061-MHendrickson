package com.maxwell.oop;

public class Car {
	
	// Data members
	private String color;
	private double amountOfGas;
	private int mileage;
	public int grndClearance;
	public int grndClearanceFt;
	public int grndClearanceIn;
	private int id;
	private boolean isClean;
	
	private static int count = 0;
	
	private Radio radio = new Radio();
	
	
	// Constructors
	public Car(String rcolor) {
		color = rcolor;
		amountOfGas = 1.0;
		mileage = 5;
		count++; // All constructors should have this if we are keeping count
		id = count;
		radio.setVolume(3);
	}
	
	public Car() {
		count++;
	}
	
	public Car(String color, double gas) {
		this.color = color;
		amountOfGas = gas;
		mileage = 0;
	}
	
	// Getters and Setters (Accessors and Mutators)
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}

	public double getAmountOfGas() {
		return amountOfGas;
	}

	public void setAmountOfGas(double amountOfGas) {
		this.amountOfGas = amountOfGas;
	}
	
	public boolean isClean() {
		return isClean;
	}
	
	public int getMileage() {
		return mileage;
	}
	
	public int getGrndClearance() {
		return grndClearance;
	}

	public void setGrndClearance(int grndClearance) {
		this.grndClearanceFt = grndClearance/12;
		this.grndClearanceIn = grndClearance % 12;
	}
	
	// Getter for count method
	public static int getCount() {
		
		return count;
	}
	
	public int getId () {
		return id;
	}
	
	//Methods
	public void drive(int numMiles) {
		for (int i = 0; i < numMiles; i++) {
			System.out.print("+");
		}
		mileage = mileage + numMiles;
		amountOfGas -= numMiles;
		System.out.println();
	}
	
	public void selfCleanCar() {
		isClean = true;
	}
	
	public static void cleanCar(Car car) {
		car.isClean = true;
	}
	
	public Radio getRadio() {
		return radio;
	}
	
	//toString()
	@Override
	public String toString() {
		return "Car : Color: " + color + "\n Amount of Gas: " + amountOfGas + "\nMileage: " + mileage;
	}

	
}
