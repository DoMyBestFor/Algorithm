package code;

import java.util.Arrays;
import java.util.Scanner;

public class solve {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] coin = new int[n];
		for(int i = 0; i < n; i++)
			coin[i] = scan.nextInt();
		Arrays.sort(coin);
		
		int target = 1;
		
		for(int i = 0; i < n; i++) {
			if(coin[i] > target)
				break;
			target += coin[i];
		}
		
		System.out.println(target);
		
	}
}
