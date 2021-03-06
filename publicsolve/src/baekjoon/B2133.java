package code;

import java.util.Scanner;
public class solve{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] dp = new int[n+1];
		if(n > 1 && n % 2 == 0) {
			dp[0] = 1; dp[2] = 3;
			
			for(int i = 4; i < n+1; i+=2) {
				dp[i] = dp[2]*dp[i-2];
				for(int j = 4; j <= i; j+=2)
					dp[i] += 2*dp[i-j];
			}
		}
		System.out.println(dp[n]);
	}
}
