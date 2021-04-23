import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static int n;
	
	static class Con{
		int time;
		int pay;
		
		public Con(int time, int pay) {
			this.time = time;
			this.pay = pay;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		Con[] list = new Con[n];
		int[] dp = new int[n+1];
		int max = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int pay = Integer.parseInt(st.nextToken());
		
			list[i] = new Con(time, pay);
		}
		
		// dp[0] 은 0번째의 상담을 진행하고 마무리 지은 후 i번째에서 최대 페이를 얻는 수

		for(int i = n-1; i >= 0; i--) {
			int time = list[i].time + i;
			if(time <= n) { 
				// 상담 마친 후 시간이 범위를 초과하지 않으면
				dp[i] = Math.max(list[i].pay + dp[time], max);
				max = dp[i];
			}
			else {
				// 범위를 벗어나면
				dp[i] = max;
			}
		}
		
        System.out.println(dp[0]);
	}
	
	
}
