/*
 * Program: Find out duplicate number between 1 to N numbers.
 * Description: You have got a range of numbers between 1 to N, where one of the number is repeated.
 * You need to write a program to find out the duplicate number.
 * Complexity: O(nlgn + n)
 */
package interviewPrograms;

import java.util.ArrayList;

public class DuplicateNumbers {

	public static int checkDuplicate(int [] A) {
		int duplicate=-1;
		SearchingnSorting.MergeSort.mergeSort(A, 0, A.length-1);
		for (int i=0; i<A.length-1; i++) {
			if (A[i] == A[i+1]) {
				duplicate = A[i];
				break;
			}
		}
		return duplicate;
	}
	
	public static int findDuplicate(int [] A) {
		int duplicate=-1;
		ArrayList<Integer> copy = new ArrayList<>();
		for (int i=0; i<A.length; i++) {
			if (copy.contains(A[i])) {
				duplicate = A[i];
				break;
			}
			else copy.add(A[i]);
		}
		return duplicate;
	}
	
	public static void main(String[] args) {
		int [] A = {121,1,4,8,3,34,23,12,24,25,45,56,6};
		//int duplicate = checkDuplicate(A);
		int duplicate = findDuplicate(A);
		if (duplicate == -1)
			System.out.println("No duplicate");
		else
			System.out.println("Duplicate Number = " + duplicate);
	}

}
