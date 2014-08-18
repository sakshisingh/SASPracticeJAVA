package interviewPrograms;

public class Fibonacci {

	public static void fibonacciIterative(int n) {
		int num1 = 0;
		int num2 = 1;
		for (int i=0; i<n; i++) {
			int temp;
			System.out.print(num1 + "  ");
			temp=num1;
			num1=num2;
			num2+=temp;
		}
	}
	
	public static int fibonacciRecursive(int n) {
		if (n==0 || n==1)
			return n;
		else
			return (fibonacciRecursive(n-1) + fibonacciRecursive(n-2));
	}
	
	public static void main(String[] args) {
		int n=8;
		System.out.println("Number of terms: " + n);
		System.out.println("Fibonacci Series: ");
		fibonacciIterative(n);
		System.out.println();
		System.out.println("Fibonacci Series using recursion: ");
		System.out.print(fibonacciRecursive(13));
	}
}
