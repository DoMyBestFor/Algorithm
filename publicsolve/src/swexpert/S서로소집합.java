package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S서로소집합 {
	static int[] parents;
	
	public static int findParent(int x) {
		if(parents[x] != x)
			parents[x] = findParent(parents[x]);
		
		return parents[x];
	}
	
	public static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
			parents[a] = b;
		else
			parents[b] = a;
	}
	
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parents = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				parents[i] = i;
			}
			
			sb.append("#" + tc + " ");
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				if(a == 0) {
					union(b, c);
					continue;
				}
				
				if(a == 1) {
					if(findParent(b) == findParent(c))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
