package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B벽부수고이동하기 {
	/**
	 * 백준 2206번 
	 * 0은 이동할 수 있는 곳, 1은 벽이 있는 곳.
	 * 한 개의 벽을 부수고 이동하는 것이 더 이득이라면 한 개까지는 부술 수 있다.
	 * 벽을 부수고 방문했는지, 경로 중에 벽을 부순적이 있는지 두 가지를 추가로 판단해야함.
	 */
	static int N, M, answer;
	static int[][] map;
	static int[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static class Go{
		int x;
		int y;
		int cost;
		int broken;
		public Go(int x, int y, int cost, int broken) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.broken = broken;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			Arrays.fill(visited[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs();
		if(answer == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Go> queue = new LinkedList<>();
		queue.offer(new Go(0, 0, 1, 0));
		visited[0][0] = 0; // 벽 안부수고 방문했음
		
		while(!queue.isEmpty()) {
			Go go = queue.poll();
			int x = go.x;
			int y = go.y;
			int cost = go.cost;
			int broken = go.broken;
			
			if(x == N - 1 && y == M - 1) {
				answer = cost;
				//break; // 사실 방문처리 되어 있어서 다음 번에 다시 올 일 없음
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				
				if(visited[nx][ny] <= broken) // 방문했을때
					continue;
				
				if(map[nx][ny] == 0) {
					// 벽이 아닌 길이면 그냥 퍼트린다.
					visited[nx][ny] = broken;
					queue.offer(new Go(nx, ny, cost + 1, broken));
				}
				else if(map[nx][ny] == 1) {
					// 벽인 길이면 벽을 부술 수 있는지 확인하자.
					if(broken == 0) {
						// 벽을 부술 수 있으면 부수고 가보기
						visited[nx][ny] = 1;
						queue.offer(new Go(nx, ny, cost + 1, 1));
					}
					else {
						continue;
					}
				}
			}
		}
		
	}

}
