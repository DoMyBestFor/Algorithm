package code;

// 298페이지 문제.

import java.util.Scanner;

public class solve {
	private static int n; // 노드의 개수
	private static int m; // 연산의 횟수
	private static int[] parent; // 부모 테이블
	private static StringBuilder sb;
	
	public static int findParent(int[] parent, int x) {
		if(parent[x] != x) {
			parent[x] = findParent(parent, parent[x]);
		}
		return parent[x];
	}
	
	public static void unionParent(int[] parent, int a, int b) {
		a = findParent(parent, a);
		b = findParent(parent, b);
		if(a < b)
			parent[b] = a;
		else
			parent[a] = b;
	}
	
	public static void operator(int opt, int a, int b) {
		if(opt == 0) {
			unionParent(parent, a, b);
		}
		else if(opt == 1) {
			if(findParent(parent, a) == findParent(parent, b))
				sb.append("YES\n");
			else
				sb.append("NO\n");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		sb = new StringBuilder();
		n = scan.nextInt();
		m = scan.nextInt();
		parent = new int[n + 1];
		for(int i = 1; i <= n; i++)
			parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			int opt = scan.nextInt();
			int a = scan.nextInt();
			int b = scan.nextInt();
			
			operator(opt, a, b);
		}
		System.out.print(sb.toString());
	}
	
}
