
public class Fibonacci {
	public static void main(String args[]) {
		System.out.println("The answer is " + fibonacci(6));
	}
	
	public static int fibonacci(int term) {
		if(term < 2) {
			return term;
		}
		return fibonacci(term -1) + fibonacci(term -2);
	}
}
