package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2814 {

	static int n, m, answer;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			graph = new ArrayList[n + 1];
			visited = new boolean[n + 1];
			answer = 0;
			for (int j = 1; j <= n; j++)
				graph[j] = new ArrayList<>();

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}

			for (int j = 1; j <= n; j++) {
				visited[j] = true;
				dfs(j, 1);
				visited[j] = false;
			}

			System.out.println("#" + i + " " + answer);
		}

	}

	public static void dfs(int start, int length) {
		answer = Math.max(answer, length);

		for (int v : graph[start]) {
			// i번 노드와 연결되어 있는 노드들 가기
			if (!visited[v]) {
				visited[v] = true;
				dfs(v, length + 1);
				visited[v] = false;
			}
		}

	}

}
