package interviewPrograms;

public class BitManipulation {

	public static int countOnes(Integer num) {
		int count=0;
		String binString = Integer.toBinaryString(num);
		for (int i=0; i<binString.length();i++) {
			if (binString.charAt(i)=='1')
				count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Integer num = 42342420;
		System.out.println("Number of 1's in " + num + "(Binary: " + Integer.toBinaryString(num) + ") = " + countOnes(num));
	}

}
