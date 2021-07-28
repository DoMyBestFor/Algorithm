package swexpert;

import java.util.ArrayList;
import java.util.Scanner;

public class S1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		for(int i = 1; i <= t; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int num = scan.nextInt();
			int[] div = new int[12]; 
			if(num % 2 == 0) {
				list.add(2);
			}
			if(num % 3 == 0) {
				list.add(3);
			}
			if(num % 5 == 0) {
				list.add(5);
			}
			if(num % 7 == 0) {
				list.add(7);
			}
			if(num % 11 == 0) {
				list.add(11);
			}
			
			while(num > 1) {
				for(int divider : list) {
					if(num % divider == 0) {
						num /= divider;
						div[divider]++;
					}
				}
			}
			
			System.out.print("#" + i + " ");
			System.out.println(div[2] + " " + div[3] + " " + div[5] + " " + div[7] + " " + div[11]);
		}
	}

}
