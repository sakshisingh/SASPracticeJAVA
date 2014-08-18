package interviewPrograms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Strings {
	
	String str1;
	
	Strings() {
		str1="";
	}
	
	Strings(String str) {
		str1=str;
	}

	/*------------------ Anagram: 3 Approaches-----------------*/
	/* Approach 1: Sort the arrays and then compare
	 * Complexity: nlgn + nlgn + n = O(nlgn)
	 */
	public boolean isAnagram(String str2) {
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
	public boolean isAnagramCharSet(String str2) {
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
	
	public boolean isAnagramHashMap(String str2) {
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
	/*------------------ Anagram: End-----------------*/
	
	/*------------------ Compress String: 2 Approaches-----------------*/
	public static String compressedString(String str) {
		String compStr = "";
		char last=str.charAt(0);
		int lIndex=0;
		for(int i=1; i<str.length(); i++) {
			if (str.charAt(i)!=last) {
				compStr=compStr+last+(i-lIndex);
				last=str.charAt(i);
				lIndex=i;
			}
		}
		compStr=compStr+last+(str.length()-lIndex);
		return (compStr.length()<str.length()?compStr:str);
	}
	
	public static String compressedStringArr(String str) {
		int compLength = countCompressedLength(str);
		int strLength = str.length();
		if (compLength>=strLength)
			return str;
		char [] compStr = new char[compLength];
		char last=str.charAt(0);
		int lIndex=0;
		int index=0;
		for(int i=1; i<str.length(); i++) {
			if (str.charAt(i)!=last) {
				compStr[index++]=last;
				char [] times=Integer.toString(i-lIndex).toCharArray();
				for(int j=0;j<times.length;j++)
					compStr[index++]=times[j];
				last=str.charAt(i);
				lIndex=i;
			}
		}
		compStr[index++]=last;
		char [] times=Integer.toString(str.length()-lIndex).toCharArray();
		for(int j=0;j<times.length;j++)
			compStr[index++]=times[j];
		
		return String.valueOf(compStr);
	}
	
	public static int countCompressedLength(String str) {
		char last = str.charAt(0);
		int lastIndex=0;
		int length=0;
		for (int i=1; i<str.length(); i++) {
			if (str.charAt(i)!=last) {
				int times = Integer.toString(i-lastIndex).length();
				length+=1 + times;
				last=str.charAt(i);
				lastIndex=i;
			}
		}
		int times = Integer.toString(str.length()-lastIndex).length();
		return length+1+times;
	}
	/*------------------ Compress String: End-----------------*/
	
	/*------------------ Concatenate String: 1 Approach-----------------*/
	public static String concatenate(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		String str = "";
		for (int i=0; i<l1+l2; i++) {
			if (i< l1)
				str += str1.charAt(i);
			else
				str += str2.charAt(i-l1);
		}
		return str;
	}
	/*------------------ Concatenate String: End-----------------*/
	
	/*------------------ Encode String: Begin-----------------*/
	public static String encode(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		String str = "";
		for (int i=0; i<(l1>l2?l1:l2); i++) {
			if (i< l1)
				str += str1.charAt(i);
			if (i< l2)
				str += str2.charAt(i);
		}
		return str;
	}
	/*------------------ Encode String: End-----------------*/
	
	/*------------------ Decode String: Begin-----------------*/
	public static void decode(String str, int len1) {
		String str1="";
		String str2="";
		int l1 = len1;
		int l2=str.length()-l1;
		for (int i=0; i<str.length(); i++) {
			if (str1.length() < l1)
				str1 += str.charAt(i);
			if (str2.length() < l2)
				str2 += str.charAt(++i);
		}
		System.out.println("String 1: " + str1 + " String 2: " + str2);
	}
	/*------------------ Decode String: End-----------------*/
	
	/*------------------ Print Space: Begin-----------------*/
	public static char [] replaceSpace(char [] ch, int trueLength) {
		int spacecount = 0;
		for (int i=0; i<trueLength; i++)
			if (ch[i]==' ')
				spacecount++;
		int newLength = trueLength + (spacecount*2);
		ch[newLength--]='\0';
		for (int i=trueLength-1; i>=0; i--) {
			if (ch[i]==' ') {
				ch[newLength--]='0';
				ch[newLength--]='2';
				ch[newLength--]='%';
			}
			else
				ch[newLength--]=ch[i];
		}
		return ch;
	}
	/*------------------ Print Space: End-----------------*/
	
	/*------------------ Reverse String: Begin-----------------*/
	public static String reversedString(String str) {
		if (str.length()<=1)
			return str;
		else return str.charAt(str.length()-1) + reversedString(str.substring(0, str.length()-1));
	}
	/*------------------ Reverse String: End-----------------*/
	
	/*------------------ String Rotation: Begin-----------------*/
	//If lengths are not equal not a rotation, otherwise
	//Concatenate str2 with itself. If it contains str1 within, it is a rotation.
		public static boolean isStringRotation(String str1, String str2) {
			int length1 = str1.length();
			int length2 = str2.length();

			if (length1 != length2)
				return false;
			str2 = str2.concat(str2);
			return str2.contains(str1);
		}
	/*------------------ String Rotation: End-----------------*/
	
	/*------------------ Unique Characters String: 2 Approaches-----------------*/
		/*
		 * Using ArrayList data structure
		 * Complexity: n.logn if size of string is n (log n for searching done by contains method)
		 * Sorting the string and then comparing consecutive characters also has same complexity.
		 */
		public static boolean uniqueChar(String s) {
			boolean uniqueFlag = true;
			ArrayList<Character> strChar = new ArrayList<>();
			for (int i=0; i<s.length(); i++) {
				if (strChar.contains(s.charAt(i))) {
					uniqueFlag = false;
					break;
				}
				else
					strChar.add(s.charAt(i));
			}
			return uniqueFlag;
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
	/*------------------ Unique Characters String: End-----------------*/
	
	
	/*------------------ Print Char Array: Begin-----------------*/
	public static void printCharArray(char [] ch) {
		for (int i=0; i<ch.length; i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
	}
	/*------------------ Print Char Array: End-----------------*/

}
