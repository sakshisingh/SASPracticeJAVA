 /*
Given an array of n integers. each integer is in the range of 0 to m-1. and m > n.
The problem is to find the smallest number that is missing from the array.
*/

package interviewPrograms;

public class MissingNumber {

/***************************Solution 1 using linear search***************************/
	//Linear Search Complexity = n where n is size of array
	public static int linearSearch(int [] A, int m) {
		int missingNum=-1;
		for (int i=0; i< A.length-1; i++) {
			/*
			if (A[i]!=i) {
				missing_num = i;
				break;
			} */
			if (A[i+1]-A[i]>1) {
				missingNum = A[i]+1;
				break;
			}
		}
		if (A[A.length-1] < m && missingNum==-1)
			missingNum = A[A.length-1] + 1;
		return missingNum;
	}
	
/***************************Solution 2 using binary search***************************/
	//Binary Search Complexity = mlogn where n is size of array
	public static int binarySearchMissing(int [] A, int m) {
		int missingNum = -1;
		for (int i=0; i<m; i++) {
			//Binary search each number in the array
			missingNum = binarySearch(A, 0, A.length-1, i);
			if (missingNum!=-1)
				break;
		}
		if (A[A.length-1] < m && missingNum==-1)
			missingNum = A[A.length-1] + 1;
		return missingNum;
	}
	
	public static int binarySearch(int [] A, int low, int high, int m) {
		int mid = (low + high)/2;
		if (low > high)
			return m;
		if (A[mid] == m)
			return -1;
		else if (A[mid]<m)
			return binarySearch(A, mid+1, high, m);
		else
			return binarySearch(A, low, mid-1, m);
	}
	
/***************************Solution 3 using modified binary search***************************/
	//Works only if no duplicates.
	//Complexity = logn
	public static int modifiedBinarySearch(int [] A, int low, int high) {
		if (low > high)
			return high+1;
		if (A[low]!=low)
			return low;
		int mid = (low + high)/2;			
		if (A[mid]>mid)
			return modifiedBinarySearch(A, low, mid);
		else
			return modifiedBinarySearch(A, mid+1, high);
	}
	
	public static void main(String[] args) {
		int [] A = {0,1,2,3,4,5,7};
		int missingNum=linearSearch(A,7);
		System.out.println(" Linear Search Missing Number: " + (missingNum==-1?"None":missingNum));
		missingNum=binarySearchMissing(A, 7);
		System.out.println(" Binary Search Missing Number: " + (missingNum==-1?"None":missingNum));
		missingNum=modifiedBinarySearch(A, 0, A.length-1);
		System.out.println(" Modified Binary Search Missing Number: " + (missingNum==-1?"None":missingNum));
	}

}
