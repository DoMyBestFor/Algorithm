package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1824 {
	/**
	 * SW 1824번 혁진이의 프로그램 검증 이동 방향에 따라 다음 문자로 이동한다. 처음에는 오른쪽으로 이동한다. 이동은 이어진다. 예를 들어
	 * 1 2 3 4 가 있을 때 4의 위치에서 오른쪽으로 간다면 1로 간다. 메모리가 단 하나 있으며 0에서 15 사이의 정수를 하나 저장할 수
	 * 있다. 처음에는 0이 저장되어 있다. <>^v -> 이동방향 _ -> 메모리에 0 저장 되어 있으면 오른쪽으로, 아니면 왼쪽으로 | ->
	 * 메모리에 0 저장 되어 있으면 아래쪽으로, 아니면 위쪽으로 ? -> 이동 방향을 상하좌우 무작위로 바꿈 . -> 아무것도 안해 @ ->
	 * 프로그램 정지 0 ~ 9 -> 메모리에 문자가 나타내는 값 저장. + -> 메모리에 저장된 값에 1을 더해. 만약 더하기 전 값이 15면
	 * 0으로 바꾼다. - -> 메모리에 저장된 값에 1을 뺀다. 만약 빼기 전 값이 0이라면 15로 바꾼다.
	 * 
	 * 이유를 모르겠다. dx dy 배열의 순서를 바꾸니까 된다.
	 * 
	 * @param args
	 */
	static int r, c;
	static boolean answer;
	static char[][] cmd;
	static boolean[][][][] visited;
	static int[] dx = { -1, 0, 1, 0 }; // 오른 왼 상 하
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			cmd = new char[r][c];
			visited = new boolean[r][c][4][16];
			answer = false;
			boolean tf = false;
			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int j = 0; j < c; j++) {
					cmd[i][j] = str.charAt(j);
					if (cmd[i][j] == '@') {
						tf = true;
					}
				}
			}
			if (tf) {
				dfs(0, 0, 1, 0); // (0, 0) 에서 시작해서 초기 방향은 1번 방향이고 메모리에는 0이 저장되어 있음
			}

			if (answer) {
				System.out.println("#" + tc + " " + "YES");
			} else {
				System.out.println("#" + tc + " " + "NO");
			}

		}
	}

	public static void dfs(int x, int y, int dir, int memory) {
		if (answer)
			return; // 찾았으면 그냥 종료

		if (cmd[x][y] == '@') {
			// 골뱅이에 도달하면 종료 가능
			answer = true;
			return;
		}

		if (visited[x][y][dir][memory])
			return; // 방문한 곳이면 종료. 똑같은 걸 반복한다는 의미이니까 어차피 안된다는 의미임

		visited[x][y][dir][memory] = true;
		
		int d = dir;
		int m = memory;

		if (cmd[x][y] == '>') {
			d = 1;
		} else if (cmd[x][y] == '<') {
			d = 3;
		} else if (cmd[x][y] == '^') {
			d = 0;
		} else if (cmd[x][y] == 'v') {
			d = 2;
		} else if (cmd[x][y] == '_') {
			d = memory == 0 ? 1 : 3;
		} else if (cmd[x][y] == '|') {
			d = memory == 0 ? 2 : 0;
		} else if (cmd[x][y] == '+') {
			m = (memory == 15 ? 0 : memory + 1);
		} else if (cmd[x][y] == '-') {
			m = (memory == 0 ? 15 : memory - 1);
		} else if (cmd[x][y] >= '0' && cmd[x][y] <= '9') {
			m = cmd[x][y] - '0';
		}

		if (cmd[x][y] == '?') {
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] < 0) {
					// 왼쪽으로 인덱스 벗어날 때
					dfs(r - 1, y + dy[i], i, m);
				} else if (x + dx[i] >= r) {
					// 오른쪽으로 인덱스 벗어날 때
					dfs(0, y + dy[i], i, m);
				} else if (y + dy[i] < 0) {
					// 위쪽으로 인덱스 벗어날 때
					dfs(x + dx[i], c - 1, i, m);
				} else if (y + dy[i] >= c) {
					// 아래쪽으로 인덱스 벗어날 때
					dfs(x + dx[i], 0, i, m);
				} else {
					dfs(x + dx[i], y + dy[i], i, m);
				}
			}
		} else {
			if (x + dx[d] < 0) {
				// 왼쪽으로 인덱스 벗어날 때
				dfs(r - 1, y + dy[d], d, m);
			} else if (x + dx[d] >= r) {
				// 오른쪽으로 인덱스 벗어날 때
				dfs(0, y + dy[d], d, m);
			} else if (y + dy[d] < 0) {
				// 위쪽으로 인덱스 벗어날 때
				dfs(x + dx[d], c - 1, d, m);
			} else if (y + dy[d] >= c) {
				// 아래쪽으로 인덱스 벗어날 때
				dfs(x + dx[d], 0, d, m);
			} else {
				dfs(x + dx[d], y + dy[d], d, m);
			}
		}

	}
}
