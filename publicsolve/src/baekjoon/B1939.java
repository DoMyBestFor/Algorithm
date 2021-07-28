package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1939 {

	private static ArrayList<Node>[] graph;
	
	private static int n, m;
	private static int f1, f2;
	private static int start = Integer.MAX_VALUE;
	private static int end = Integer.MIN_VALUE;
	private static int answer;
	
	private static boolean[] visited;
	
	static class Node {
		int end;
		int weight;
		Node(int end, int weight){
			this.end =end ;
			this.weight = weight;
		}
	}
	/*
	 * 처음 생각 : BFS로 중량들을 업데이트 해 나가면서 f2 종점에서 Max값을 계속 갱신.
	 * 완전 탐색해야 하기 때문에 시간 줄일 방법은 이분탐색 뿐이다.
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[n+1];
		for(int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, weight));
			graph[b].add(new Node(a, weight));
			
			start = Math.min(start, weight);
			end = Math.max(end, weight);
		}
		st = new StringTokenizer(br.readLine());
		f1 = Integer.parseInt(st.nextToken());
		f2 = Integer.parseInt(st.nextToken());
		
		// 이 중량을 최대로 하면 가능 하냐?
		// 어떻게 확인? -> BFS
		// mid 보다 큰 간선만 쭉 따라가다가 f2 공장에 도달할 수 있으면 true
		binary_search(start, end);
		
		System.out.println(answer);
		
	}
	
	public static void binary_search(int start, int end) {
		while(start <= end) {
			int mid = (start + end) / 2;
			
			if(bfs(mid)) {
				// 이 중량을 최대로 하면 가능할 때
				// 더 늘려도 되는지 확인
				answer = mid;
				start = mid + 1;
			}
			else {
				// 불가능할 때
				// 더 줄여서 되는지 확인
				end = mid - 1;
			}
		}
	}
	
	public static boolean bfs(int mid) {
		visited = new boolean[n + 1];
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(f1); // f1에서 시작
		visited[f1] = true;
		
		while(!queue.isEmpty()) {
			// from -> to
			int from = queue.poll();
			
			for(Node a : graph[from]) {
				// a는 to에 해당
				if(a.weight >= mid) {
					// 경로가 mid보다 클때만 패스시켜주기
					if(from == f2) {
						// 성공적으로 마지막까지 도달했으면
						return true;
					}
					
					if(!visited[a.end]) {
						// 가는 곳이 방문 안 한 곳일때
						visited[a.end] = true;
						queue.add(a.end);
					}
				}
			}
		}
		// f2까지 도달하지 못하면
		return false;
	}

}
