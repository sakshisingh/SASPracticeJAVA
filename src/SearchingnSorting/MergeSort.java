/*
 * Merge sort:
 * Break the array in 2 equal sub arrays --> left and right
 * Do this recursively until 1/2 elements in each sub array. then merge each sub array while sorting
 * Merge:
 * If left sub array is empty copy the right sub array
 * else if right sub array is empty copy the left sub array
 * else both the sub arrays have elements so compare first element of left sub array and of right sub array
 * copy the minimum of two and increment the index of that sub array.
 * 
 * Complexity: O(nlgn)
 */
package SearchingnSorting;

public class MergeSort {
	public static void mergeSort (int [] A, int low, int high) {
		//If there are more than 1 arrays
		if (low < high) {
			int mid = (low + high)/2;
			mergeSort(A, low, mid);
			mergeSort(A, mid+1, high);
			merge(A,low,mid,high);
		}
	}

	public static void merge(int [] A, int low, int mid, int high) {
		int n = high-low +1;		//Number of elements
		int [] temp = new int[n];	//Define an array of size n
		int j = low;
		int k = mid+1;
		for (int i=0; i<n; i++) {
			if (j>mid)		//No more elements on left side
				temp[i] = A[k++];
			else if (k>high)		//No more elements on right side
				temp[i] = A[j++];
			else if (A[j] < A[k])	//Check whether left side element is smaller or the right side.
				temp[i] = A[j++];
			else
				temp[i] = A[k++];
		}
		for (int i=0; i<n; i++) {
			A[low+i] = temp[i];
		}
	}
}
