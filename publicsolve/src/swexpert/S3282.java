package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S3282 {
	/**
	 * SW 3282번 0/1 Knapsack N번까지 번호 부여된 물건, 최대 k만큼 넣을 수 있는 가방 존재. 물건은 각각 부피 vi와 가치
	 * ci를 가진다. 이 물건들을 가방에 넣어서 그 가치 합을 최대화 시키려고 한다. 그 최대 가치를 출력하자. 시간 초과 : 조합으로 풀면 안 돼
	 * 
	 *	dp로 접근하자.
	 *	dp[i][j] -> i 번 물건을 넣는데 j 부피의 가방에 넣을 때의 최대 가치
	 *	i번째 물건의 부피가 j 초과면 못 넣으니까 dp[i-1][j]의 값을 넣자.
	 *	넣을 수 있으면 dp[i-1][j]와 dp[i-1][j - i번째 물건 부피] + i번째 물건 가치 비교
	 * 
	 * @param args
	 */

	static int n, k;
	static int[][] list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 물건의 개수
			k = Integer.parseInt(st.nextToken()); // 가방의 부피
			
			list = new int[n+1][2]; // 물건의 부피와 가치를 저장 할 거야.
			int[][] dp = new int[n + 1][k + 1];
			// dp[i][k] : i 번 물건을 넣고 k만큼의 부피를 넣었을 때의 최대 가치
			for(int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				// 물건의 부피와 가치들
				list[i][0] = Integer.parseInt(st.nextToken());
				list[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i <= k; i++) {
				// 아무것도 안 넣었을 때.
				dp[0][i] = 0;
			}
			
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j <= k; j++) {
					if(list[i][0] > j) {
						// 물건의 부피가 j 보다 커서 못넣는 경우
						dp[i][j] = dp[i-1][j]; // 이전 dp
					}
					else {
						// 넣을 수 있으면 넣은 거랑 이전 dp랑 비교
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - list[i][0]] + list[i][1]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + dp[n][k]);
			
		}

	}
}
