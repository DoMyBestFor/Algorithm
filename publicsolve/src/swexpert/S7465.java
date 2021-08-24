package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S7465 {
	/**
	 * SW 7465 창용 마을 무리의 개수
	 * 서로소 집합의 개수 구하기
	 * @param args
	 */
	
	static int[] parent;
	public static int findParent(int x) {
		if(parent[x] != x)
			parent[x] = findParent(parent[x]);
		
		return parent[x];
	}
	
	public static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		parent[b] = a;
	}
	
	static int N, M;
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 사람 수 (정점)
			M = Integer.parseInt(st.nextToken()); // 관계 수 (간선)
			set = new HashSet<>();
			
			parent = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a, b);
			}
			
			for(int i = 1; i <= N; i++) {
				findParent(i);
			}
			
			for(int i = 1; i <= N; i++) {
				set.add(parent[i]);
			}
			
			System.out.println("#" + tc + " " + set.size());
		}
	}

}
