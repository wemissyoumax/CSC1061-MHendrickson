package com.maxwell.oop;

public class Driver {
	public static void main(String[] args) {
		
		// Constructor to give the driver a Car
		Car myCar = new Car();
		
		Car car2 = new Car ("Blue", 2.0);
//		car2.grndClearance = 12;
		car2.setGrndClearance(12);
		System.out.println(car2.toString());
		car2.drive(0);
	}
}
