package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solve{
	
	public static void main(String[] args) throws Exception{
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt(); // 테스트 케이스 수

		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < t; i++) {
			int n = scan.nextInt();
			int m = scan.nextInt();
			int[][] map = new int[n + 1][m + 1];
			int[][] dp = new int[n + 1][m + 1];
			ArrayList<Integer> list = new ArrayList<>();
			
			for(int x = 1; x <= n; x++) {
				for(int y = 1; y <= m; y++) {
					map[x][y] = scan.nextInt();
				}
			}
			
			for(int x = 1; x <= n; x++) {
				// 첫 번째 열은 그대로
				dp[x][1] = map[x][1];
			}
			
			// 두 번째 열부터는 왼쪽에서 더해질 수 있는 것 중에 가장 큰 것을 더한 값
			for(int y = 2; y <= m; y++) {
				for(int x = 1; x <= n; x++) {
					int left_down = 0;
					int left = 0;
					int left_up = 0;
					if(x-1 >= 1 && y-1 >= 1)
						left_down = dp[x-1][y-1];
					if(y-1 >= 1)
						left = dp[x][y-1];
					if(x+1 <= n && y-1 >= 1)
						left_up = dp[x+1][y-1];
					dp[x][y] = map[x][y] + max(left_down, left, left_up);
					
				}
			}
			
			for(int res = 1; res <= n; res++) {
				list.add(dp[res][m]);
			}
			Collections.sort(list);
			
			result.add(list.get(list.size()-1));
			
		}
		
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		
		
	}
		
	public static int max(int x, int y, int z) {
		int max_val = Integer.MIN_VALUE;
		
		max_val = Math.max(x, y);
		max_val = Math.max(max_val, z);
		
		return max_val;

	}
	
	
}
