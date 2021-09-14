package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5215_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken()); // 테케 수
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N + 1][2];
			
			for(int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				
				arr[i][0] = score; // 점수
				arr[i][1] = cal; // 칼로리
			}
			
			int[][] dp = new int[N + 1][L + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 0; j <= L; j++) {
					if(arr[i][1] <= j) {
						// 이 햄버거의 칼로리가 기준 칼로리를 초과하지 않으면
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i][1]] + arr[i][0]);
					}
					else {
						// 기준 칼로리 초과해서 먹을 수 없으면
						dp[i][j] = dp[i-1][j];
					}
				}
			}
			
			System.out.println("#" + tc + " " + dp[N][L]);
		}
		
	}

}
