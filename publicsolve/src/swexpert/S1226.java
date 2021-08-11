package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1226 {
	/**
	 * SW 1226번 미로
	 * 16 * 16 배열의 미로가 있다. 1은 벽을 의미 하고 0은 길을 의미한다.
	 * 출발점에서 도착점까지 가는 경로가 존재하는지 판단 (2에서 3)
	 * bfs 돌려서 도착지점까지 방문하는지만 확인하면 됨.
	 * @param args
	 * @throws Exception
	 */
	
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static Pos start, end;
	
	static class Pos{
		int x;
		int y;
		public Pos() {
			
		}
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			map = new int[16][16];
			visited = new boolean[16][16];
			

			start = new Pos();
			end = new Pos();
			for(int i = 0; i < 16; i++) {
				String str = br.readLine();
				for(int j = 0; j < 16; j++) {
					map[i][j] = str.charAt(j) - '0';
					if(map[i][j] == 2) {
						start = new Pos(i, j);
					}
					if(map[i][j] == 3) {
						end = new Pos(i, j);
					}
				}
			}
			
			bfs(start.x, start.y);
			
			if(visited[end.x][end.y]) {
				System.out.println("#" + tc + " " + 1);
			}
			else {
				System.out.println("#" + tc + " " + 0);
			}
		}
		
	}
	
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			if(pos.x == end.x && pos.y == end.y) {
				break;
			}
			for(int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= 16 || ny >= 16 || visited[nx][ny])
					continue;
				
				if(map[nx][ny] == 0 || map[nx][ny] == 3) {
					visited[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}

}
