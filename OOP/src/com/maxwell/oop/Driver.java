package com.maxwell.oop;

public class Driver {
	public static void main(String[] args) {
		
		// System.out.println("Number of cars: " + Car.getCount());
		
		Car myCar = new Car("Pink");
		myCar.drive(10);
		// Chaining
		myCar.getRadio().setVolume(11);
		System.out.println("Number of cars: " + myCar.getCount());
		
		System.out.println("Is car clean?" + myCar.isClean());
		Car car1 = new Car();
		Car.cleanCar(car1);
		System.out.println("After cleaning is car clean?" + myCar.isClean());
		System.out.println("Number of cars: " + car1.getCount());
		
		Car car2 = new Car();
		System.out.println("Number of cars: " + Car.getCount());
		System.out.println("Id of car: " + car1.getId());
		
//		
//		// Constructor to give the driver a Car
//		Car myCar = new Car();
//		
//		Car car2 = new Car ("Blue", 2.0);
////		car2.grndClearance = 12;
//		car2.setGrndClearance(12);
//		System.out.println(car2.toString());
//		car2.drive(0);
	}
}
