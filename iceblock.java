package code;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class dfsbfs {
	static int N;
	static int M;
	
	static boolean DFS(int[][] map, int i, int j) {
		if(i < 0 || j < 0 || i >= N || j >= M) {
			return false;
		}
		
		if(map[i][j] == 0) {
			map[i][j] = 1;
			DFS(map, i-1, j);
			DFS(map, i+1, j);
			DFS(map, i, j-1);
			DFS(map, i, j+1);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로길이 ( 행의 수 )
		M = Integer.parseInt(st.nextToken()); // 가로길이 ( 열의 수 )
		int[][] map = new int[N][M];
		int result = 0;
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(DFS(map, i, j) == true) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
	
}
