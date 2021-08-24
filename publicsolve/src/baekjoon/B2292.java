package baekjoon;

import java.util.Scanner;

public class B2292 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		/*
		 * 1층 1개
		 * 2층 6개
		 * 3층 12개
		 * 4층 18개
		 * 5층 24개
		 */
		
		
		
		if(N == 1) {
			System.out.println(1);
			return;
		}
		if(N <= 7) {
			System.out.println(2);
			return;
		}
		
		int start = 7;
		int add = 12;
		int answer = 2;
		while(true) {
			start += add;
			add += 6;
			answer++;
			
			if(start >= N) {
				break;
			}
		}
		
		System.out.println(answer);
	}

}
