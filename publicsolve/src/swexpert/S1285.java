package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class S1285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int[] arr = new int[n];
			int count = 1;
			for(int j = 0; j < n; j++) {
				arr[j] = Math.abs(scan.nextInt());
			}
			Arrays.sort(arr);
			
			for(int j = 0; j < n-1; j++) {
				if(arr[j] != arr[j+1]) {
					break;
				}
				count++;
			}
			
			System.out.println("#" + i + " " + arr[0] + " " + count);
		}
	}

}
