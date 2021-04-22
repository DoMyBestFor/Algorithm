package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class solve{
	
	// 업그레이드 가능성 : Virus 클래스 자체에 time 변수를 넣어 queue 에서 빼낼때 time을 증가시켜주고
	// time이 s와 같아질 때 break 하는 방식으로 개선해보자.
	
	static int n, k, s, x, y;
	static int[][] labor;
	static PriorityQueue<Virus> pqueue;
	static Queue<Virus> queue; // 바이러스 위치와 번호를 관리하는 큐
	
	static class Virus implements Comparable<Virus>{
		int a;
		int b;
		int v;
		
		public Virus(int a, int b, int v) {
			this.a = a;
			this.b = b;
			this.v = v;
		}
		
		public int compareTo(Virus other) {
			return (this.v - other.v);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // N X N의 실험실
		k = Integer.parseInt(st.nextToken()); // 1~K 번까지의 바이러스
		labor = new int[n][n];
		pqueue = new PriorityQueue<>();
		queue = new LinkedList<>();
		
		// 바이러스의 위치 정보 저장
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				labor[i][j] = v;
				pqueue.offer(new Virus(i, j, v));
			}
		}
		
		while(!pqueue.isEmpty()) {
			queue.offer(pqueue.poll());
		}
		
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		// bfs로 작은 바이러스부터 퍼트린다~?
		bfs();
		
		System.out.println(labor[x-1][y-1]);
		
		
	}
	
	public static void bfs() {
		int time = 0;
		Queue<Virus>[] temp = new LinkedList[s+1];
		for(int i = 0; i <= s; i++)
			temp[i] = new LinkedList<>();
		
		temp[0] = queue;
		
		while(s != time) {
			while(!temp[time].isEmpty()) {
				Virus virus = temp[time].poll();
				int a = virus.a; // 행
				int b = virus.b; // 열
				int v = virus.v; // 번호
			
				if(a+1 < n && labor[a+1][b] == 0) {
					labor[a+1][b] = v;
					temp[time+1].offer(new Virus(a+1, b, v));
				}
				if(a-1 >= 0 && labor[a-1][b] == 0) {
					labor[a-1][b] = v;
					temp[time+1].offer(new Virus(a-1, b, v));
				}
				if(b+1 < n && labor[a][b+1] == 0) {
					labor[a][b+1] = v;
					temp[time+1].offer(new Virus(a, b+1, v));
				}
				if(b-1 >= 0 && labor[a][b-1] == 0) {
					labor[a][b-1] = v;
					temp[time+1].offer(new Virus(a, b-1, v));
				}
			}
			time++;
		}
	}
	
	
}
