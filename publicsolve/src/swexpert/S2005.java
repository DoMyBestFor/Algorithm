package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2005 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[][] arr = new int[n + 1][n + 1];

			arr[1][1] = 1;
			for (int a = 2; a <= n; a++) {
				for (int b = 1; b <= a; b++) {
					arr[a][b] = arr[a - 1][b - 1] + arr[a - 1][b];
				}
			}

			sb.append("#" + i + "\n");
			for (int a = 1; a <= n; a++) {
				for (int b = 1; b <= n; b++) {
					if (arr[a][b] != 0) {
						sb.append(arr[a][b] + " ");
					}
				}

				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}

}
