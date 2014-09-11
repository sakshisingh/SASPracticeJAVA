package interviewPrograms;

public class AtoI {
	@SuppressWarnings("null")
	public static Integer atoi(String str) {
		int value = 0, sign = 1;
		if (!isNumber(str)) {
			System.out.println("String not a valid number format..." + str);
			return (Integer) null;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (i == 0) {
				if (ch == '-') {
					sign = -1;
					continue;
				}
			}
			if (i == str.length() - 1)
				value = (value + str.charAt(i) - '0');
			else
				value = (value + str.charAt(i) - '0') * 10;
		}
		return sign * value;
	}
	
	/*
	 * Private method to check if the string has all digits
	 */
	private static boolean isNumber(String str) {
		for (int i=0; i<str.length();i++) {
			if ((i==0)) {
					if ((str.charAt(i)<'0' || str.charAt(i)>'9') && (str.charAt(i)!='-'))
						return false;
			}
			else if ((str.charAt(i)<'0' || str.charAt(i)>'9'))
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String str = "12-3455";
		Integer value = atoi(str);
		System.out.println("String: " + str + "; Integer: " + value != null?"Invalid Number...":value);
	}

}
