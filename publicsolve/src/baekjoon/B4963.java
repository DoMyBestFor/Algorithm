package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B4963 {
	/**
	 * 백준 섬의 개수
	 * 섬의 개수를 구하자.
	 */
	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	
	static class Pos{
		int x;
		int y;
		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0)
				break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			// 땅 : 1, 바다 : 0
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						bfs(i, j);
						count++;
					}
				}
			}
			
			System.out.println(count);
			
		}
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= h || ny >= w) {
					continue;
				}
				
				if(!visited[nx][ny] && map[nx][ny] == 1) {
					visited[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
				
			}
		}
	}

}
