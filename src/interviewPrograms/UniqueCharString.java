/*
 * Algorithm to check if a string has all unique characters
 */
package interviewPrograms;

import java.util.ArrayList;

public class UniqueCharString {

	/*
	 * Using ArrayList data structure
	 * Complexity: n.logn if size of string is n (log n for searching done by contains method)
	 * Sorting the string and then comparing consecutive characters also has same complexity.
	 */
	public static boolean uniqueChar(String s) {
		ArrayList<Character> strChar = new ArrayList<>();
		for (int i=0; i<s.length(); i++) {
			if (strChar.contains(s.charAt(i)))
				return false;
			else
				strChar.add(s.charAt(i));
		}
		return true;
	}
	
	/*
	 * Comparing character ascii value
	 * Complexity: n if size of string is n
	 */
	public static boolean uniqueCharSet(String s) {
		//Total unique characters = 256. So string lentgh >256 must repeat some character
		if (s.length()>256)
			return false;
		boolean [] charFound = new boolean[256];	//Boolean array is initialized as false
		
		for (int i=0; i< s.length(); i++) {
			int ch = s.charAt(i);
			if (charFound[ch])
				return false;
			else
				charFound[ch] = true;
		}
		return true;
	}
	public static void main(String[] args) {
		String s = "HellLo arn";
		System.out.println("String \"" + s + "\" has all unique characters: ");
		System.out.println("Using Arraylist: " + uniqueChar(s));
		System.out.println("Using char set: " + uniqueCharSet(s));
	}
}
