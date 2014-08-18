/*
 * A number is a perfect number if it is equal to sum of all its positive divisor 
 * (excluding the number itself and including 1)
 */
package interviewPrograms;
public class PerfectNumber {

	public static boolean isPerfectNumber(int num) {
		int temp=1;
		for (int i=2; i<num; i++) {
			if (num%i==0)
				temp+=i;
		}
		if (temp==num)
			return true;
		else
			return false;
	}
	public static void main(String[] args) {
		int num=33550336;
		System.out.println("Number: " + num);
		System.out.println("Is perfect number: " + isPerfectNumber(num));
	}

}
