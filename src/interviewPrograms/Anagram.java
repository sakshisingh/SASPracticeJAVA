/*
 * Check if 2 strings are an anagram of each other
 * I have provided 2 implementations for this problem.
 */
package interviewPrograms;

import java.util.Arrays;
import java.util.HashMap;
public class Anagram {

	
	/* Approach 1: Sort the arrays and then compare
	 * Complexity: nlgn + nlgn + n = O(nlgn)
	 */
	public static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length())
				return false;
		char [] A1 = str1.toCharArray();
		char [] A2 = str2.toCharArray();
		SearchingnSorting.QuickSort.quickSort(A1, 0, A1.length-1);
		SearchingnSorting.QuickSort.quickSort(A2, 0, A2.length-1);
		if (Arrays.equals(A1, A2))
			return true;
		return false;
	}
	
	/* Approach 2: Count which character appears how many times.
	 * Create an integer array for each string to store number of occurences of each character in that string
	 * Compare these two character arrays. If they are equal, strings are anagram.
	 * Complexity: n + n = O(n)
	 */
	public static boolean isAnagramCharSet(String str1, String str2) {
		if (str1.length() != str2.length())
				return false;
		int [] A1 = new int[256];
		int [] A2 = new int[256];
		
		for (int i=0; i< str1.length(); i++) {
			A1[str1.charAt(i)]++;
			A2[str2.charAt(i)]++;
		}
		
		if (Arrays.equals(A1, A2))
			return true;
		return false;
	}
	
	public static boolean isAnagramHashMap(String str1, String str2) {
		if (str1.length() != str2.length())
				return false;
		HashMap<Character, Integer> A1 = new HashMap<>();
		
		for (int i=0; i< str1.length(); i++) {
			char ch1 = str1.charAt(i);
			Integer v1 = A1.get(ch1);
			A1.put(ch1, v1!=null?v1+1:1);
			char ch2 = str2.charAt(i);
			Integer v2 = A1.get(ch2);
			A1.put(ch2, v2!=null?v2-1:-1);
		}
		
		for(Integer itr : A1.values()) {
			if (itr!=0)
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		String str1 = "abcda";
		String str2 = "acabd";
		
		System.out.println (str1 + " is an anagram of " + str2 + ": " + isAnagram(str1, str2));
		System.out.println (str1 + " is an anagram of " + str2 + ": " + isAnagramCharSet(str1, str2));
		System.out.println (str1 + " is an anagram of " + str2 + ": " + isAnagramHashMap(str1, str2));
	}
}
