/*
 * Algorithm to concatenate 2 strings
 * Complexity: n+m where n,m are lengths of strings str1 and str2
 * Encoding of strings is done by concatenating each string in a way such that 
 * we pick one character from each string and then move to next character.
 * Decoding extracts the original two strings.
 */
package interviewPrograms;

public class ConcatenateStrings {
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
	
	public static void main(String[] args) {
		String str1 = "Helloallof";
		String str2 = "Worlded";
		System.out.println("String 1: " + str1 + " String 2: " + str2);
		System.out.println("Concatenated String: " + concatenate(str1, str2));
		System.out.println("Encoded String: " + encode(str1, str2));
		System.out.println("Decoded String: ");
		decode(encode(str1, str2), str1.length());
	}

}
