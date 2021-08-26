package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2999 {
	/**
	 * N글자의 메세지를 보낼건데
	 * R <= C이고 R * C = N인 R과 C를 고른다. 만약 그런 경우가 여러 개이면 큰 R을 고른다.
	 * R행 C열의 행렬을 만든다.
	 * 
	 * 순서대로 메시지 받아적고
	 * 이번엔 행을 우선으로 해서 다시 받아 적는다.
	 * 
	 * 이걸 해독하는 프로그램 작성
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int N = str.length();
		int R = 1;
		int C = N;
		
		for(int i = 2; i < N; i++) {
			if(i > N / 2) {
				break;
			}
			if(N % i == 0) {
				if(i <= N / i) {
					R = i;
					C = N / i;
				}
			}
		}
		// R과 C를 구해보자
		
		char[][] map = new char[R][C];
		
		int idx = 0;
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				map[j][i] = str.charAt(idx++); 
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		
		System.out.println(sb.toString());
	}

}
