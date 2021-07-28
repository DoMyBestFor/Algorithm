package swexpert;

import java.util.Scanner;

public class S1959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int answer = 0;
			int[] A = new int[n];
			int[] B = new int[m];
			
			for(int j = 0; j < n; j++) {
				A[j] = scan.nextInt();
			}
			for(int j = 0; j < m; j++) {
				B[j] = scan.nextInt();
			}
			
			if(n == m) {
				answer = cal(A, B, 0);
			}
			else if(n > m) {
				answer = cal(B, A, n-m);
			}
			else if(n < m) {
				answer = cal(A, B, m-n);
			}
			
			System.out.println("#" + i + " " + answer);
		}
	}
	public static int cal(int[] A, int[] B, int size) {
		// A 배열을 길이가 더 작은것으로 줘야함!
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i <= size; i++) {
			sum = 0;
			for(int j = 0; j < A.length; j++) {
				sum += A[j] * B[j+i];
			}
			max = Math.max(max, sum);
		}
		return max;
	}
}
