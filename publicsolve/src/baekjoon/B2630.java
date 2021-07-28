import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int white = 0, blue = 0;
	private static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // n은 항상 2^k 형태
		map = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void dfs(int start_row, int start_col, int size) {
		if(result(start_row, start_col, size)) {
			if(map[start_row][start_col] == 0) {
				white++;
			}
			else {
				blue++;
			}
		}
		else {
			// 분할해야 한다면
			dfs(start_row, start_col, size/2);
			dfs(start_row, start_col + size/2, size/2);
			dfs(start_row + size/2, start_col, size/2);
			dfs(start_row + size/2, start_col + size/2, size/2);
		}
	}
	
	public static boolean result(int start_row, int start_col, int size) {
		int temp = map[start_row][start_col];
		for(int i = start_row; i < start_row + size; i++) {
			for(int j = start_col; j < start_col + size; j++) {
				if(map[i][j] != temp) {
					return false;
				}
			}
		}
		return true;
	}
	

}
