package swexpert;

import java.util.Scanner;

public class S1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			String s = sc.next();
			int flag = 1;
			int startIdx = 0;
			int cnt = 0;
			
			// flag가 더이상 안찾아 질때까지
			while (s.indexOf(String.valueOf(flag), startIdx) != -1) {
				startIdx = s.indexOf(String.valueOf(flag), startIdx) + 1;
				flag = 1 - flag;
				cnt += 1;
			}
			System.out.printf("#%d %d\n", i, cnt);
		}
	}
	


}
