package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][n];
			int sum = 0;
			for (int a = 0; a < n; a++) {
				st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				for (int b = 0; b < n; b++) {
					map[a][b] = str.charAt(b) - '0';
				}
			}

			for (int j = 0; j < n / 2; j++) {
				for (int k = 1; k <= j; k++) {
					sum += map[n / 2 - k][j];
					sum += map[n / 2 + k][j];
				}
			}
			for (int j = n - 1; j >= n / 2; j--) {
				for (int k = 1; k < n - j; k++) {
					sum += map[n / 2 - k][j];
					sum += map[n / 2 + k][j];
				}
			}
			
			for(int j = 0; j < n; j++) {
				sum += map[n/2][j];
			}
			System.out.println("#" + i + " " + sum);
		}

	}

}
