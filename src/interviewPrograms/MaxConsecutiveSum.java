/*
 * Input: An array on n elements, m where m<n
 * Output: Max sum of m consecutive numbers
 * Complexity = m + n - m = n
 */
package interviewPrograms;

public class MaxConsecutiveSum {
	public static int maxConsecutiveSum(int [] A, int m) {
		int sum = 0, maxSum = 0;
		for (int i=0; i<m; i++)
			sum += A[i];
		maxSum = sum;
		for (int i=m; i<A.length; i++) {
			sum = sum + A[i] -A[i-m];
			if (sum > maxSum)
				maxSum = sum;
		}
		return maxSum;
	}
	public static void main(String[] args) {
		int [] A = {3,15,2,7,3,9,8,1,8};
		System.out.println("Max Sum = " + maxConsecutiveSum(A, 3));
	}

}
