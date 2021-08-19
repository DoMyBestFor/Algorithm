package study.BFSDFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2468안전영역 {
	/** 
	 * 백준 안전영역 2468번
	 * 맵에 높이 정보가 주어진다.
	 * 비의 높이 이하인 지점은 모두 잠긴다.
	 * 잠기지 않는 안전한 영역의 개수의 최대값
	 * @param args
	 */
	static int N;
	static int answer = Integer.MIN_VALUE;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(max < map[i][j])
					max = map[i][j];
			}
		}
		
		for(int i = 0; i < max; i++) {
			// 비의 높이를 0에서부터 max-1까지 살펴보자
			int res = 0;
			visited = new boolean[N][N];
			for(int a = 0; a < N; a++) {
				for(int b = 0; b < N; b++) {
					if(map[a][b] > i && !visited[a][b]) {
						// 안 잠긴 곳만 시작점으로
						bfs(a, b, i);
						res++;
					}
				}
			}
			answer = Math.max(answer, res);
		}
		
		System.out.println(answer);
	}
	
	public static void bfs(int x, int y, int rain) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny])
					continue;
				
				if(map[nx][ny] > rain) {
					visited[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}

}
