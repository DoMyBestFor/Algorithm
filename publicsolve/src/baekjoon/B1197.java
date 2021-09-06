package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class B1197 {

	static int V, E;
	static int[] parent;
	static ArrayList<Edge> list;
	static class Edge implements Comparable<Edge>{
		int a;
		int b;
		int weight;
		public Edge(int a, int b, int weight) {
			super();
			this.a = a;
			this.b = b;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static int findParent(int x) {
		if(x != parent[x]) {
			parent[x] = findParent(parent[x]);
		}
		return parent[x];
	}
	
	static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a < b)
			parent[a] = b;
		else
			parent[b] = a;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		list = new ArrayList<>();
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list.add(new Edge(a, b, weight));
		}
		Collections.sort(list); // 간선 가중치 기준 오름차순 정렬
		
		int answer = 0;
		
		for(int i = 0; i < list.size(); i++) {
			Edge edge = list.get(i);
			
			if(findParent(edge.a) != findParent(edge.b)) {
				union(edge.a, edge.b);
				answer += edge.weight;
			}
			
		}
		
		System.out.println(answer);
		
	}

}
