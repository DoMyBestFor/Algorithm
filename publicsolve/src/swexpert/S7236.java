package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S7236 {
	
	/**
	 * N x N의 맵에서 저수지의 물(W)의 총 깊이를 구하려 한다.
	 * 물의 깊이는 구획을 애워싼 영역에 땅이 있으면 그 땅을 뺀 합이 그 구획의 물의 깊이이다.
	 * 근데 모든 영역이 땅이면 깊이는 1이다.
	 * 물의 총 깊이는 각 구획의 깊이 중 가장 깊은 구획이 총 깊이이다.
	 * @param args
	 */
	static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			char[][] map = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 'W') {
						max = Math.max(max, deep(map, i, j));
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
		
	}
	
	public static int deep(char[][] map, int x, int y) {
		int N = map.length;
		int count = 0;
		for(int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(map[nx][ny] == 'W')
				count++;
		}
		if(count == 0)
			return 1;
		else
			return count;
	}

}
