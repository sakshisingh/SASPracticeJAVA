package interviewPrograms;

public class StringReverse {
	/*
	 * Recursive method - Return last character and call reverse again
	 * Time complexity - O(n^2) as substring has O(n) complexity Java 7 update 6
	 * Space efficiency better as no extra data structure is used
	 */
	public static String reversedString(String str) {
		if (str.length()<=1)
			return str;
		return str.charAt(str.length()-1) + reversedString(str.substring(0, str.length()-1));
	}
	
	/*
	 * Copy string reversed in a new char[]
	 * Time Complexity O(n) but needs extra space, same size as the string
	 */
	public static String reverseString2(String str) {
		int strLen = str.length();
		char[] reversedStr = new char[strLen];
		for (int i=strLen-1; i>=0; i--) {
			reversedStr[strLen-(i+1)] = str.charAt(i);
		}
		return String.copyValueOf(reversedStr);
	}
	
	/*
	 * In place reverse. Runs n/2 times. Time complexity O(n). No extra space
	 */
	public static String reverseStringInplace(String str) {
		int strLen = str.length() - 1, i=0;
		char[] reversedStr = str.toCharArray();
		char tmp;
		while (i<strLen) {
			tmp = reversedStr[i];
			reversedStr[i++] = reversedStr[strLen];
			reversedStr[strLen--] = tmp;
		}
		return String.copyValueOf(reversedStr);
	}
	
	public static void main(String[] args) {
		String str = "chi chi";
		System.out.println("String: " + str);
		System.out.println("Reversed String from recursion: " + reversedString(str));
		System.out.println("Reversed String from method 2: " + reverseString2(str));
		System.out.println("Reversed String from in place method: " + reverseStringInplace(str));
	}
}
