package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10163 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] map = new int[1001][1001];
		int N = Integer.parseInt(st.nextToken()); // 색종이 수
		int[] cnt = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 열
			int m = Integer.parseInt(st.nextToken()); // 행
			int size_n = Integer.parseInt(st.nextToken()); // 열 크기
			int size_m = Integer.parseInt(st.nextToken()); // 행 크기
			int count = 0;
			for(int x = m; x < m + size_m; x++) {
				for(int y = n; y < n + size_n; y++) {
					if(map[x][y] == 0) {
						map[x][y] = i;
						count++;
					}
					else if(map[x][y] < i) {
						cnt[map[x][y]]--;
						map[x][y] = i;
						count++;
					}
				}
			}
			cnt[i] = count;
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.println(cnt[i]);
		}
		
	}

}
