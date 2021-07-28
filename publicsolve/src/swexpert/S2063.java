package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class S2063 {
	private static int n;
	// n은 항상 홀수로 주어진다.
	private static int[] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		
		arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr);
		
		System.out.println(arr[n / 2]);
	}
}
