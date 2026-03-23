
public class Fibonacci {
	
	public static long recursioncnt;
	
	public static void main(String[] args) {

		int n = 45;
		System.out.println("The " + n + "th term is " + fibRecursive(n));
		
		
	}
	
	public static int fibRecursive(int n) {
		recursioncnt++;
		if(n <=1) {
			return n;
		}
		int ans = fibRecursive(n-1) + fibRecursive(n-2);
		return ans;
	}
}

