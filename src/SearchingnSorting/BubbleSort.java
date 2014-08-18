/*
 * Bubble sort:
 * Compare each pair of consecutive elements and swap elements in correct sorting order.
 * At the end of 1 iteration, largest element is at its correct position. 
 * Repeat this n-1 times.
 * Optimize: Save a flag called swapping. Initially keep it false. 
 * Make it true if we need to swap any pair in correct order.
 * At the end of an iteration if it is sill false => All elements are in correct order.
 * 
 * Compelxity: O(n^2)
 */
package SearchingnSorting;

public class BubbleSort {
	public static void bubbleSort(int [] A) {
		int size = A.length;
		int temp;
		boolean swapFlag;
		for (int i=size-1; i>1; i--) {
			swapFlag = false;
			for (int j=0; j<i; j++) {
				if (A[j] > A[j+1]) {
					temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					swapFlag = true;
				}
			}
			if (!swapFlag)
				break;
		}
	}
}
