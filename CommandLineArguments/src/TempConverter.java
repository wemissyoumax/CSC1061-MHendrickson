/*
 * Copyright (c) 2026 Max Hendrickson
 * 
 * Permissions given to your mom
 */

import java.util.Arrays;

/**
 * Methods to convert temperature from one system to another
 * @author Max Hendrickson
 * @author Mike Tyson
 * 
 */

public class TempConverter {
	
	public final double FREEZING_TEMP_IN_CELSIUS = 0;
	public final double FREEZING_TEMP_IN_FARENHEIT = 32;
	/**
	 * Converts a temperature from Farenheit to Celsius
	 * @param temoerature in Farenheit
	 * @return temperature in Celsius
	 */
	public static double ConvertFartoCel(double input) {
		return((input - 32) * (5.0/9.0));
	}
	/**
	 * Converts a temperature from Celsius to Farenheit
	 * @param temperautre in Celsius
	 * @return temeprature in Farenheit
	 */
	public static double ConvertCeltoFar(double input) {
		return ((input * (9.0/5.0)) + 32);
	}
}
