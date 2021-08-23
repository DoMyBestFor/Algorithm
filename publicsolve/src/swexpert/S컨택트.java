package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S컨택트 {
	/**
	 * SW 컨택트
	 * 연락을 시작할때 가장 나중에 연락을 받게 되는 사람 중 번호가 가장 큰 사람을 구하는 문제
	 * @param args
	 */
	static int l, from;
	static ArrayList<Integer>[] graph;
	static int[] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;		
		for(int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken()); // 입력받는 데이터 길이
			from = Integer.parseInt(st.nextToken()); // 시작점
			
			graph = new ArrayList[101]; // 인접 리스트
			map = new int[101]; // 시작점에서 해당 노드에 연락할 때 거치는 횟수를 저장할 배열
			for(int i = 1; i < 101; i++) {
				graph[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < l / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				graph[a].add(b); // 방향 그래프
			}
			
			bfs();
			
			int max = Integer.MIN_VALUE;
			int answer = Integer.MIN_VALUE;
			for(int i = 1; i < 101; i++) {
				if(max <= map[i]) {
					max = map[i];
					answer = i;
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		
		}
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);
		
		while(!queue.isEmpty()) {
			int p = queue.poll();
			for(int to : graph[p]) {
				// 방문하지 않았다면 갱신
				if(map[to] == 0) {
					map[to] = map[p] + 1;
					queue.offer(to);
				}
				
			}
			
		}
	}

}
