package SearchingnSorting;

public class Client {
	public static void printArray(int [] A) {
		for (int i=0; i<A.length; i++)
			System.out.print(A[i] + ", ");
		System.out.println();
	}
	
	public static void printArray(char [] A) {
		for (int i=0; i<A.length; i++)
			System.out.print(A[i] + ", ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		int [] A = {12,1,4,8,3,34,23,12,24,25,45,56,6};
		int [] B = {12,1,4,8,3,34,23,12,24,25,45,56,6};
		int [] C = {12,1,4,8,3,34,23,12,24,25,45,56,6};
		int [] D = {12,1,4,8,3,34,23,12,24,25,45,56,6};
		int [] E = {12,1,4,8,3,34,23,12,24,25,45,56,6};
		char [] str = {'a','c','d','b'};
		
		/*
		A = SearchingnSorting.InsertionSort.insertionSort(A);
		System.out.println("Insertion Sort Output: ");
		printArray(A);

		System.out.println("----------------------------------");
		SearchingnSorting.BubbleSort.bubbleSort(B);
		System.out.println("Bubble Sort Output: ");
		printArray(B);
		
		System.out.println("----------------------------------");
		SearchingnSorting.SelectionSort.selectionSort(C);
		System.out.println("Selection Sort Output: ");
		printArray(C);
		
		System.out.println("----------------------------------");
		SearchingnSorting.MergeSort.mergeSort(D, 0, D.length-1);
		System.out.println("Merge Sort Output: ");
		printArray(D);
		
		System.out.println("----------------------------------");
		SearchingnSorting.QuickSort.quickSort(E, 0, E.length-1);;
		System.out.println("Quick Sort Output: ");
		printArray(E);
		*/
		
		System.out.println("----------------------------------");
		SearchingnSorting.QuickSort.quickSort(str, 0, str.length-1);;
		System.out.println("Quick Sort Output: ");
		printArray(str);
	}
}
