package code;

// 리팩토링 버전2

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solve{
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, +1, 0, 0};
	static int[] dy = {0, 0, -1, +1};

	
	static class Pos{
		int xpos;
		int ypos;
		public Pos(int xpos, int ypos) {
			this.xpos = xpos;
			this.ypos = ypos;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0, 0);
		System.out.println(map[n-1][m-1]);
		
	}
	
	public static void bfs(int xpos, int ypos) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(xpos, ypos)); // 시작 노드를 넣음
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			int x = pos.xpos;
			int y = pos.ypos;
			
			for(int i = 0; i < 4; i++) {
				// 상하좌우를 모두 살펴 갈 수 있는 곳인지 확인
				int new_x = x + dx[i];
				int new_y = y + dy[i];
				
				if(new_x < 0 || new_x >= n || new_y < 0 || new_y >= m) {
					// 인덱스를 벗어나면 갈 수 없음
					continue;
				}
				
				if(map[new_x][new_y] == 0) {
					// 괴물이 있으면 갈 수 없음.
					continue;
				}
				
				if(map[new_x][new_y] == 1) {
					// 괴물이 없으면 갈 수 있음, 처음 방문하는 경우 최단거리 기록
						map[new_x][new_y] = map[x][y] + 1; // 경로 하나 증가시킴
						queue.offer(new Pos(new_x, new_y));
				}
				
			}
		}
		
	}
	
}
