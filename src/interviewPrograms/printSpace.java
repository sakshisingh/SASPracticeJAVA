/*
 * Replace all strings in a string with '%20'
 * Assume that the string has sufficient space at the end of string to hold the additional characters
 * and you are given the true length of the string.
 */
package interviewPrograms;

public class printSpace {
	
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

	public static void printCharArray(char [] ch) {
		for (int i=0; i<ch.length; i++) {
			System.out.print(ch[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		char[] ch = new char[15];
		ch[0]=' ';ch[1]=' ';ch[2]=' ';ch[3]='h';ch[4]='e';ch[5]='e';
		System.out.println("Original Array: ");
		printCharArray(ch);
		System.out.println("New Array: ");
		printCharArray(replaceSpace(ch,6));
		
	}

}
