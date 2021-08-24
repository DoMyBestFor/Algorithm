package study.GreedyGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	
	static int V, E, from;
	static int[] dist;
	
	static List<Node>[] graph;
	static class Node implements Comparable<Node>{
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		V = Integer.parseInt(st.nextToken()); // 정점 개수
		E = Integer.parseInt(st.nextToken()); // 간선 개수
		
		graph = new ArrayList[V + 1];
		for(int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
		}
		
		from = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, w)); // 방향 그래프
		}
		
		dijkstra();
		
		for(int i = 1; i < dist.length; i++) {
			if(dist[i] == 99999999) {
				sb.append("INF\n");
			}
			else {
				sb.append(dist[i] + "\n");
			}
		}
		
		System.out.println(sb.toString());
	}
	
	public static void dijkstra() {
		dist = new int[V + 1];
		Arrays.fill(dist, 99999999);
		dist[from] = 0;
		
		// 간선 중 가장 가중치가 작은 것부터 보려고
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.weight > dist[node.end]) {
				// 최솟값 갱신 될 일이 없으니 볼 필요 없음
				continue;
			}
			
			for(Node next : graph[node.end]) { // node와 연결된 곳을 볼거야.
				if(dist[next.end] > node.weight + next.weight) { // node를 경유해서 next로 갈지, next로 바로 갈지
					dist[next.end] = node.weight + next.weight;
					pq.offer(new Node(next.end, dist[next.end]));
				}
			}
		}
		
	}

}
