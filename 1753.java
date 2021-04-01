package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class solve {
	static class NodeInfo implements Comparable<NodeInfo>{
		int dist;
		int node;
		
		public NodeInfo(int dist, int node) {
			this.dist = dist;
			this.node = node;
		}
		
		@Override
		public int compareTo(NodeInfo temp) {
			return this.dist - temp.dist;
		}
		
	}
	
	static void dijkstra(ArrayList<NodeInfo>[] graph, int[] list, int start) {
		PriorityQueue<NodeInfo> queue = new PriorityQueue<>();
		NodeInfo nodeInfo = new NodeInfo(0, start);
		queue.offer(nodeInfo);
		list[start] = 0;
		
		while(!queue.isEmpty()) {
			 int nodeNum = queue.peek().node;
			 int nodeDist = queue.poll().dist;
			 int midDist = list[nodeNum]; 
			 
			 if(nodeDist > list[nodeNum]) 
				 continue;
			 
			 for(NodeInfo i : graph[nodeNum]){
				 int cost = midDist + i.dist;
				 if(cost < list[i.node]) {
					 list[i.node] = cost;
					 queue.offer(new NodeInfo(cost, i.node));
				 }
			 }
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int v = Integer.parseInt(st.nextToken()); // 정점 개수
		int e = Integer.parseInt(st.nextToken()); // 간선 개수
		st = new StringTokenizer(br.readLine());
		
		int start = Integer.parseInt(st.nextToken()); // 시작 노드 번호
		ArrayList<NodeInfo>[] graph = new ArrayList[v + 1]; // 간선 정보를 입력 받을 graph ArrayList
		for(int i = 0; i <= v; i++){
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < e; i++) { // 연결 관계 입력
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()); // 출발
			int to = Integer.parseInt(st.nextToken()); // 끝
			int weight = Integer.parseInt(st.nextToken()); // 가중치
			graph[from].add(new NodeInfo(weight, to));
		}
		for(int i = 1; i <= v; i++) {
			graph[i].add(new NodeInfo(0, i)); // 자기 자신으로 가는 가중치는 0
		}
		
		int[] list = new int[v + 1]; // 최단 경로 테이블 리스트
		Arrays.fill(list, 1000000); // 전부 무한으로 초기화
		 
		dijkstra(graph, list, start); // 다익스트라 알고리즘 수행
		
		for(int i = 1; i < list.length; i++) {
			if(list[i] == 1000000) { // 경로가 없으면 INF 출력
				System.out.println("INF");
			}
			else {
				System.out.println(list[i]);
			}
		}
		
		
		
	}

}
