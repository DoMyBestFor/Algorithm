package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4615 {
	/** A형 기출이라고 한다.
	 * SW 4615번 재미있는 오셀로 게임 돌을 놓을 수 없는 곳은 입력으로 주어지지 않는다고 가정
	 * 문제에서 주어진 x, y좌표와 배열에서 사용되는 행, 열은 서로 반대로 쓰임을 생각하자.
	 * 8방탐색임을 기억
	 * 검은돌 흰돌은 시작부터 2개로 시작함 주의
	 * 인덱스 체크 수시로 해줘야 하는 것 주의..
	 * 힘들었다
	 * @param args
	 */
	static int n, m;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0, -1, -1, +1, +1};
	static int[] dy = {0, 0, -1, 1, -1, +1, -1, +1};
	
	static int b, w;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 한 변의 길이
			m = Integer.parseInt(st.nextToken()); // 돌을 놓는 횟수
			map = new int[n + 1][n + 1];
			b = 2;
			w = 2;
			// 정가운데 배치하고 시작
			setStart();

			for (int i = 0; i < m; i++) {
				// m 번 돌을 놓을 거야
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int dol = Integer.parseInt(st.nextToken()); // 1 : 흑돌, 2 : 백돌
				if(dol == 1)
					b++;
				if(dol == 2)
					w++;
				
				// 게임 진행
				// 배열에서 행, 열이 문제에서 쓰인 x, y좌표와 반대인 점을 고려하자
				execute(y, x, dol);
			}
			
			System.out.println("#" + tc + " " + b + " " + w);
		} // 테스트 케이스 for문 끝

	} // 메인 함수 끝

	private static void setStart() {
		if (n == 4) {
			map[2][2] = 2;
			map[2][3] = 1;
			map[3][2] = 1;
			map[3][3] = 2;
		} else if (n == 6) {
			map[3][3] = 2;
			map[3][4] = 1;
			map[4][3] = 1;
			map[4][4] = 2;
		} else if (n == 8) {
			map[4][4] = 2;
			map[4][5] = 1;
			map[5][4] = 1;
			map[5][5] = 2;
		}
	}

	private static void execute(int x, int y, int dol) {
		if(dol == 1) {
			// 흑돌 놓기
			map[x][y] = 1;
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 1 || ny < 1 || nx > n || ny > n)
					continue;
				
				if(map[nx][ny] != 2) {
					// 옆에 먹을 흰 돌이 없으면 넘어가
					continue;
				}
				
				// 옆에 먹을 흰 돌이 있으면 검은 돌 찾을때까지 가보자
				while(nx >= 1 && ny >= 1 && nx <= n && ny <= n && map[nx][ny] == 2) {
					nx += dx[i];
					ny += dy[i];
				}
				
				if(nx < 1 || ny < 1 || nx > n || ny > n)
					continue;
				
				if(map[nx][ny] == 1) {
					// 검은돌을 찾아서 나온거라면
					nx -= dx[i];
					ny -= dy[i];
					int count = 0;
					while(nx != x || ny != y) {
						count++;
						map[nx][ny] = 1;
						nx -= dx[i];
						ny -= dy[i];
					}
				
					b += count; // 검은돌 개수 증가
					w -= count; // 흰돌 개수 감소
				}
			}
		
		} // 흑돌 놓기
		
		else if(dol == 2) {
			// 흰돌 놓기
			map[x][y] = 2;
			
			for(int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx < 1 || ny < 1 || nx > n || ny > n)
					continue;

				if(map[nx][ny] != 1) {
					// 옆에 먹을 검은 돌이 없으면 넘어가
					continue;
				}
				
				// 옆에 먹을 검은 돌이 있으면 흰 돌 찾을때까지 가보자
				while(nx >= 1 && ny >= 1 && nx <= n && ny <= n && map[nx][ny] == 1) {
					nx += dx[i];
					ny += dy[i];
				}
				
				if(nx < 1 || ny < 1 || nx > n || ny > n)
					continue;

				if(map[nx][ny] == 2) {
					// 흰돌을 찾아서 나온거라면
					nx -= dx[i];
					ny -= dy[i];
					int count = 0;
					while(nx != x || ny != y) {
						count++;
						map[nx][ny] = 2;
						nx -= dx[i];
						ny -= dy[i];
					}
					b -= count; // 검은돌 개수 증가
					w += count; // 흰돌 개수 감소
				}
			}
		}
	}

}
