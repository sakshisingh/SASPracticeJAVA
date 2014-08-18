package interviewPrograms;

import java.util.Arrays;
public class MatrixManipulation {

/*
	//Problem: Rotate NxN matrix by 90 degrees
	public static void rotate(int [][] A, int n) {
		for (int layer=0; layer<n/2; layer++){
			int first=layer;
			int last=n-1-layer;
			for (int i=first; i<last; i++) {
				int offset=i-first;
				int top = A[first][i];
			}
		}	
	}
*/
	
	//Problem: If an element in MxN matrix is 0, clear all elements in it row and column to 0
	/*-------------Solution 1: Keeping another matrix----------------*/
	//If an element in MxN matrix is 0, clear all elements in it row and column to 0
	public static int[][] clearData(int [][] A, int r, int c) {
		//We need to do deep copy as we will be manipulating matrix A.
		//There is no method available for deep copy, so we need to implement deep copy 
		//or loop through copying each row
		int [][] B = new int[r][c];
		for (int i=0;i<r;i++)
			B[i]=Arrays.copyOf(A[i], A[i].length);
		
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				if (A[i][j]==0)
					clear(B,r,c,i,j);
		return B;
	}
	public static void clear(int [][] A, int r, int c, int i, int j) {
		for (int k=0; k<r || k<c; k++) {
			if (k<r)
				A[k][j]=0;
			if (k<c)
				A[i][k]=0;
		}
	}
	
	//Problem: If an element in MxN matrix is 0, clear all elements in it row and column to 0
	/*-----Solution 2: Keeping track of rows and columns having zero and then making each element in that row/column = 0------*/
	public static void clearDataArr(int [][] A, int r, int c) {
		int [] row = new int[r];
		int [] col = new int[c];
		
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				if (A[i][j]==0) {
					row[i] = 1;
					col[j] = 1;
				}
		for (int i=0; i<r; i++)
			for (int j=0; j<c; j++)
				if (row[i]==1 || col[j]==1)
					A[i][j]=0;
	}
	
	public static void printMatrix(int[][] A, int r, int c) {
		for (int i=0; i<r; i++){
			for (int j=0; j<c; j++)
				System.out.print(A[i][j] + "  ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int [][]A = {{1,0,1,2,3,7},{4,5,6,2,0,7},{54,23,12,68,12,34},{54,23,12,68,12,34}};
		printMatrix(A, 4, 6);
		int [][] B =  clearData(A, 4, 6);
		System.out.println("----------------------");
		printMatrix(B, 4, 6);
		System.out.println("----------------------");
		printMatrix(A, 4, 6);
		System.out.println("----------------------");
		clearDataArr(A, 4, 6);
		printMatrix(A, 4, 6);
	}
}
