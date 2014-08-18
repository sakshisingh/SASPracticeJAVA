package interviewPrograms;

public class Palindrome {

	/*Check if a number is palindrome
	 * Start a pointer from first position and start another pointer from last position
	 * compare data at these pointers, If equal move forward else return false
	 * keep incrementing first pointer and decrementing second one.
	 * terminate when pointers are equal or cross each other
	 */
	
	public static boolean isPalindrome(int num) {
		String numStr = Integer.toString(num);
		int first = 0;
		int last = numStr.length()-1;
		while (first<last) {
			if (numStr.charAt(first++)!=numStr.charAt(last--))
					return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int num=40411404;
		System.out.println("Number " + num + " is palindrome: " + isPalindrome(num));
	}

}
