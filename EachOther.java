package code;

import java.util.Scanner;

public class solve {
	boolean cycle = false;
	
	public static int findParent(int[] parent, int x) {
		// 루트 노드가 아니면 루트 노드를 찾을 때까지 재귀 호출
    /*
    if(parent[x] != x)
      return find_parent(parent, parent[x]);
    return x;
    */
		if(parent[x] != x)
			parent[x] = findParent(parent, parent[x]);
		return parent[x];
	}
	public static void union_parent(int[] parent, int a, int b) {
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
			union_parent(parent, a, b);
		}
		
		// 각 원소가 속한 집합 출력
		System.out.print("각 원소가 속한 집합: ");
		for(int i  = 1; i <= v; i++) {
			System.out.print(findParent(parent, i) + " ");
		}
		System.out.println();
		
		System.out.print("부모 테이블: ");
		for(int i = 1; i <= v; i++) {
			System.out.print(parent[i] + " ");
		}
		
	}
	
}
