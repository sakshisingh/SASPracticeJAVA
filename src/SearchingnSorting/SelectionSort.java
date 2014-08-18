/*
 * Selection Sort:
 * In each iteration find the minimum element and place it at its correct position.
 * In first iteration, find minimum element from 0 to n-1 position and swap the element with element at first position
 * In ith iteration, find the minimum element from i to n-1 position and swap the element with ith element.
 * 
 *  Compelxity: O(n^2)
 */
package SearchingnSorting;

public class SelectionSort {
	public static void selectionSort(int [] A) {
		int size = A.length;
		int minPos, temp;
		for (int i=0; i<size; i++) {
			minPos=i;
			for (int j=i+1; j<size; j++) {
				if (A[j] < A[minPos])
					minPos = j;
			}
			if (minPos != i) {
				temp = A[i];
				A[i] = A[minPos];
				A[minPos] = temp;
			}
		}
	}
}
