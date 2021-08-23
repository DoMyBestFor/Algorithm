package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15683 {
	/**
	 * 감시 문제. cctv의 유형 : 1번부터 5번까지 존재. cctv는 시계방향 90도로 회전이 가능하다. 사각지대의 최소 개수를 구해라.
	 * 
	 * @param args
	 */
	static int N, M;
	static int[] dx = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;
	static ArrayList<CCTV> list;
	static int answer = Integer.MAX_VALUE;

	static class CCTV {
		int what;
		int x;
		int y;

		public CCTV(int what, int x, int y) {
			this.what = what;
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		list = new ArrayList<>();

		int cntZero = N * M; // 초기 0의 개수
		// 0 : 빈칸, 1~5 : cctv 종류, 6 : 벽
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] != 0) {
					cntZero--;
				}
				if (map[i][j] >= 1 && map[i][j] <= 5) {
					list.add(new CCTV(map[i][j], i, j)); // CCTV 정보 저장
				}
			}
		}
		// 1번 CCTV 1 -> 2 -> 3 -> 0 4개
		// 2번 CCTV 3, 1 -> 0, 2 2개
		// 3번 CCTV 0, 1 -> 1, 2 -> 2, 3 -> 3, 0 4개
		// 4번 CCTV 3, 0, 1 -> 0, 1, 2 -> 1, 2, 3 -> 2, 3, 0 4개
		// 5번 CCTV 0, 1, 2, 3 1개
		dfs(0, cntZero);
		System.out.println(answer);
	}

	public static void dfs(int num, int cntZero) {
		if (num == list.size()) {
			answer = Math.min(answer, cntZero);
			return;
		}
		
		int[][] cp = new int[N][M];
		for(int i = 0; i < N; i++) {
			cp[i] = map[i].clone();
		}
		
		CCTV cctv = list.get(num);
		int x = cctv.x;
		int y = cctv.y;
		int[][] CCTVDir = getCCTVDir(cctv); // 그 cctv 가능한 방향 배열
		for (int i = 0; i < CCTVDir.length; i++) {
			int cnt = 0;
			for (int dir : CCTVDir[i]) {
				while (true) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];

					if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 6) {
						x = cctv.x;
						y = cctv.y;
						break;
					}
					
					if (map[nx][ny] == 0) { // 방문 안했을 때만
						map[nx][ny] = -1; // 방문 처리
						cnt++;
						x = nx;
						y = ny;
						continue;
					} else {
						x = nx;
						y = ny;
						continue;
					}
				}
			}
			
			dfs(num + 1, cntZero - cnt);
			
			for(int j = 0; j < N; j++) {
				map[j] = cp[j].clone();
			}
			
		}
	}

	public static int[][] getCCTVDir(CCTV cctv) {
		int w = cctv.what;
		if (w == 1)
			return new int[][] { { 1 }, { 2 }, { 3 }, { 0 } };
		if (w == 2)
			return new int[][] { { 3, 1 }, { 0, 2 } };
		if (w == 3)
			return new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
		if (w == 4)
			return new int[][] { { 3, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } };
		if (w == 5)
			return new int[][] { { 0, 1, 2, 3 } };

		return null;
	}

}
