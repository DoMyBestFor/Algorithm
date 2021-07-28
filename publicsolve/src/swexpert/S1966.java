package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class S1966 {
/*
 * 추가적으로 퀵정렬을 직접 구현해보자
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			
			for(int j = 0; j < n; j++) {
				arr[j] = scan.nextInt();
			}
			
			Arrays.sort(arr);
			
			System.out.print("#" + i + " ");
			for(int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
	}

}
