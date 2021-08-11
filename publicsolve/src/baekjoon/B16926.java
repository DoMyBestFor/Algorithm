package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B16926 {
	/**
	 * 백준 16926 배열돌리기 1
	 * 단계 수는 n과 m 중 작은 것을 2로 나눈 것이다. 6 X 5이면 2가 총 단계의 수이다.
	 * 각 단계의 시작점 (좌측상단)은 1,1 2,2 3,3 으로 나가게 된다.
	 * 시작점에서부터 우측 방향, 범위 벗어나면 아래 방향에서 값을 가져와 대입한다.
	 */
	static int n, m, r;
	static int[][] arr;
	static int[][] answer;
	
	static int[] dx = {0, 1, 0, -1}; // 우하좌상
	static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < r; i++) {
			 // r번 반복
			for(int j = 1; j <= Math.min(n / 2, m / 2); j++) {
				// j 단계에서 시작점
				int x = j;
				int y = j;
				int temp = arr[x][y]; // 임시 변수에 저장
				int dir = 0; // 방향
				
				while(dir < 4) {
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					if(nx < j || ny < j || nx > n-j+1 || ny > m-j+1)
						dir++;
					else {
						arr[x][y] = arr[nx][ny];
						x = nx;
						y = ny;
					}
						
				}
				arr[j+1][j] = temp;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
