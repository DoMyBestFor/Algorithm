package swexpert;

import java.util.Scanner;

public class S1288 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			String str = scan.next();
			String n = str;
			
			int count = 10;
			int answer = 0;
			int multi = 2;
			int[] num = new int[10];
			while(count > 0) {
				answer = Integer.parseInt(n);
				for(int j = 0; j < n.length(); j++) {
					if(num[n.charAt(j) - '0'] == 0) {
						num[n.charAt(j) - '0']++;
						count--;
					}
				}
				int number = Integer.parseInt(str) * multi;
				multi++;
				n = number + "";
			}
			System.out.println("#" + i + " " + answer);
			
		}
	}

}
