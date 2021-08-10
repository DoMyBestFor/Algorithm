package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1209 {
	static int[][] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i = 1; i <= 10; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			arr = new int[100][100];
			int answer = Integer.MIN_VALUE;
			int sum = 0;
			
			for(int j = 0; j < 100; j++) {
				st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 100; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 행의 합
			for(int j = 0; j < 100; j++) {
				sum = 0;
				for(int k = 0; k < 100; k++) {
					sum += arr[j][k];
				}
				answer = Math.max(answer, sum);
			}
			// 열의 합
			for(int j = 0; j < 100; j++) {
				sum = 0;
				for(int k = 0; k < 100; k++) {
					sum += arr[k][j];
				}
				answer = Math.max(answer, sum);
			}
			
			// 우대각선의 합
			sum = 0;
			int a = 0, b = 0;
			for(int j = 0; j < 100; j++) {
				sum += arr[a+j][b+j];
			}
			answer = Math.max(answer, sum);
			
			// 좌대각선의 합
			sum = 0;
			a = 99; 
			b = 99;
			for(int j = 0; j < 100; j++) {
				sum += arr[a-j][b-j];
			}
			answer = Math.max(answer, sum);
			
			System.out.println("#" + i + " " + answer);
		}
	}

}
