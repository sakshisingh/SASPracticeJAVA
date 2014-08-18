/*
 * Insertion Sort:
 * Take an element and insert it at its correct position.
 * For array of size n
 * Take first element and find its position in array of size 1
 * Take second element and insert it at its correct position in array of size 2
 * Take nth element and insert it at its correct in array of size n-1.
 * Note: At any given point, while inserting nth element, array of size n-1 is already sorted.
 * 
 * Compelxity: O(n^2)
 */
package SearchingnSorting;

public class InsertionSort {

	public static int [] insertionSort (int [] A)
	{
		int i, j, key;
		int size = A.length;
		for (i=1; i<size; i++){
			key=A[i];
			for (j=i-1; j>=0 && A[j]>key; j--) {
				A[j+1] = A[j];
			}
			A[j+1] = key;
		}
		return A;
	}
}
