package study.GreedyGraph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2021 {
	/**
	 * 백준 최소 환승 경로
	 * 출발지에서 목적지까지의 최소 환승 경로를 구하자. 환승 회수만 구하면 됨.
	 * @param args
	 */
	static int N, L;
	static int from, to;
	static Queue<Integer>[] lines;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 역의 개수
		L = Integer.parseInt(st.nextToken()); // 노선의 개수
		
		lines = new Queue[L];
		for(int i = 0; i < L; i++) {
			lines[i] = new LinkedList<>();
		}
		
		for(int i = 0; i < L; i++) {
			// 각 노선이 지나는 역이 순서대로 주어진다.
			st = new StringTokenizer(br.readLine());
			while(true) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1)
					break;
				
				lines[i].add(num);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken()); // 출발지
		to = Integer.parseInt(st.nextToken()); // 목적지
		
	}

}
