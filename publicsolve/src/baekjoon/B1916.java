package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
	private static int n, m;
	private static int from, to;
	private static ArrayList<Node>[] list;
	private static int[] dist;

	static class Node implements Comparable<Node>{
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node other) {
			// 오름차순
			return Integer.compare(this.end, other.end);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());

		dijkstra();
		System.out.println(dist[to]);
	}

	public static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(from, 0));
		dist[from] = 0;

		while (!pq.isEmpty()) {
			Node node = pq.poll();

			if (dist[node.end] < node.weight) {
				// 이미 살펴본 노드라면
				continue;
			}
			for (Node n : list[node.end]) {
				// 연결되어 있는 것들 중 가중치가 가장 작은것들부터 살펴보기
				if (dist[n.end] > dist[node.end] + n.weight) {
					// 최단거리 갱신
					dist[n.end] = dist[node.end] + n.weight;
					pq.offer(new Node(n.end, dist[n.end]));
				}

			}
		}

	}

}
