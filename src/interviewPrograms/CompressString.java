package interviewPrograms;

public class CompressString {

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
	
	public static void main(String[] args) {
		String str = "Hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhheeeeeeeeeeeeeeeeeeeeeeeeelllo";
		//String str = "Hello";
		System.out.println("Original String: " + str);
		System.out.println("Compressed String: " + compressedString(str));
		System.out.println("Original String: " + str);
		System.out.println("Compressed String: " + compressedStringArr(str));
	}
}
