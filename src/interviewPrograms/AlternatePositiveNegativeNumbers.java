package interviewPrograms;

public class AlternatePositiveNegativeNumbers {

	public static int [] arrangeNumbers(int [] in) {
		int inElements = in.length;
		int [] out = new int [inElements];
		int positiveIndex = 1, negativeIndex = 0;
		for (int i=0; i<inElements; i++) {
			if(in[i]<0) {
				out[negativeIndex] = in[i];
				if (negativeIndex+2 < inElements)
					negativeIndex = negativeIndex + 2;
				else
					negativeIndex = (positiveIndex + 2)>negativeIndex?positiveIndex + 2:negativeIndex+1;
			}
			else {
				out[positiveIndex] = in[i];
				if (positiveIndex+2 < inElements)
					positiveIndex = positiveIndex + 2;
				else 
					positiveIndex = (negativeIndex + 2)>positiveIndex?negativeIndex + 2:positiveIndex+1;
			}
		}
		return out;
	}
	
	public static void arrangeNumbers1(int [] in) {
		int inElements = in.length;
		int oddSwap = -1, evenSwap = -1;
		for (int i=0; i<inElements; i++) {
			if (oddSwap!=-1 || evenSwap!=-1) {
				oddSwap = oddSwap==-1?i:oddSwap;
				evenSwap = evenSwap==-1?i:evenSwap;
				int temp = in[oddSwap];
				in[oddSwap] = in[evenSwap];
				in[evenSwap] = temp;
				oddSwap = -1;
				evenSwap = -1;
			}
			if (oddSwap==-1 && in[i]<0 && i%2==1) {
				oddSwap = i;
			}
			if (evenSwap==-1 && in[i]>=0 && i%2==0) {
				evenSwap = i;
			}
			
		}
	}
	
	public static void printArray(int [] in) {
		System.out.println("Printing Array Elements:");
		for(int i=0; i< in.length; i++) {
			System.out.print(in[i] + "-->");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] in = {1, 2, 3, -4, -1, 4};
		printArray(in);
		arrangeNumbers1(in);
		printArray(in);
	}

}
