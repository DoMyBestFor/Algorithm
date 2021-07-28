package swexpert;

import java.util.Arrays;
import java.util.Scanner;

public class S1984 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int[] arr = new int[10];
			int sum = 0;
			double avg = 0;
			for(int j = 0; j < 10; j++) {
				arr[j] = scan.nextInt();
			}
			
			Arrays.sort(arr);
			
			for(int j = 1; j < 9; j++) {
				sum += arr[j];
			}
			avg = sum / 8.0;
			
			System.out.printf("#%d %.0f\n", i, avg);
		}
	}

}
