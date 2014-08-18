package interviewPrograms;

public class EqualSumIndex {

	public static int equalSum(int [] A, int index, int indexDecrement, int indexIncrement) {
		if ((index<0) || (index>=A.length) || (indexDecrement==1 && indexIncrement==1)) 
			return -1;
		int leftSum = sum(A, 0, index);
		int rightSum = sum(A, index, A.length);
		if (leftSum==rightSum)
			return index;
		else{ 
			if (leftSum>rightSum)
				return equalSum(A, index-1, ++indexDecrement, indexIncrement);
			else 
				return equalSum(A, index+1, indexDecrement, ++indexIncrement);
		}
	}
	
	public static int sum(int []A, int low, int high) {
		int sum=0;
		for (int i=low; i<high; i++)
			sum+=A[i];
		return sum;
	} 
	
	public static void print(int []A, int low, int high) {
		for (int i=low; i<high; i++)
			System.out.print(A[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] A = {1,4,5};
		int midIndex = equalSum(A, A.length/2, 0, 0);
		if (midIndex==-1) {
			System.out.println("No such middle index to divide the array in equal sum sub arrays");
		}
		else {
			System.out.println("Middle Index = " + midIndex);
			System.out.print("Left Sub Array: ");
			print(A, 0, midIndex);
			System.out.print("Left Sub Array Sum= " + sum(A, 0, midIndex));
			System.out.println();
			System.out.print("Right Sub Array: ");
			print(A, midIndex, A.length);
			System.out.print("Right Sub Array Sum= " + sum(A, midIndex, A.length));
		}

	}

}
