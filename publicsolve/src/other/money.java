
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] money = new int[n];
		int[] dp = new int[m + 1];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 0; i < n; i++) {
			int k = money[i];
			for(int j = k; j <= m; j++) {
				if(dp[j-k] != Integer.MAX_VALUE) {
					dp[j] = Math.min(dp[j], dp[j-k] + 1);
				}
			}
		}
		
		if(dp[m] == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(dp[m]);
		
	}

}
