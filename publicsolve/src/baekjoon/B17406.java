package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B17406 {
	/**
	 * 백준 17406 배열돌리기 4 N X M인 배열이 있다. 배열 A의 값은 각 행에 있는 모든 수의 합 중 최솟값을 의미 한다. 회전 연산
	 * (r, c, s) 가 주어지면 좌상단 (r-s, c-s) 우하단 (r+s, c+s)인 정사각형을 시계방향으로 한칸씩 돌린다.
	 * 
	 * @param args
	 */
	static int N, M, K;
	static int[][] arr;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static RCS[] rcss;
	static boolean[] visited;
	static List<Integer> ele;
	static int min = Integer.MAX_VALUE;

	static class RCS {
		int r;
		int c;
		int s;

		public RCS(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 행의 수
		M = Integer.parseInt(st.nextToken()); // 열의 수
		K = Integer.parseInt(st.nextToken()); // 회전 연산의 개수

		arr = new int[N + 1][M + 1];
		rcss = new RCS[K];
		ele = new ArrayList<>();
		visited = new boolean[K];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			rcss[i] = new RCS(r, c, s);
		}

		permutation(0);
		System.out.println(min);
	}

	public static void permutation(int count) {
		if (count == K) {
			rotate();
			return;
		}
		for (int i = 0; i < rcss.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ele.add(i);
				permutation(count + 1);
				ele.remove(ele.size() - 1);
				visited[i] = false;
			}
		}
	}

	public static void copyArray(int[][] copy) {
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				copy[i][j] = arr[i][j];
			}
		}		
	}
	
	public static void rotate() {
		int[][] copy = new int[N+1][M+1];
		
		copyArray(copy);
		int arrValue = Integer.MAX_VALUE;
		
		for(int i = 0; i < ele.size(); i++) {
			int r = rcss[ele.get(i)].r;
			int c = rcss[ele.get(i)].c;
			int s = rcss[ele.get(i)].s;
			
			//r-s, c-s 좌상단
			//r+s, c+s 우하단
			//단계는 s만큼 반복하겠다.
			for(int step = 0; step < s; step++) {
				// step 단계에서의 시작점 x, y
				int x = r-s + step; 
				int y = c-s + step;
				int temp = copy[x][y];				
				int dir = 0; // 방향
				
				while(dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx < r-s + step || ny < c-s + step || nx > r+s-step || ny > c+s-step ) {
						// 벗어나면 방향전환
						dir++;
					}
					else {
						// 안벗어나면
						copy[x][y] = copy[nx][ny];
						x = nx;
						y = ny;
					}
				
				}
				copy[r-s+step][c-s+step+1] = temp;
			} // for문 끝남
			
		} // outer for문 끝남
		
		for(int a = 1; a <= N; a++) {
			int sum = 0;
			for(int b = 1; b <= M; b++) {
				sum += copy[a][b];
			}
			arrValue = Math.min(arrValue, sum);
		}
		
		min = Math.min(min, arrValue);
		
	}
}
