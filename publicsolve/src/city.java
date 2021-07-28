package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class solve {
	private static final int INF = 10000000;
	private static int n;
	private static int m;
	private static int x;
	private static int k;
	private static int[][] graph;
		
	private static void floydWarshall() {
		for(int i = 1; i <= n; i++)
			for(int a = 1; a <= n; a++)
				for(int b = 1; b <= n; b++)
					graph[a][b] = Math.min(graph[a][b], graph[a][i] + graph[i][b]);
	}
		
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 회사의 수
		m = Integer.parseInt(st.nextToken()); // 경로의 수
		graph = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
			Arrays.fill(graph[i], INF);
		for(int i = 1; i <= n; i++)
			graph[i][i] = 0;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			graph[start][end] = 1;
			graph[end][start] = 1;
		}
		
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		floydWarshall();
		
		if(graph[1][k] + graph[1][x] >= INF)
			System.out.println(-1);
		else
			System.out.println(graph[1][k] + graph[1][x]);
		
	}
}
