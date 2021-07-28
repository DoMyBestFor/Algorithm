package code;

import java.util.Scanner;

public class solve {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		int minus = 0;
		int[] count = new int[m + 1];
		
		for(int i = 0; i < n; i++) {
			int num = scan.nextInt();
			count[num]++;
		}
		
		for(int i = 1; i <= m; i++) {
			if(count[i] > 1) {
				minus += (count[i] * (count[i] - 1)) / 2;
			}
		}
		
		System.out.println(((n * (n - 1)) / 2) - minus);
		
	}
}
