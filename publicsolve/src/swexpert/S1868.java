package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1868 {
	/**
	 * SW 1868 파핑파핑 지뢰찾기
	 * 팔방 탐색해서 근처 있는 지뢰 수를 표시.
	 * 지뢰 수가 0이라면 팔방에 있는 각 칸들에 지뢰 수를 표시
	 * 지뢰 제외한 칸의 모든 칸의 숫자들을 표시하려면 최소 몇 번의 클릭을 해야 하는가?
	 * @param args
	 */
	static int N;
	static char[][] map;
	
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, 1, -1};
	
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
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			
			int answer = 0;
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			// 먼저 0으로 퍼트릴 수 있는거 다 퍼트리고
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						if((char) (count(i, j) + '0') == '0') {
							answer++;
							map[i][j] = (char) (count(i, j) + '0');
							bfs(i, j);
						}
					}
				}
			}
			// 남은 거 처리하면 최소 클릭 수임.
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == '.') {
						answer++;
						map[i][j] = (char) (count(i, j) + '0');
					}
				}
			}
			
			System.out.println("#" + tc + " " + answer);
		} // 테스트 케이스 반복문 끝
		
	}
	
	public static int count(int x, int y) {
		int sum = 0;
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(map[nx][ny] == '*') {
				sum++;
			}
			
		}
		return sum;
	}
	public static void bfs(int x, int y) {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(x, y));
		
		while(!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for(int i = 0; i < 8; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				
				if(map[nx][ny] == '.') {
					map[nx][ny] = (char) (count(nx, ny) + '0');
					if(map[nx][ny] == '0') {
						queue.offer(new Pos(nx, ny));
					}
				}
			}
			
		}
	}

}
