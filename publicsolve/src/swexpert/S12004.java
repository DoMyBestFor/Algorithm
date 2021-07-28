package swexpert;

import java.util.Scanner;

public class S12004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		outer : for(int i = 1; i <= t; i++) {
			int n = scan.nextInt();
			
			for(int a = 1; a <= 9; a++) {
				if(n % a == 0 && 1 <= n / a && n / a <= 9) {
					// a로 나눠 봤는데 나누어 떨어짐과 동시에 그 몫이 한자리 수이면 Yes
					System.out.println("#" + i + " " + "Yes");
					continue outer;
				}
			}
			System.out.println("#" + i + " No");
		}
	}

}
