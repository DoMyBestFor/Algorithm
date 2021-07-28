package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1961 {
	/*
	 * 배열의 회전은 실제 코딩테스트에서도 자주 쓰이는 스킬
	 * 개념 정리 다시한번 하자
	 * 90도 회전은 (i, j) -> (j, n-i-1)
	 * 180도 회전은 (i, j) -> (n-i-1, n-j-1)
	 * 270도 회전은 (i, j) -> (n-j-1, i)
	 * 
	 * 확인할 때 네 모서리 끝쪽을 확인하고 변의 중간 점 하나만 확인하면 규칙 찾기 수월하다.
	 */
	private static int n;
	private static int[][] arr;
	private static int[][] rotate_90;
	private static int[][] rotate_180;
	private static int[][] rotate_270;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int t = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			arr = new int[n][n];
			
			for(int a = 0; a < n; a++) {
				st = new StringTokenizer(br.readLine());
				for(int b = 0; b < n; b++) {
					arr[a][b] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println("#" + i);
			rot_90();
			rot_180();
			rot_270();
			
			for(int a = 0; a < n; a++) {
				for(int b = 0; b < n; b++) {
					System.out.print(rotate_90[a][b]);
				}
				System.out.print(" ");
				for(int b = 0; b < n; b++) {
					System.out.print(rotate_180[a][b]);
				}
				System.out.print(" ");
				for(int b = 0; b < n; b++) {
					System.out.print(rotate_270[a][b]);
				}
				System.out.println();
			}
			
		}
	}

	public static void rot_90() {
		rotate_90 = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				rotate_90[j][n-i-1] = arr[i][j];
			}
		}
	}
	public static void rot_180() {
		rotate_180 = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				rotate_180[n-i-1][n-j-1] = arr[i][j];
			}
		}
	}
	public static void rot_270() {
		rotate_270 = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				rotate_270[n-j-1][i] = arr[i][j];
			}
		}
	}
}
