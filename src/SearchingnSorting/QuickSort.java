/*
 * Quick Sort:
 * Select last element as pivot element
 * find partition as the correct place of pivot element such that 
 * all elements on left of pivot are less than equal to it and
 * all elements on right are greater than it.
 * quick sort on left to partition-1 and partition+1 to right.
 * 
 * Complexity: O(nlgn)
 */
package SearchingnSorting;

public class QuickSort {
	public static void quickSort(int [] A, int left, int right)
	{
		if (left < right) {
			int partition = partition(A, left, right);
			quickSort(A, left, partition-1);
			quickSort(A, partition+1, right);
		}
	}
	
	public static int partition(int [] A, int left, int right) {
		int temp, pivotElement = A[right];
		int partition = left;
		for (int i=left; i<right; i++) {
			if (A[i] <= pivotElement) {
				temp = A[partition];
				A[partition] = A[i];
				A[i] = temp;
				partition += 1;
			}
		}
		temp = A[partition];
		A[partition] = A[right];
		A[right] = temp;
		return partition;
	}
	
	//Sorting strings
	public static void quickSort(char [] A, int left, int right)
	{
		if (left < right) {
			int partition = partition(A, left, right);
			quickSort(A, left, partition-1);
			quickSort(A, partition+1, right);
		}
	}
	
	public static int partition(char [] A, int left, int right) {
		//char [] A = str.toCharArray();
		char temp, pivotElement = A[right];
		int partition = left;
		for (int i=left; i<right; i++) {
			if (A[i] <= pivotElement) {
				temp = A[partition];
				A[partition] = A[i];
				A[i] = temp;
				partition += 1;
			}
		}
		temp = A[partition];
		A[partition] = A[right];
		A[right] = temp;
		//str = A.toString();
		return partition;
	}
}
