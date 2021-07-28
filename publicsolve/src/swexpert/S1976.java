package swexpert;

import java.util.Scanner;

public class S1976 {
	private static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		result = new int[2];
		
		for(int i = 1; i <= t; i++) {
			int hour_a = scan.nextInt();
			int min_a = scan.nextInt();
			
			int hour_b = scan.nextInt();
			int min_b = scan.nextInt();
			
			add(hour_a, min_a, hour_b, min_b);
			
			System.out.println("#" + i + " " + result[0] + " " + result[1]);
		}
	}

	public static void add(int hour_a, int min_a, int hour_b, int min_b) {
		
		if(hour_a + hour_b == 12 || hour_a + hour_b == 24) {
			result[0] = 12;
		}
		else{
			result[0] = (hour_a + hour_b) % 12;	
		}
		
		result[0] += (min_a + min_b) / 60;
		result[1] = (min_a + min_b) % 60;
	}
}
