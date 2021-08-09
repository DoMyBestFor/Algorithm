package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class S1249 {
	/**
	 * SW 1249번 보급로 칸마다 수리를 해나가면서 목적지에 도달하는 최소 경로 구하기 출발지는 좌상단, 도착지는 우하단
	 * - 출발점과 시작점 정해졌으니 다익스트라 쓰면 풀릴 것임
	 * - BFS로 풀려면 칸마다 최솟값 계속 갱신하면서 나가줘야 함. (answer 배열 테크닉)
	 * 기본 BFS 문제는 칸의 값이 모두 1아니면 0이었기 때문에 answer 배열이 필요 없었음.
	 * 
	 * @param args
	 */
	static int N; // 한 변의 길이
	static int[][] map; // 맵
	static int[][] answer; // 칸마다 최솟값을 갱신해주려면 map을 그대로 사용할 수 없기 때문에 answer배열 생성
	static boolean[][] visited; // 방문 체크
	static int[] dx = { -1, 1, 0, 0 }; // dx
	static int[] dy = { 0, 0, -1, 1 }; // dy

	static class Pos { // 좌표 클래스
		int x;
		int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			answer = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(answer[i], Integer.MAX_VALUE); // 최솟값 갱신해줄거니까~
			}
			answer[0][0] = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			bfs();
			System.out.println("#" + tc + " " + answer[N-1][N-1]);

		}

	}

	public static void bfs() {
		Queue<Pos> queue = new LinkedList<>();
		queue.offer(new Pos(0, 0));
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Pos pos = queue.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}

				if (!visited[nx][ny] || answer[nx][ny] > answer[pos.x][pos.y] + map[nx][ny]) {
					// 방문한 적 없거나 방문을 했지만 최솟값이 갱신되는 경우
					answer[nx][ny] = Math.min(answer[nx][ny], answer[pos.x][pos.y] + map[nx][ny]);
					visited[nx][ny] = true;
					queue.offer(new Pos(nx, ny));
				}
			}
		}
	}

}
