package interviewPrograms;

public class DecimalToBinary {

	public static String decimalToBinary(int num) {
		String binary="";
		while (num !=0) {
			binary = num%2 + binary;
			num=num/2;
		}
		return binary;
	}
	public static void main(String[] args) {
		int num=25;
		System.out.println("Decimal Number: " + num);
		System.out.println("Binary Number: " + decimalToBinary(num));
	}

}
