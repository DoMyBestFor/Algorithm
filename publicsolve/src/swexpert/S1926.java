package swexpert;

import java.util.Scanner;

public class S1926 {
	/*
	 * 정수를 String으로 바꾸는 법
	 * 정수에 + ""을 더하면 자동으로 String으로 바뀐다.
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			String str = i + "";
			for(int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
					count++;
				}
			}
			
			if(count == 0) {
				System.out.print(i + " ");
			}
			else {
				for(int cnt = 0; cnt < count; cnt++) {
					System.out.print("-");
				}
				System.out.print(" ");
				count = 0;
			}
		}
	}

}
