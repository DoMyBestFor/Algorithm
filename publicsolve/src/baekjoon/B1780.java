package baekjoon;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class B1780{
	private static int n; // n은 짝수임
	private static int[][] paper;
	
	private static int[] answer;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // n은 3^k 형태로 주어진다.
		paper = new int[n][n];
		answer = new int[3];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				paper[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, n);
		
		for(int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
	
	public static void dfs(int start_row, int start_col, int size) {
		if(usable(start_row, start_col, size) == 100) {
			// 사용 불가능한 것이라면 
			int new_size = size / 3;
			
			dfs(start_row, start_col, new_size);
			dfs(start_row + new_size, start_col, new_size);
			dfs(start_row + 2 * new_size, start_col, new_size);
			
			dfs(start_row, start_col + new_size, new_size);
			dfs(start_row + new_size, start_col + new_size, new_size);
			dfs(start_row + 2 * new_size, start_col + new_size, new_size);
			
			dfs(start_row, start_col + 2 * new_size, new_size);
			dfs(start_row + new_size, start_col + 2 * new_size, new_size);
			dfs(start_row + 2 * new_size, start_col + 2 * new_size, new_size);
			
		}
		else {
			// 사용 가능한 것이라면
			answer[usable(start_row, start_col, size)]++;
		}
	}
	
	// 사용가능한 종이인지 판별
	// 사용 못하는 것이면 100을 리턴
	public static int usable(int start_row, int start_col, int size) {
		int temp = paper[start_row][start_col];
		for(int i = start_row; i < start_row + size; i++) {
			for(int j = start_col; j < start_col + size; j++) {
				if(temp != paper[i][j]) {
					return 100;
				}
			}
		}
		return temp + 1;
	}
}