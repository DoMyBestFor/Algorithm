package swexpert;

import java.util.Scanner;

public class S1970 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int t = scan.nextInt();
		int c50000 = 0, c10000 = 0, c5000 = 0, c1000 = 0, c500 = 0, c100 = 0, c50 = 0, c10 = 0;
		for (int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			
			c50000 = n / 50000;
			n = n % 50000;
			
			c10000 = n / 10000;
			n = n % 10000;
			
			c5000 = n / 5000;
			n = n % 5000;
			
			c1000 = n / 1000;
			n = n % 1000;
			
			c500 = n / 500;
			n = n % 500;
			
			c100 = n / 100;
			n = n % 100;
			
			c50 = n / 50;
			n = n % 50;
			
			c10 = n / 10;
			
			System.out.println("#" + i);
			System.out.println(c50000 + " " + c10000 + " " + c5000 + " " + c1000 + " " + c500 + " " + c100 + " " + c50 + " " + c10);
		}
	}

}
