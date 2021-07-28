package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2001 {
	/*
	 * 완전탐색
	 */
	private static int[][] map;
	private static int max;
	private static int n, m;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 맵의 크기
			m = Integer.parseInt(st.nextToken()); // 파리채 크기
			map = new int[n][n];
			max = Integer.MIN_VALUE;
			
			for(int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					max = Math.max(max, calculate(a, b));
				}
			}
			
			sb.append("#" + i + " " + max + "\n");
			
		}	
		System.out.println(sb.toString());
	}
	public static int calculate(int a, int b) {
		int sum = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < m; j++) {
				if(a + i >= 0 && a + i < n && b + j >= 0 && b + j < n)
					sum += map[a + i][b + j];
			}
		}
		
		return sum;
	}

}
