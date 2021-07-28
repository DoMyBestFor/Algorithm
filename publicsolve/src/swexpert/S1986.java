package swexpert;

import java.util.Scanner;

public class S1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int result = 0;
			for(int j = 1; j <= n; j++) {
				if(j % 2 == 0) {
					// 짝수이면
					result -= j; 
					
				}
				else {
					// 홀수이면
					result += j;
				}
			}
			System.out.println("#" + i + " " + result);
		}

	}

}
