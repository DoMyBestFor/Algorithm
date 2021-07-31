package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2817 {
	static int n, k;
	static int count;
	static int[] arr;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 수열 수
			k = Integer.parseInt(st.nextToken()); // 원하는 합의 수
			arr = new int[n];
			visited = new boolean[n];
			count = 0;
			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			System.out.println("#" + i + " " + count);
		}
		
	}
	
	public static void dfs(int start, int sum) {
		if(sum == k) {
			count++;
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				dfs(i+1, sum + arr[i]);
				visited[i] = false;
			}
		}
	}

}
