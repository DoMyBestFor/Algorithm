package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149{
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[][] cost = new int[n][3];
		int[][] dp = new int[n][3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = cost[0][0]; // 첫번째 집 빨강 칠함
		dp[0][1] = cost[0][1]; // 첫번째 집 초록 칠함
		dp[0][2] = cost[0][2]; // 첫번째 집 파랑 칠함
		
		for(int i = 1; i < n; i++) {
			// i번째에 빨강을 칠함
			dp[i][0] = Math.min(dp[i-1][1] + cost[i][0], dp[i-1][2] + cost[i][0]);
			// i번째에 초록을 칠함
			dp[i][1] = Math.min(dp[i-1][0] + cost[i][1], dp[i-1][2] + cost[i][1]);
			// i번째에 빨강을 칠함
			dp[i][2] = Math.min(dp[i-1][0] + cost[i][2], dp[i-1][1] + cost[i][2]);
		}
		
		int answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
		System.out.println(answer);
	}
	
	
}