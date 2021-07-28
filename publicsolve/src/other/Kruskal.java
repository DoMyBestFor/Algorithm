package code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solve {
	private static int v; // 노드의 개수
	private static int e; // 간선의 개수
	private static ArrayList<Line> graph; // 간선 리스트
	private static int[] parent;
	private static int sum = 0;
	
	public static int findParent(int[] parent, int idx) {
		if(parent[idx] != idx)
			parent[idx] = findParent(parent, parent[idx]);
		return parent[idx];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	static class Line implements Comparable<Line>{
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
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		v = scan.nextInt();
		e = scan.nextInt();
		graph = new ArrayList<>();
		parent = new int[v + 1];
		for(int i = 1; i <= v; i++)
			parent[i] = i;
		
		for(int i = 0; i < e; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			int c = scan.nextInt();
			graph.add(new Line(a, b, c));
		}
		
		Collections.sort(graph);
		
		for(int i = 0; i < e; i++) {
			// 루트 노드가 서로 다르면 사이클을 발생시키지 않는다. 따라서 최소 신장 트리에 삽입한다.
			if(findParent(parent, graph.get(i).start) != findParent(parent, graph.get(i).end)) {
				unionParent(parent, graph.get(i).start, graph.get(i).end);
				sum += graph.get(i).weight;
			}
		}
		
		System.out.println(sum);
		
	}
	
}
