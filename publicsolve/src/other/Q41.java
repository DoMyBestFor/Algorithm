package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 이것이 코딩테스트다 Q41 실전문제 나의 풀이

public class solve {
	private static int n; // 도시의 수 (노드의 수)
	private static int m; // 여행 계획에 속한 노드의 수
	private static int[] parent;
	private static int[][] graph;
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1]; // 부모 테이블
		graph = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) // 부모 테이블 인덱스 값을 초기화
			parent[i] = i;
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= n; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 양방향 그래프이기 때문에 대칭성을 이용하여 대각선 기준 절반만 살펴보기
		for(int i = 1; i <= n; i++) {
			for(int j = i + 1; j <= n; j++) {
				if(graph[i][j] == 1)
					unionParent(parent, i, j);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int city = Integer.parseInt(st.nextToken());
		int root = parent[city];
		boolean check = true;
		for(int i = 1; i < m; i++) {
			city = Integer.parseInt(st.nextToken());
			if(root == parent[city])
				continue;
			else {
				check = false;
				break;
			}
		}
		
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
	}
  
	public static int findParent(int[] parent, int x) {
		if(parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}
  
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
  
}
