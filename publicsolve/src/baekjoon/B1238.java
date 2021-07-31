package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1238 {
	static int n, m, x;
	static int max = Integer.MIN_VALUE;
	static List<Pos>[] graph;
	static int[] dist;
	static class Pos implements Comparable<Pos>{
		int end;
		int weight;
		public Pos(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Pos other) {
			return Integer.compare(this.weight, other.weight);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[a].add(new Pos(b, weight));
		}
		
		for(int i = 1; i <= n; i++) {
			int sum = 0;
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(i);
			sum += dist[x];
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dijkstra(x);
			sum += dist[i];
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
	public static void dijkstra(int start) {
		PriorityQueue<Pos> queue = new PriorityQueue<>();
		queue.offer(new Pos(start, 0));
		dist[start] = 0;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			if(dist[pos.end] < pos.weight) {
				continue;
			}
			for(Pos p : graph[pos.end]) {
				// a -> b 에서 b와 연결되는 곳들을 살펴보기
				if(dist[p.end] > dist[pos.end] + p.weight) {
					dist[p.end] = dist[pos.end] + p.weight;
					queue.offer(new Pos(p.end, dist[p.end]));
				}
			}
		}
	}

}
