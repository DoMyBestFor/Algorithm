import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int n;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 삼각형의 크기
		int[][] triangle = new int[n][n]; // 삼각형
		int[][] dp = new int[n][n];
		int[] result = new int[n];
		
		for(int i = 0; i < n; i++)
			Arrays.fill(triangle[i], -1);
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = triangle[0][0];
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i + 1; j++) {
				int top = -1;
				int top_left = -1;
				if(j - 1 >= 0) {
					top_left = dp[i-1][j-1];
				}
				if(j < i) {
					top = dp[i-1][j];
				}
				dp[i][j] = triangle[i][j] + Math.max(top, top_left);
			}
		}
		
		for(int i = 0; i < n; i++) {
			result[i] = dp[n-1][i];
		}
		Arrays.sort(result);
		
		System.out.println(result[result.length -1]);
		
	}
	
	
}
