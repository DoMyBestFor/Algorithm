import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int n; // 노드의 개수
	private static int m; // 간선의 개수
	private static int[] parent; // 부모 테이블
	private static ArrayList<Integer> edges; // 최소 신장 트리 간선 정보
	private static ArrayList<Line> list; // 간선의 정보 리스트
	
	private static class Line implements Comparable<Line>{
		int start;
		int end;
		int weight;
		
		public Line(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Line line) {
			return this.weight - line.weight;	
		}
	}

	private static int findParent(int[] parent, int x) {
		if(parent[x] != x)
			parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	
	private static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	private static void kruskal() {
		int sum = 0;
		
		for(int i = 0; i < m; i++) {
			Line line = list.get(i);
			if(findParent(parent, line.start) != findParent(parent, line.end)) { 
				unionParent(parent, line.start, line.end);
				edges.add(line.weight);
			}
		}
		Collections.sort(edges);
		edges.remove(edges.size() - 1);
		
		for(int i = 0; i < edges.size(); i++)
			sum += edges.get(i);
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n + 1];
		list = new ArrayList<>();
		edges = new ArrayList<>();
		
		for(int i = 1; i <= n; i++)
			parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			list.add(new Line(start, end, weight));
		}
		Collections.sort(list); // 가중치 기준 오름차순으로 정렬
		kruskal();
		
	}
}
