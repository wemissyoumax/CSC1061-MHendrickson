
public class Driver {
	/**
	 * Test the conversion methods
	 * @param args = command-line arguments
	 */
	public static void main(String[] args) {
		
		double answer = 0.0;
		
		if (args.length < 2) {
			System.out.println("Usage:");
			System.out.println("\t-f <temp> to convert to Farenheit");
			System.out.println("\t-c <temp> to convert to Celsius");
			System.exit(-1);
		}
		if(args[0].equals("-f")) {
			answer = TempConverter.ConvertCeltoFar(Double.parseDouble(args[1]));
			System.out.println("The Farenheit value is: " + answer);
		}
		else if(args[0].equals("-c")) {
			answer = TempConverter.ConvertFartoCel(Double.parseDouble(args[1]));
			System.out.println("The Celsius value is: " + answer);
		}
		else {
			System.out.println("Unrecognized option: " + args[0]);
		}
	}
}
