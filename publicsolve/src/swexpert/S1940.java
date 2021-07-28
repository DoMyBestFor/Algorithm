package swexpert;

import java.util.Scanner;

public class S1940 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			int start = 0;
			int dist = 0;
			
			for(int j = 0; j < n; j++) {
				int menu = scan.nextInt();
				if(menu == 0) {
					dist += start;
				}
				else if(menu == 1) {
					start += scan.nextInt();
					dist += start;
				}
				else if(menu == 2) {
					start -= scan.nextInt();
					if(start < 0) {
						start = 0;
					}
					dist += start;
				}
			}
			
			System.out.println("#" + i + " " + dist);
		}
	}

}
