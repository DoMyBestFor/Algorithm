package swexpert;

import java.util.Scanner;

public class S1948 {
	/*
	 * b - a + 1
	 * b와 a를 날짜 규칙에 따라 생성하는 것이 중요
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		for(int i = 1; i <= t; i++) {
			int month_a = scan.nextInt();
			int day_a = scan.nextInt();
			int month_b = scan.nextInt();
			int day_b = scan.nextInt();
			
			int A = cal(month_a - 1);
			int B = cal(month_b - 1);
			
			A += day_a;
			B += day_b;
			
			System.out.print("#" + i + " ");
			System.out.println(B-A+1);
			
		}
	}
	
	public static int cal(int month) {
		int[] count = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int sum = 0;
		for(int i = 0; i < month; i++) {
			sum += count[i];
		}
		
		return sum;
	}

}
