package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class B1697{
	/**
	 * 수빈이 위치 : 점 N
	 * 동생 위치 : 점 K
	 * 수빈이는 걷거 (+-1) 나 순간이동 (*2)
	 * 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇초 후일까?
	 * @param args
	 */
	static int N, K;
	static int answer;
	static boolean[] visited;
	static class Find{
		int curPos;
		int cnt;
		public Find(int curPos, int cnt) {
			super();
			this.curPos = curPos;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치
		visited = new boolean[100001];
		
		bfs();
		System.out.println(answer);
	}
	public static void bfs() {
		Queue<Find> queue = new LinkedList<>();
		queue.offer(new Find(N, 0));
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			Find find = queue.poll();
			
			if(find.curPos == K) {
				answer = find.cnt;
				break;
			}
			
			if(find.curPos + 1 <= 100000) {
				if(!visited[find.curPos + 1]) {
					visited[find.curPos + 1] = true;
					queue.offer(new Find(find.curPos + 1, find.cnt + 1));
				}
			}
			
			if(find.curPos - 1 >= 0) {
				if(!visited[find.curPos - 1]) {
					visited[find.curPos - 1] = true;
					queue.offer(new Find(find.curPos - 1, find.cnt + 1));
				}
			}
			
			if(find.curPos * 2 <= 100000) {
				if(!visited[find.curPos * 2]) {
					visited[find.curPos * 2] = true;
					queue.offer(new Find(find.curPos * 2, find.cnt + 1));
				}
			}
		}
		
	}
}