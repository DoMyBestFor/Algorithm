package code;

import java.util.Scanner;

public class solve {
	private static boolean cycle = false;
	
	public static int findParent(int[] parent, int x) {
		// 루트 노드가 아니면 루트 노드를 찾을 때까지 재귀 호출
		if(parent[x] != x)
			parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a); // a의 루트 노드를 찾아
		b = findParent(parent, b); // b의 루트 노드를 찾아
		
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int v = scan.nextInt();
		int e = scan.nextInt();
		int[] parent = new int[v + 1];
		
		for(int i = 1; i <= v; i++)
			parent[i] = i;
		
		for(int i = 0; i < e; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			// 사이클이 발생한 경우 
			if(findParent(parent, a) == findParent(parent, b)) {
				cycle = true;
				break;
			}
			// 발생하지 않은 경우 union
			else {
				unionParent(parent, a, b);
			}
		}
		
		if(cycle)
			System.out.print("사이클입니다.");
		else
			System.out.print("사이클이 아닙니다.");
		
		
	}
	
}
