package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class B1260{
	
	private static int N, M, start;
	private static ArrayList<Integer>[] graph;
	private static boolean[] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for(int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			// 주어지는 간선은 양방향
			graph[a].add(b);
			graph[b].add(a);
		}
		
		// 작은 정점부터 방문해야 함
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(start);
		System.out.println();
		bfs();
		
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		System.out.print(start + " ");
		for(int n : graph[start]) {
			if(visited[n] == false) {
				dfs(n);
			}
		}
		
	}
	public static void bfs() {
		visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int element = queue.poll();
			
			if(visited[element] == false) {
				visited[element] = true; // 방문했음
				System.out.print(element + " ");
				
				for(int n : graph[element]) {
					queue.offer(n);
				}
			}
		}
		
	}
}