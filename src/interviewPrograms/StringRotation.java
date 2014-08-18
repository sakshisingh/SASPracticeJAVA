//Check if string 2 is a rotation of string 1
package interviewPrograms;

public class StringRotation {

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

	public static void main(String[] args) {
		String str1 = "bubble";
		String str2 = "blebbu";
		System.out.println("String 2: " + str2 + " is a rotation of String 1: "
				+ str1 + " :- " + isStringRotation(str1, str2));
	}
}
