package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1979 {
	private static int t, n, k;
	private static int[][] puzzle;

	private static int count = 0;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		t = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 맵 크기
			k = Integer.parseInt(st.nextToken()); // 단어 길이
			// 못 쓰는 곳 0, 쓸 수 있는곳 1
			count = 0;
			puzzle = new int[n][n];

			for (int a = 0; a < n; a++) {
				st = new StringTokenizer(br.readLine());
				for (int b = 0; b < n; b++) {
					puzzle[a][b] = Integer.parseInt(st.nextToken());
				}
			}

			for (int a = 0; a < n; a++) {
				for (int b = 0; b < n; b++) {
					count += acceptable(a, b);
				}
			}
			System.out.println("#" + i + " " + count);
		}
	}

	public static int acceptable(int a, int b) {
		int cnt = 0;
		int down = 0, right = 0;

		if (puzzle[a][b] == 0) {
			return 0;
		}

		for(int i = 0; i < k; i++) {
			if(a+i < n && puzzle[a+i][b] == 1) {
				down++;
			}
			if(b+i < n && puzzle[a][b+i] == 1) {
				right++;
			}
		}

		if(down == k) {
			cnt++;
			if((a - 1 >= 0 && puzzle[a-1][b] == 1) || (a + k < n && puzzle[a + k][b] == 1)) {
				// k 길이 이상으로 뚫려 있으면
				cnt--;
			}
	
		}
		if(right == k) {
			cnt++;
			if((b - 1 >= 0 && puzzle[a][b-1] == 1) || (b + k < n && puzzle[a][b + k] == 1)) {
				cnt--;
			}
		}
		return cnt;
	}

}
