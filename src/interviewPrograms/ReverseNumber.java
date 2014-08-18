package interviewPrograms;

public class ReverseNumber {
	public static int reverseNumber(int num) {
		int reverseNum = 0;
		while (num>0){
			reverseNum = reverseNum*10 + (num%10);
			num = num/10;
		}
		return reverseNum;
	}
	public static void main(String[] args) {
		int num = 541203;
		System.out.println("Number: " + num);
		System.out.println("Reversed Number: " + reverseNumber(num));
	}
}
